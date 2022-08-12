
package ga.gamer234emp.obv.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import ga.gamer234emp.obv.procedures.DimTpINVProcedure;
import ga.gamer234emp.obv.procedures.DimTpCraftedProcedure;
import ga.gamer234emp.obv.procedures.DimTeleportProcedure;
import ga.gamer234emp.obv.init.OblivionModTabs;

public class DimensionTeleporterItem extends Item {
	public DimensionTeleporterItem() {
		super(new Item.Properties().tab(OblivionModTabs.TAB_MINING_DIM_TAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		DimTeleportProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		DimTpCraftedProcedure.execute(entity, itemstack);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DimTpINVProcedure.execute(world, entity, itemstack);
	}
}
