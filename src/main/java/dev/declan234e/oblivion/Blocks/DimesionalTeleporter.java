/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Blocks;

import dev.declan234e.oblivion.Blocks.BlockEntity.DimensionalTeleporterBlockEntity;
import dev.declan234e.oblivion.Blocks.BlockEntity.DrinkStationBlockEntity;
import dev.declan234e.oblivion.Blocks.Default.BasicBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class DimesionalTeleporter extends BaseEntityBlock {
    public DimesionalTeleporter(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DimensionalTeleporterBlockEntity(pPos, pState);
    }
}
