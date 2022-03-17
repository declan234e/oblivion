
package ga.gamer234emp.obv.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

import ga.gamer234emp.obv.procedures.UrandiaIngotItemIsCraftedsmeltedProcedure;
import ga.gamer234emp.obv.init.OblivionModTabs;

public class UrandiaIngotItem extends Item {
	public UrandiaIngotItem() {
		super(new Item.Properties().tab(OblivionModTabs.TAB_REACTORS).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("urandia_ingot");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		UrandiaIngotItemIsCraftedsmeltedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}
}
