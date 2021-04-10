
package gmz.reactors.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import gmz.reactors.procedures.UrandiaIngotItemIsCraftedsmeltedProcedure;
import gmz.reactors.itemgroup.ReactorsItemGroup;
import gmz.reactors.AtlasMultiModElements;

@AtlasMultiModElements.ModElement.Tag
public class UrandiaIngotItem extends AtlasMultiModElements.ModElement {
	@ObjectHolder("atlas_multi:urandia_ingot")
	public static final Item block = null;
	public UrandiaIngotItem(AtlasMultiModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ReactorsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("urandia_ingot");
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

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UrandiaIngotItemIsCraftedsmeltedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
