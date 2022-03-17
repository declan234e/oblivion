
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import ga.gamer234emp.obv.client.gui.WaterPurifierUiScreen;
import ga.gamer234emp.obv.client.gui.TinyReactorGuiScreen;
import ga.gamer234emp.obv.client.gui.SnowGlobeUiScreen;
import ga.gamer234emp.obv.client.gui.BatUiTestScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OblivionModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(OblivionModMenus.TINY_REACTOR_GUI, TinyReactorGuiScreen::new);
			MenuScreens.register(OblivionModMenus.WATER_PURIFIER_UI, WaterPurifierUiScreen::new);
			MenuScreens.register(OblivionModMenus.SNOW_GLOBE_UI, SnowGlobeUiScreen::new);
			MenuScreens.register(OblivionModMenus.BAT_UI_TEST, BatUiTestScreen::new);
		});
	}
}
