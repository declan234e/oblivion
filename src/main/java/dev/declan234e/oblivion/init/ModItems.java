package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item URANDIA_INGOT = registerItem("urandia_ingot", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item PURIFIED_WATER = registerItem("purified_water", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item FILTER = registerItem("filter", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item REINFORCED_CASING = registerItem("reinforced_casing", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item DIMENSION_TELEPORTER = registerItem("dimension_teleporter", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION_DIMENSIONS)));
    public static final Item EMPTY_MUG = registerItem("empty_mug", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item COFFEE = registerItem("coffee", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item COLD_COFFEE = registerItem("cold_coffee", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item DARK_COFFEE = registerItem("dark_coffee", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item COFFEE_BEANS = registerItem("coffee_beans", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));
    public static final Item COFFEE_POWDER = registerItem("coffee_powder", new Item(new FabricItemSettings().group(ModItemGroup.OBLIVION)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Oblivion.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Oblivion.LOGGER.debug("Reg Mod Items for " + Oblivion.MOD_ID);
    }
}
