package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Oblivion;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oblivion.MOD_ID);


    // Items to add
    public static final RegistryObject<Item> URANDIA_INGOT = ITEMS.register("urandia_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURIFIED_WATER = ITEMS.register("purified_water", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_CASING = ITEMS.register("reinforced_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIMENSION_TELEPORTER = ITEMS.register("dimension_teleporter", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMPTY_MUG = ITEMS.register("empty_mug", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE = ITEMS.register("coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLD_COFFEE = ITEMS.register("cold_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_COFFEE = ITEMS.register("dark_coffee", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register("coffee_powder", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
