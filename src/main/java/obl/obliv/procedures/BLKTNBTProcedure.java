package obl.obliv.procedures;

import obl.obliv.OblivionMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.state.IntegerProperty;
import net.minecraft.block.BlockState;

import java.util.Map;

public class BLKTNBTProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OblivionMod.LOGGER.warn("Failed to load dependency world for procedure BLKTNBT!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OblivionMod.LOGGER.warn("Failed to load dependency x for procedure BLKTNBT!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OblivionMod.LOGGER.warn("Failed to load dependency y for procedure BLKTNBT!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OblivionMod.LOGGER.warn("Failed to load dependency z for procedure BLKTNBT!");
			return;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				OblivionMod.LOGGER.warn("Failed to load dependency blockstate for procedure BLKTNBT!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		if ((new Object() {
			public int get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
			}
		}.get(blockstate, "age")) == 1) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("numOfUrandia", 1);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((new Object() {
			public int get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
			}
		}.get(blockstate, "age")) == 2) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("numOfUrandia", 2);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((new Object() {
			public int get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
			}
		}.get(blockstate, "age")) == 3) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("numOfUrandia", 3);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((new Object() {
			public int get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
			}
		}.get(blockstate, "age")) == 4) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("numOfUrandia", 4);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((new Object() {
			public int get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
			}
		}.get(blockstate, "age")) == 0) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("numOfUrandia", 0);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
