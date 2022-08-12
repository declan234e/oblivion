
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import ga.gamer234emp.obv.block.entity.WaterPurifierBlockEntity;
import ga.gamer234emp.obv.block.entity.TinyReactorState1BlockEntity;
import ga.gamer234emp.obv.block.entity.SolarPanelBlockEntity;
import ga.gamer234emp.obv.block.entity.SmallBatteryBlockEntity;
import ga.gamer234emp.obv.block.entity.MatterFabBlockEntity;
import ga.gamer234emp.obv.block.entity.LargeBatteryUpperBlockEntity;
import ga.gamer234emp.obv.block.entity.LargeBatteryLowerBlockEntity;
import ga.gamer234emp.obv.block.entity.BiomeSnowglobeBlockEntity;
import ga.gamer234emp.obv.OblivionMod;

public class OblivionModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, OblivionMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> TINY_REACTOR_STATE_1 = register("tiny_reactor_state_1",
			OblivionModBlocks.TINY_REACTOR_STATE_1, TinyReactorState1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOLAR_PANEL = register("solar_panel", OblivionModBlocks.SOLAR_PANEL,
			SolarPanelBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WATER_PURIFIER = register("water_purifier", OblivionModBlocks.WATER_PURIFIER,
			WaterPurifierBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SMALL_BATTERY = register("small_battery", OblivionModBlocks.SMALL_BATTERY,
			SmallBatteryBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LARGE_BATTERY_LOWER = register("large_battery_lower",
			OblivionModBlocks.LARGE_BATTERY_LOWER, LargeBatteryLowerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LARGE_BATTERY_UPPER = register("large_battery_upper",
			OblivionModBlocks.LARGE_BATTERY_UPPER, LargeBatteryUpperBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIOME_SNOWGLOBE = register("biome_snowglobe", OblivionModBlocks.BIOME_SNOWGLOBE,
			BiomeSnowglobeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MATTER_FAB = register("matter_fab", OblivionModBlocks.MATTER_FAB,
			MatterFabBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
