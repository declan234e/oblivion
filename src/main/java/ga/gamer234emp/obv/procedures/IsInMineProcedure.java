package ga.gamer234emp.obv.procedures;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;

import java.util.Map;

import ga.gamer234emp.obv.OblivionMod;

public class IsInMineProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OblivionMod.LOGGER.warn("Failed to load dependency entity for procedure IsInMine!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("oblivion:mining_dim")));
	}
}
