/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Screen.Slots;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class CraftSlot extends SlotItemHandler {
    public CraftSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }
    // makes you not able to put items in the slot. Most useful for output slots
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return false;
    }
}
