package dev.declan234e.oblivion.block;

import dev.declan234e.oblivion.block.Entity.AdvancedSolarPanelBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class AdvancedSolarPanelBlock extends SolarPanelBlockBase{


    public AdvancedSolarPanelBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AdvancedSolarPanelBlockEntity(pos, state);
    }
}
