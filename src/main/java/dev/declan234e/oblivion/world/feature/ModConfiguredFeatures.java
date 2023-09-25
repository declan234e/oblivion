package dev.declan234e.oblivion.world.feature;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.init.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_LEAD_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LEAD_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> OVERWORLD_URANDIA_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANDIA_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.URANDIA_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LEAD_ORE = ConfiguredFeatures.register("lead_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_LEAD_ORES, 5));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANDIA_ORE = ConfiguredFeatures.register("urandia_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_URANDIA_ORES, 7));

    public static void RegisterConfiguredFeatures() {
        Oblivion.LOGGER.debug("Reg Mod Configured Features for " + Oblivion.MOD_ID);
    }
}
