
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

import ga.gamer234emp.obv.world.inventory.WaterPurifierUiMenu;
import ga.gamer234emp.obv.world.inventory.TinyReactorGuiMenu;
import ga.gamer234emp.obv.world.inventory.SnowGlobeUiMenu;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OblivionModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<TinyReactorGuiMenu> TINY_REACTOR_GUI = register("tiny_reactor_gui",
			(id, inv, extraData) -> new TinyReactorGuiMenu(id, inv, extraData));
	public static final MenuType<WaterPurifierUiMenu> WATER_PURIFIER_UI = register("water_purifier_ui",
			(id, inv, extraData) -> new WaterPurifierUiMenu(id, inv, extraData));
	public static final MenuType<SnowGlobeUiMenu> SNOW_GLOBE_UI = register("snow_globe_ui",
			(id, inv, extraData) -> new SnowGlobeUiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
