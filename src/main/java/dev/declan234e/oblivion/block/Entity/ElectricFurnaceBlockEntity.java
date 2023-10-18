package dev.declan234e.oblivion.block.Entity;

import dev.declan234e.oblivion.init.ModBlockEntities;
import dev.declan234e.oblivion.init.ModMessages;
import dev.declan234e.oblivion.screen.ElectricFurnaceScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class ElectricFurnaceBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(3000, 512, 512) {
        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()) {
                PacketByteBuf data = PacketByteBufs.create();
                data.writeLong(amount);
                data.writeBlockPos(getPos());

                for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                    ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
                }
            }

        }
    };

    protected final PropertyDelegate propertyDelegate;

    private int burnTime;
    private int maxBurnTime = 60;
    private int progress = 0;
    private int maxProgress = 72;

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public ElectricFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ELECTRIC_FURNACE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return ElectricFurnaceBlockEntity.this.progress;
                    case 1: return ElectricFurnaceBlockEntity.this.maxProgress;
                    case 2: return ElectricFurnaceBlockEntity.this.burnTime;
                    case 3: return ElectricFurnaceBlockEntity.this.maxBurnTime;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: ElectricFurnaceBlockEntity.this.progress = value; break;
                    case 1: ElectricFurnaceBlockEntity.this.maxProgress = value; break;
                    case 2: ElectricFurnaceBlockEntity.this.burnTime = value; break;
                    case 3: ElectricFurnaceBlockEntity.this.maxBurnTime = value; break;
                }

            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    public void setEnergyLevel(long energyLevel) {
        this.energyStorage.amount = energyLevel;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Electric Furnace");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ElectricFurnaceScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("electric_furnace.progress", progress);
        nbt.putLong("electric_furnace.energy", energyStorage.amount);
        nbt.putInt("electric_furnace.burntime", burnTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("electric_furnace.progress");
        energyStorage.amount = nbt.getLong("electric_furnace.energy");
        burnTime = nbt.getInt("electric_furnace.burntime");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, ElectricFurnaceBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(entity.isBurning()) {
            --entity.burnTime;

        }

        if(!entity.isBurning() && hasEnoughEnergy(entity) && hasRecipe(entity)) {
            entity.burnTime = entity.maxBurnTime;
            extractEnergy(entity);
        }
        if(state.get(Properties.LIT) != entity.isBurning()) {
            world.setBlockState(blockPos, state.with(Properties.LIT, entity.isBurning()), Block.NOTIFY_ALL);
            ElectricFurnaceBlockEntity.markDirty(world, blockPos, state);
        }


        if(hasRecipe(entity) && entity.isBurning()) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }

    }

    private static void extractEnergy(ElectricFurnaceBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.energyStorage.extract(128, transaction);
            transaction.commit();
        }
    }


    private static boolean hasEnoughEnergy(ElectricFurnaceBlockEntity entity) {
        return entity.energyStorage.amount >= 32;
    }

    private static void craftItem(ElectricFurnaceBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<SmeltingRecipe> recipe = entity.getWorld().getRecipeManager().getFirstMatch(RecipeType.SMELTING, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(0, 1);

            entity.setStack(1, new ItemStack(recipe.get().getOutput().getItem(), entity.getStack(1).getCount() +1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(ElectricFurnaceBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<SmeltingRecipe> match = entity.getWorld().getRecipeManager().getFirstMatch(RecipeType.SMELTING, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(1).getItem() == output || inventory.getStack(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }


}
