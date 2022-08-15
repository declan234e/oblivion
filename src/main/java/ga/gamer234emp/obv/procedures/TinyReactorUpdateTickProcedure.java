package ga.gamer234emp.obv.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

public class TinyReactorUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		CheckForIngotProcedure.execute(world, x, y, z, blockstate);
		CheckForFilterProcedure.execute(world, x, y, z);
		TempSystemProcedure.execute(world, x, y, z);
		CheckForWaterProcedure.execute(world, x, y, z);
		WDReturn2Procedure.execute(world, x, y, z);
		BLKTNBTProcedure.execute(world, x, y, z, blockstate);
		TMeltdownProcedure.execute(world, x, y, z);
		EnergySystemProcedure.execute(world, x, y, z);
		WaterSysProcedure.execute(world, x, y, z);
	}
}
