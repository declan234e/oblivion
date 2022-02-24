
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class OblivionModTabs {
	public static CreativeModeTab TAB_REACTORS;

	public static void load() {
		TAB_REACTORS = new CreativeModeTab("tabreactors") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(OblivionModBlocks.URANDIA_ORE);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
