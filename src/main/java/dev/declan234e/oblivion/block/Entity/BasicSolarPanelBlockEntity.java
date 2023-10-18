package dev.declan234e.oblivion.block.Entity;

import dev.declan234e.oblivion.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BasicSolarPanelBlockEntity extends SolarPanelBlockEntityBase{
    public BasicSolarPanelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BASIC_SOLAR_PANEL, pos, state);
    }
}
