
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import java.util.List;
import java.util.ArrayList;

import ga.gamer234emp.obv.item.UrandiaIngotItem;
import ga.gamer234emp.obv.item.PurifiedWaterItem;
import ga.gamer234emp.obv.item.FilterItem;
import ga.gamer234emp.obv.item.DimensionTeleporterItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OblivionModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item URANDIA_ORE = register(OblivionModBlocks.URANDIA_ORE, OblivionModTabs.TAB_REACTORS);
	public static final Item URANDIA_INGOT = register(new UrandiaIngotItem());
	public static final Item TINY_REACTOR_STATE_1 = register(OblivionModBlocks.TINY_REACTOR_STATE_1, OblivionModTabs.TAB_REACTORS);
	public static final Item FILTER = register(new FilterItem());
	public static final Item SOLAR_PANEL = register(OblivionModBlocks.SOLAR_PANEL, OblivionModTabs.TAB_REACTORS);
	public static final Item WATER_PURIFIER = register(OblivionModBlocks.WATER_PURIFIER, OblivionModTabs.TAB_REACTORS);
	public static final Item PURIFIED_WATER = register(new PurifiedWaterItem());
	public static final Item VICWIN = register(
			new SpawnEggItem(OblivionModEntities.VICWIN, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("vicwin_spawn_egg"));
	public static final Item SMALL_BATTERY = register(OblivionModBlocks.SMALL_BATTERY, OblivionModTabs.TAB_REACTORS);
	public static final Item LARGE_BATTERY_LOWER = register(OblivionModBlocks.LARGE_BATTERY_LOWER, OblivionModTabs.TAB_REACTORS);
	public static final Item LARGE_BATTERY_UPPER = register(OblivionModBlocks.LARGE_BATTERY_UPPER, null);
	public static final Item BIOME_SNOWGLOBE = register(OblivionModBlocks.BIOME_SNOWGLOBE, OblivionModTabs.TAB_REACTORS);
	public static final Item DIMENSION_TELEPORTER = register(new DimensionTeleporterItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
