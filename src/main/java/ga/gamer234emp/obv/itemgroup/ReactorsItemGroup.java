
package ga.gamer234emp.obv.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import ga.gamer234emp.obv.block.UrandiaOreBlock;
import ga.gamer234emp.obv.OblivionModElements;

@OblivionModElements.ModElement.Tag
public class ReactorsItemGroup extends OblivionModElements.ModElement {
	public ReactorsItemGroup(OblivionModElements instance) {
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
