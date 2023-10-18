package dev.declan234e.oblivion.screen.slot;

import dev.declan234e.oblivion.init.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class RWaterSlot extends Slot {
    public RWaterSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() == Items.WATER_BUCKET || stack.getItem() == ModItems.PURIFIED_WATER;
    }
}
