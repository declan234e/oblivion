package tas.atlas.procedures;

import tas.atlas.AtlasMultiMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import java.util.Map;

public class TwoRodReturnProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency x for procedure TwoRodReturn!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency y for procedure TwoRodReturn!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency z for procedure TwoRodReturn!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency world for procedure TwoRodReturn!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return ((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "numOfUrandia")) >= 2);
	}
}
