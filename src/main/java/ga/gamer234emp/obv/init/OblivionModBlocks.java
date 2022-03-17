
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

import ga.gamer234emp.obv.block.WaterPurifierBlock;
import ga.gamer234emp.obv.block.UrandiaOreBlock;
import ga.gamer234emp.obv.block.TinyReactorState1Block;
import ga.gamer234emp.obv.block.SolarPanelBlock;
import ga.gamer234emp.obv.block.SmallBatteryBlock;
import ga.gamer234emp.obv.block.LargeBatteryUpperBlock;
import ga.gamer234emp.obv.block.LargeBatteryLowerBlock;
import ga.gamer234emp.obv.block.BiomeSnowglobeBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OblivionModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block URANDIA_ORE = register(new UrandiaOreBlock());
	public static final Block TINY_REACTOR_STATE_1 = register(new TinyReactorState1Block());
	public static final Block SOLAR_PANEL = register(new SolarPanelBlock());
	public static final Block WATER_PURIFIER = register(new WaterPurifierBlock());
	public static final Block SMALL_BATTERY = register(new SmallBatteryBlock());
	public static final Block LARGE_BATTERY_LOWER = register(new LargeBatteryLowerBlock());
	public static final Block LARGE_BATTERY_UPPER = register(new LargeBatteryUpperBlock());
	public static final Block BIOME_SNOWGLOBE = register(new BiomeSnowglobeBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			TinyReactorState1Block.registerRenderLayer();
			SolarPanelBlock.registerRenderLayer();
			WaterPurifierBlock.registerRenderLayer();
			SmallBatteryBlock.registerRenderLayer();
			LargeBatteryLowerBlock.registerRenderLayer();
			LargeBatteryUpperBlock.registerRenderLayer();
			BiomeSnowglobeBlock.registerRenderLayer();
		}
	}
}
