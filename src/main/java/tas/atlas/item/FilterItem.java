
package tas.atlas.item;

import tas.atlas.itemgroup.ReactorsItemGroup;
import tas.atlas.AtlasMultiModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@AtlasMultiModElements.ModElement.Tag
public class FilterItem extends AtlasMultiModElements.ModElement {
	@ObjectHolder("atlas_multi:filter")
	public static final Item block = null;
	public FilterItem(AtlasMultiModElements instance) {
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
