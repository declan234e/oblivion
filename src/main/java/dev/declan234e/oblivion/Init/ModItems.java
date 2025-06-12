/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Items.GuideItem;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oblivion.MOD_ID);


    // Hot Coffee
    public static final RegistryObject<Item> REGULAR_COFFEE = ITEMS.register("regular_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_COFFEE = ITEMS.register("dark_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_COFFEE = ITEMS.register("magma_coffee", () -> new Item(new Item.Properties()));


    // Cold Coffee
    public static final RegistryObject<Item> COLD_REGULAR_COFFEE = ITEMS.register("cold_regular_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLD_DARK_COFFEE = ITEMS.register("cold_dark_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLD_MAGMA_COFFEE = ITEMS.register("cold_magma_coffee", () -> new Item(new Item.Properties()));

    // Other
    public static final RegistryObject<Item> EMPTY_MUG = ITEMS.register("empty_mug", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new ItemNameBlockItem(ModBlocks.COFFEE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register("coffee_powder", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUIDE = ITEMS.register("guide", () -> new GuideItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
