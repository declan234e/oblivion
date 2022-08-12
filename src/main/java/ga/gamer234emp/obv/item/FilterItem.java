
package ga.gamer234emp.obv.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import ga.gamer234emp.obv.init.OblivionModTabs;

public class FilterItem extends Item {
	public FilterItem() {
		super(new Item.Properties().tab(OblivionModTabs.TAB_REACTORS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
