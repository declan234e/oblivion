package dev.declan234e.oblivion.Blocks.BlockEntity;

import dev.declan234e.oblivion.Blocks.Default.BaseBlockEntity;
import dev.declan234e.oblivion.Init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DimensionalTeleporterBlockEntity extends BaseBlockEntity {
    public DimensionalTeleporterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DIMENSIONAL_TELEPORTER_BE.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.oblivion.dimensional_teleporter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }
}
