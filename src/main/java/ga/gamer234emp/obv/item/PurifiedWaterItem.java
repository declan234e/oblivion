
package ga.gamer234emp.obv.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import ga.gamer234emp.obv.init.OblivionModTabs;

public class PurifiedWaterItem extends Item {
	public PurifiedWaterItem() {
		super(new Item.Properties().tab(OblivionModTabs.TAB_REACTORS).stacksTo(16).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(0).saturationMod(0.3f).alwaysEat()

						.build()));
		setRegistryName("purified_water");
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}
}
