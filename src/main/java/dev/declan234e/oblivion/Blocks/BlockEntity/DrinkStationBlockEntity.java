/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Blocks.BlockEntity;

import dev.declan234e.oblivion.Blocks.Default.BaseFurnaceLikeBlock;
import dev.declan234e.oblivion.Init.ModBlockEntities;
import dev.declan234e.oblivion.Init.ModItems;
import dev.declan234e.oblivion.Screen.DrinkStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DrinkStationBlockEntity extends BaseFurnaceLikeBlock {

    public DrinkStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DRINK_STATION_BE.get(), pPos, pBlockState, 3);

    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.oblivion.drink_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new DrinkStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("drink_station.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("drink_station.progress");
    }

    @Override
    public boolean hasRecipe() {
        boolean hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.FILTER.get();
        ItemStack result = new ItemStack(ModItems.COFFEE_POWDER.get());

        return hasCraftingItem && canInsertAmountInOut(result.getCount()) && canInsertItemInOut(result.getItem());
    }

    @Override
    public void craftItem() {
        ItemStack result = new ItemStack(ModItems.COFFEE_POWDER.get(), 1);
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(), this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }
}
