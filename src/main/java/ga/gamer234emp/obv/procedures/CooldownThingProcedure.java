package ga.gamer234emp.obv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import ga.gamer234emp.obv.OblivionMod;

public class CooldownThingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OblivionMod.LOGGER.warn("Failed to load dependency world for procedure CooldownThing!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OblivionMod.LOGGER.warn("Failed to load dependency entity for procedure CooldownThing!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				OblivionMod.LOGGER.warn("Failed to load dependency itemstack for procedure CooldownThing!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("cooldown") == true && itemstack.getOrCreateTag().getBoolean("otg") == false) {
			itemstack.getOrCreateTag().putBoolean("otg", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("cooldown start"), (false));
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("cooldown end"), (false));
					}
					itemstack.getOrCreateTag().putBoolean("otg", (false));
					itemstack.getOrCreateTag().putBoolean("cooldown", (false));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 80);
		}
	}
}
