package dev.declan234e.oblivion.block.Entity;

import dev.declan234e.oblivion.init.ModBlockEntities;
import dev.declan234e.oblivion.init.ModItems;
import dev.declan234e.oblivion.init.ModMessages;
import dev.declan234e.oblivion.screen.TinyReactorScreenHandler;
import dev.declan234e.oblivion.util.CustomProperties;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.telemetry.TelemetrySender;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class TinyReactorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

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

    private int temp = 20;
    private int maxTemp = 1200;
    private int rods = 0;
    private boolean active = false;

    public TinyReactorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TINY_REACTOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return TinyReactorBlockEntity.this.temp;
                    case 1: return TinyReactorBlockEntity.this.maxTemp;
                    case 2: return TinyReactorBlockEntity.this.rods;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: TinyReactorBlockEntity.this.temp = value; break;
                    case 1: TinyReactorBlockEntity.this.maxTemp = value; break;
                    case 2: TinyReactorBlockEntity.this.rods = value; break;
                }

            }

            @Override
            public int size() {
                return 3;
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



    private boolean ValidRodsNum() {
        return this.rods < 5 && this.rods >= 0;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Tiny Reactor");
    }

    private void rodIncrease(){
        this.rods = this.rods + 1;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, TinyReactorBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        if(hasRod(entity)) {
            if(entity.rods < 4) {
                takeRod(entity);
                entity.rodIncrease();
            }
        }

        if(!entity.ValidRodsNum()) {
            entity.active = false;
        }

        if(state.get(CustomProperties.ACTIVE) != entity.active) {
            world.setBlockState(blockPos, state.with(CustomProperties.ACTIVE, entity.active), Block.NOTIFY_ALL);
            TinyReactorBlockEntity.markDirty(world, blockPos, state);
        }

        if(state.get(CustomProperties.RODS) != entity.rods && entity.ValidRodsNum()) {
            world.setBlockState(blockPos, state.with(CustomProperties.RODS, entity.rods), Block.NOTIFY_ALL);
            TinyReactorBlockEntity.markDirty(world, blockPos, state);
        }
    }

    private static void takeRod(TinyReactorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRod(entity)) {
            entity.removeStack(0, 1);

        }
    }

    public static void makeActive(TinyReactorBlockEntity entity) {
        if(entity.ValidRodsNum()) {
            if(entity.active){
                entity.active = false;
            }
            if (!entity.active) {
                entity.active = true;
            }


        }
    }

    private static boolean hasRod(TinyReactorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        return entity.getStack(0).getItem() == ModItems.URANDIA_INGOT;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new TinyReactorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }
    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("tiny_reactor.temp", temp);
        nbt.putInt("tiny_reactor.rods", rods);
        nbt.putLong("tiny_reactor.energy", energyStorage.amount);
        nbt.putBoolean("tiny_reactor.active", active);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        temp = nbt.getInt("tiny_reactor.temp");
        rods = nbt.getInt("tiny_reactor.rods");
        energyStorage.amount = nbt.getLong("tiny_reactor.energy");
        active = nbt.getBoolean("tiny_reactor.active");
    }
}
