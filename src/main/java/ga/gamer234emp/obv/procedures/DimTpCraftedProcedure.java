package ga.gamer234emp.obv.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import ga.gamer234emp.obv.OblivionMod;

public class DimTpCraftedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				OblivionMod.LOGGER.warn("Failed to load dependency itemstack for procedure DimTpCrafted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putBoolean("otg", (false));
	}
}
