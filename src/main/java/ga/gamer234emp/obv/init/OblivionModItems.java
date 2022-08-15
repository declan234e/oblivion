
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import ga.gamer234emp.obv.item.UrandiaIngotItem;
import ga.gamer234emp.obv.item.ReinforcedCasingItem;
import ga.gamer234emp.obv.item.PurifiedWaterItem;
import ga.gamer234emp.obv.item.FilterItem;
import ga.gamer234emp.obv.item.DimensionTeleporterItem;
import ga.gamer234emp.obv.OblivionMod;

public class OblivionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, OblivionMod.MODID);
	public static final RegistryObject<Item> URANDIA_ORE = block(OblivionModBlocks.URANDIA_ORE, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> URANDIA_INGOT = REGISTRY.register("urandia_ingot", () -> new UrandiaIngotItem());
	public static final RegistryObject<Item> TINY_REACTOR_STATE_1 = block(OblivionModBlocks.TINY_REACTOR_STATE_1, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> FILTER = REGISTRY.register("filter", () -> new FilterItem());
	public static final RegistryObject<Item> SOLAR_PANEL = block(OblivionModBlocks.SOLAR_PANEL, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> WATER_PURIFIER = block(OblivionModBlocks.WATER_PURIFIER, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> SMALL_BATTERY = block(OblivionModBlocks.SMALL_BATTERY, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> LARGE_BATTERY_LOWER = block(OblivionModBlocks.LARGE_BATTERY_LOWER, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> LARGE_BATTERY_UPPER = block(OblivionModBlocks.LARGE_BATTERY_UPPER, null);
	public static final RegistryObject<Item> BIOME_SNOWGLOBE = block(OblivionModBlocks.BIOME_SNOWGLOBE, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> DIMENSION_TELEPORTER = REGISTRY.register("dimension_teleporter", () -> new DimensionTeleporterItem());
	public static final RegistryObject<Item> MATTER_FAB = block(OblivionModBlocks.MATTER_FAB, OblivionModTabs.TAB_REACTORS);
	public static final RegistryObject<Item> REINFORCED_CASING = REGISTRY.register("reinforced_casing", () -> new ReinforcedCasingItem());
	public static final RegistryObject<Item> PURIFIED_WATER = REGISTRY.register("purified_water", () -> new PurifiedWaterItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
