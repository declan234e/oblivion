package ga.gamer234emp.obv.procedures;

import net.minecraft.world.item.ItemStack;

public class DimTpCraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("otg", (false));
	}
}
