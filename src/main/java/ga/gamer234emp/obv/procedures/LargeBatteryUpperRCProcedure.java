package ga.gamer234emp.obv.procedures;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import ga.gamer234emp.obv.OblivionMod;

public class LargeBatteryUpperRCProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OblivionMod.LOGGER.warn("Failed to load dependency x for procedure LargeBatteryUpperRC!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OblivionMod.LOGGER.warn("Failed to load dependency y for procedure LargeBatteryUpperRC!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OblivionMod.LOGGER.warn("Failed to load dependency z for procedure LargeBatteryUpperRC!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OblivionMod.LOGGER.warn("Failed to load dependency entity for procedure LargeBatteryUpperRC!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			Entity _ent = entity;
			BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
			_ent.world.getBlockState(_bp).getBlock().onBlockActivated(_ent.world.getBlockState(_bp), _ent.world, _bp, (PlayerEntity) entity,
					Hand.MAIN_HAND, BlockRayTraceResult.createMiss(new Vector3d(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
		}
	}
}
