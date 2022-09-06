
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.biome.Biome;

import ga.gamer234emp.obv.world.biome.MiningDimBBiome;
import ga.gamer234emp.obv.world.biome.BiomeTestBiome;
import ga.gamer234emp.obv.OblivionMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OblivionModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, OblivionMod.MOD_ID);
	public static final RegistryObject<Biome> MINING_DIM_B = REGISTRY.register("mining_dim_b", () -> MiningDimBBiome.createBiome());
	public static final RegistryObject<Biome> BIOME_TEST = REGISTRY.register("biome_test", () -> BiomeTestBiome.createBiome());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MiningDimBBiome.init();
			BiomeTestBiome.init();
		});
	}
}
