
package obl.obliv.item;

import obl.obliv.itemgroup.ReactorsItemGroup;
import obl.obliv.OblivionModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@OblivionModElements.ModElement.Tag
public class PurifiedWaterItem extends OblivionModElements.ModElement {
	@ObjectHolder("oblivion:purified_water")
	public static final Item block = null;
	public PurifiedWaterItem(OblivionModElements instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ReactorsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("purified_water");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}
	}
}
