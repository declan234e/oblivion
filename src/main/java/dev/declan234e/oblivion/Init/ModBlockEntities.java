/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Blocks.BlockEntity.CoffeeGrinderBlockEntity;
import dev.declan234e.oblivion.Blocks.BlockEntity.DimensionalTeleporterBlockEntity;
import dev.declan234e.oblivion.Blocks.BlockEntity.DrinkStationBlockEntity;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Oblivion.MOD_ID);

    public static final RegistryObject<BlockEntityType<CoffeeGrinderBlockEntity>> COFFEE_GRINDER_BE = BLOCK_ENTITIES.register("coffee_grinder_be", () -> BlockEntityType.Builder.of(CoffeeGrinderBlockEntity::new, ModBlocks.COFFEE_GRINDER.get()).build(null));
    public static final RegistryObject<BlockEntityType<DrinkStationBlockEntity>> DRINK_STATION_BE = BLOCK_ENTITIES.register("drink_station_be", () -> BlockEntityType.Builder.of(DrinkStationBlockEntity::new, ModBlocks.DRINK_STATION.get()).build(null));
    public static final RegistryObject<BlockEntityType<DimensionalTeleporterBlockEntity>> DIMENSIONAL_TELEPORTER_BE = BLOCK_ENTITIES.register("dimensional_teleporter_be", () -> BlockEntityType.Builder.of(DimensionalTeleporterBlockEntity::new, ModBlocks.DIMENSIONAL_TELEPORTER.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
