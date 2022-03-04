package ga.gamer234emp.obv.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;

import ga.gamer234emp.obv.OblivionMod;

public class IsInOverProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OblivionMod.LOGGER.warn("Failed to load dependency entity for procedure IsInOver!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (entity.world.getDimensionKey()) == (World.OVERWORLD);
	}
}
