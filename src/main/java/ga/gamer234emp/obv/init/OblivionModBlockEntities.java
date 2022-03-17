
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

import ga.gamer234emp.obv.block.entity.WaterPurifierBlockEntity;
import ga.gamer234emp.obv.block.entity.TinyReactorState1BlockEntity;
import ga.gamer234emp.obv.block.entity.SolarPanelBlockEntity;
import ga.gamer234emp.obv.block.entity.SmallBatteryBlockEntity;
import ga.gamer234emp.obv.block.entity.LargeBatteryUpperBlockEntity;
import ga.gamer234emp.obv.block.entity.LargeBatteryLowerBlockEntity;
import ga.gamer234emp.obv.block.entity.BiomeSnowglobeBlockEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OblivionModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> TINY_REACTOR_STATE_1 = register("oblivion:tiny_reactor_state_1", OblivionModBlocks.TINY_REACTOR_STATE_1,
			TinyReactorState1BlockEntity::new);
	public static final BlockEntityType<?> SOLAR_PANEL = register("oblivion:solar_panel", OblivionModBlocks.SOLAR_PANEL, SolarPanelBlockEntity::new);
	public static final BlockEntityType<?> WATER_PURIFIER = register("oblivion:water_purifier", OblivionModBlocks.WATER_PURIFIER,
			WaterPurifierBlockEntity::new);
	public static final BlockEntityType<?> SMALL_BATTERY = register("oblivion:small_battery", OblivionModBlocks.SMALL_BATTERY,
			SmallBatteryBlockEntity::new);
	public static final BlockEntityType<?> LARGE_BATTERY_LOWER = register("oblivion:large_battery_lower", OblivionModBlocks.LARGE_BATTERY_LOWER,
			LargeBatteryLowerBlockEntity::new);
	public static final BlockEntityType<?> LARGE_BATTERY_UPPER = register("oblivion:large_battery_upper", OblivionModBlocks.LARGE_BATTERY_UPPER,
			LargeBatteryUpperBlockEntity::new);
	public static final BlockEntityType<?> BIOME_SNOWGLOBE = register("oblivion:biome_snowglobe", OblivionModBlocks.BIOME_SNOWGLOBE,
			BiomeSnowglobeBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
