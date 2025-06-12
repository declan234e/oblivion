/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.Screen.CoffeeGrinderMenu;
import dev.declan234e.oblivion.Screen.DrinkStationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Oblivion.MOD_ID);

    public static final RegistryObject<MenuType<CoffeeGrinderMenu>> COFFEE_GRINDER_MENU = registerMenuTypes("coffee_grinder_menu", CoffeeGrinderMenu::new);
    public static final RegistryObject<MenuType<DrinkStationMenu>> DRINK_STATION_MENU = registerMenuTypes("drink_station_menu", DrinkStationMenu::new);


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
