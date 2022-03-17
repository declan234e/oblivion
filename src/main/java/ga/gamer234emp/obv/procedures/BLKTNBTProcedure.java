package ga.gamer234emp.obv.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class BLKTNBTProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("age")instanceof IntegerProperty _ip ? blockstate.getValue(_ip) : -1) == 1) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("numOfUrandia", 1);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("age")instanceof IntegerProperty _ip
				? blockstate.getValue(_ip)
				: -1) == 2) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("numOfUrandia", 2);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("age")instanceof IntegerProperty _ip
				? blockstate.getValue(_ip)
				: -1) == 3) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("numOfUrandia", 3);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("age")instanceof IntegerProperty _ip
				? blockstate.getValue(_ip)
				: -1) == 4) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("numOfUrandia", 4);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("age")instanceof IntegerProperty _ip
				? blockstate.getValue(_ip)
				: -1) == 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("numOfUrandia", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
