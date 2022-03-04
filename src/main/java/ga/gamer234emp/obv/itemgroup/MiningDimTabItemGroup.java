
package ga.gamer234emp.obv.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import ga.gamer234emp.obv.OblivionModElements;

@OblivionModElements.ModElement.Tag
public class MiningDimTabItemGroup extends OblivionModElements.ModElement {
	public MiningDimTabItemGroup(OblivionModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmining_dim_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.DIAMOND_PICKAXE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
