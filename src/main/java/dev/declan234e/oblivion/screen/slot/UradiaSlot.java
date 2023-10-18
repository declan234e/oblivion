package dev.declan234e.oblivion.screen.slot;

import dev.declan234e.oblivion.init.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class UradiaSlot extends Slot {
    public UradiaSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() == ModItems.URANDIA_INGOT;
    }
}
