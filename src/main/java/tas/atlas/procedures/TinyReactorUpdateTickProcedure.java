package tas.atlas.procedures;

import tas.atlas.AtlasMultiMod;

import net.minecraft.world.IWorld;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

public class TinyReactorUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency blockstate for procedure TinyReactorUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency x for procedure TinyReactorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency y for procedure TinyReactorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency z for procedure TinyReactorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AtlasMultiMod.LOGGER.warn("Failed to load dependency world for procedure TinyReactorUpdateTick!");
			return;
		}
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("blockstate", blockstate);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			CheckForIngotProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			CheckForFilterProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			TempSystemProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			CheckForWaterProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			WaterSysProcedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			WDReturn2Procedure.executeProcedure($_dependencies);
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("blockstate", blockstate);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			BLKTNBTProcedure.executeProcedure($_dependencies);
		}
	}
}
