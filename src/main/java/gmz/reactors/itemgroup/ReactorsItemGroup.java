
package gmz.reactors.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import gmz.reactors.block.UrandiaOreBlock;
import gmz.reactors.AtlasMultiModElements;

@AtlasMultiModElements.ModElement.Tag
public class ReactorsItemGroup extends AtlasMultiModElements.ModElement {
	public ReactorsItemGroup(AtlasMultiModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabreactors") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(UrandiaOreBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
