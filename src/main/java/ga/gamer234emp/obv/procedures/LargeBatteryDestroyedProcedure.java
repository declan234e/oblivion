package ga.gamer234emp.obv.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LargeBatteryDestroyedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
	}
}
