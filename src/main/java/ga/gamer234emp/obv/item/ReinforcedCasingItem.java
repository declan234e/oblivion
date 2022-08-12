
package ga.gamer234emp.obv.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import ga.gamer234emp.obv.init.OblivionModTabs;

public class ReinforcedCasingItem extends Item {
	public ReinforcedCasingItem() {
		super(new Item.Properties().tab(OblivionModTabs.TAB_REACTORS).stacksTo(16).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}
