
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import ga.gamer234emp.obv.block.WaterPurifierBlock;
import ga.gamer234emp.obv.block.UrandiaOreBlock;
import ga.gamer234emp.obv.block.TinyReactorState1Block;
import ga.gamer234emp.obv.block.SolarPanelBlock;
import ga.gamer234emp.obv.block.SmallBatteryBlock;
import ga.gamer234emp.obv.block.LargeBatteryUpperBlock;
import ga.gamer234emp.obv.block.LargeBatteryLowerBlock;
import ga.gamer234emp.obv.block.BiomeSnowglobeBlock;
import ga.gamer234emp.obv.OblivionMod;

public class OblivionModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, OblivionMod.MOD_ID);
	public static final RegistryObject<Block> URANDIA_ORE = REGISTRY.register("urandia_ore", () -> new UrandiaOreBlock());
	public static final RegistryObject<Block> TINY_REACTOR_STATE_1 = REGISTRY.register("tiny_reactor_state_1", () -> new TinyReactorState1Block());
	public static final RegistryObject<Block> SOLAR_PANEL = REGISTRY.register("solar_panel", () -> new SolarPanelBlock());
	public static final RegistryObject<Block> WATER_PURIFIER = REGISTRY.register("water_purifier", () -> new WaterPurifierBlock());
	public static final RegistryObject<Block> SMALL_BATTERY = REGISTRY.register("small_battery", () -> new SmallBatteryBlock());
	public static final RegistryObject<Block> LARGE_BATTERY_LOWER = REGISTRY.register("large_battery_lower", () -> new LargeBatteryLowerBlock());
	public static final RegistryObject<Block> LARGE_BATTERY_UPPER = REGISTRY.register("large_battery_upper", () -> new LargeBatteryUpperBlock());
	public static final RegistryObject<Block> BIOME_SNOWGLOBE = REGISTRY.register("biome_snowglobe", () -> new BiomeSnowglobeBlock());

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
