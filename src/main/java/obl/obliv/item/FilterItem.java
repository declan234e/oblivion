
package obl.obliv.item;

import obl.obliv.itemgroup.ReactorsItemGroup;
import obl.obliv.OblivionModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@OblivionModElements.ModElement.Tag
public class FilterItem extends OblivionModElements.ModElement {
	@ObjectHolder("oblivion:filter")
	public static final Item block = null;
	public FilterItem(OblivionModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ReactorsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("filter");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
