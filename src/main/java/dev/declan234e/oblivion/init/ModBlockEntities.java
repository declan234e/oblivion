package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.block.Entity.ElectricFurnaceBlockEntity;
import dev.declan234e.oblivion.block.Entity.MatterFabBlockEntity;
import dev.declan234e.oblivion.block.Entity.WaterPurifierBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {
    public static BlockEntityType<MatterFabBlockEntity> MATTER_FAB;
    public static BlockEntityType<WaterPurifierBlockEntity> WATER_PURIFIER;
    public static BlockEntityType<ElectricFurnaceBlockEntity> ELECTRIC_FURNACE;

    public static void registerBlockEntities() {
        MATTER_FAB = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Oblivion.MOD_ID, "matter_fab"), FabricBlockEntityTypeBuilder.create(MatterFabBlockEntity::new, ModBlocks.MATTER_FAB).build(null));
        WATER_PURIFIER = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Oblivion.MOD_ID, "water_purifier"), FabricBlockEntityTypeBuilder.create(WaterPurifierBlockEntity::new, ModBlocks.WATER_PURIFIER).build(null));
        ELECTRIC_FURNACE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Oblivion.MOD_ID, "electric_furnace"), FabricBlockEntityTypeBuilder.create(ElectricFurnaceBlockEntity::new, ModBlocks.ELECTRIC_FURNACE).build(null));

        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, ELECTRIC_FURNACE);

        Oblivion.LOGGER.debug("Reg Mod Block Entities for " + Oblivion.MOD_ID);
    }
}
