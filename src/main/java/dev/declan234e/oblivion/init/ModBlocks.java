package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block URANDIA_ORE = registerBlock("urandia_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3F).requiresTool(), UniformIntProvider.create(4, 8)), ModItemGroup.OBLIVION);
    public static final Block LEAD_ORE = registerBlock("lead_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(3F).requiresTool()), ModItemGroup.OBLIVION);
    public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.5F).requiresTool()), ModItemGroup.OBLIVION);
    public static final Block MATTER_FAB = registerBlock("matter_fab", new MatterFabBlock(FabricBlockSettings.of(Material.METAL).strength(7F).requiresTool()), ModItemGroup.OBLIVION);
    public static final Block BIOME_SNOWGLOBE = registerBlock("biome_snowglobe", new BiomeSnowglobeBlock(FabricBlockSettings.of(Material.METAL).strength(4F).requiresTool().nonOpaque()), ModItemGroup.OBLIVION);
    public static final Block WATER_PURIFIER = registerBlock("water_purifier", new WaterPurifierBlock(FabricBlockSettings.of(Material.METAL).strength(4F).requiresTool().nonOpaque()), ModItemGroup.OBLIVION);
    public static final Block TINY_REACTOR = registerBlock("tiny_reactor", new TinyReactorBlock(FabricBlockSettings.of(Material.METAL).strength(4F).requiresTool().nonOpaque()), ModItemGroup.OBLIVION);
    public static final Block ELECTRIC_FURNACE = registerBlock("electric_furnace", new ElectricFurnaceBlock(FabricBlockSettings.of(Material.METAL).strength(4F).requiresTool()), ModItemGroup.OBLIVION);
    public static final Block BASIC_SOLAR_PANEL = registerBlock("basic_solar_panel", new BasicSolarPanelBlock(FabricBlockSettings.of(Material.METAL).strength(3F).requiresTool().nonOpaque()), ModItemGroup.OBLIVION);
    public static final Block ADVANCED_SOLAR_PANEL = registerBlock("advanced_solar_panel", new AdvancedSolarPanelBlock(FabricBlockSettings.of(Material.METAL).strength(3F).requiresTool().nonOpaque()), ModItemGroup.OBLIVION);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Oblivion.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Oblivion.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        Oblivion.LOGGER.debug("Reg Mod Blocks for " + Oblivion.MOD_ID);
    }
}
