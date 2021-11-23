
package tas.atlas.itemgroup;

import tas.atlas.block.UrandiaOreBlock;
import tas.atlas.AtlasMultiModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

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
				return new ItemStack(UrandiaOreBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
