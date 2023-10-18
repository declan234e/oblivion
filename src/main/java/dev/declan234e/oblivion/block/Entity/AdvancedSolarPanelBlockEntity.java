package dev.declan234e.oblivion.block.Entity;

import dev.declan234e.oblivion.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class AdvancedSolarPanelBlockEntity extends SolarPanelBlockEntityBase{
    public AdvancedSolarPanelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ADVANCED_SOLAR_PANEL, pos, state);
    }
}
