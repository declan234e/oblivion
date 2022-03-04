package ga.gamer234emp.obv.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Util;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import ga.gamer234emp.obv.OblivionMod;

public class DimTeleportProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OblivionMod.LOGGER.warn("Failed to load dependency world for procedure DimTeleport!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OblivionMod.LOGGER.warn("Failed to load dependency x for procedure DimTeleport!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OblivionMod.LOGGER.warn("Failed to load dependency y for procedure DimTeleport!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OblivionMod.LOGGER.warn("Failed to load dependency z for procedure DimTeleport!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OblivionMod.LOGGER.warn("Failed to load dependency entity for procedure DimTeleport!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				OblivionMod.LOGGER.warn("Failed to load dependency itemstack for procedure DimTeleport!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity.isSneaking() && (entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("oblivion:mining_dim")))) {
			itemstack.getOrCreateTag().putDouble("mineDimXPOS", x);
			itemstack.getOrCreateTag().putDouble("mineDimYPOS", y);
			itemstack.getOrCreateTag().putDouble("mineDimZPOS", z);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("mining dimension tp cords set"), (false));
			}
			itemstack.getOrCreateTag().putBoolean("mineTpSET", (true));
		}
		if (entity.isSneaking() && (entity.world.getDimensionKey()) == (World.OVERWORLD)) {
			itemstack.getOrCreateTag().putDouble("overDimXPOS", x);
			itemstack.getOrCreateTag().putDouble("overDimYPOS", y);
			itemstack.getOrCreateTag().putDouble("overDimZPOS", z);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("overworld tp cords set"), (false));
			}
			itemstack.getOrCreateTag().putBoolean("overTpSET", (true));
		}
		if (entity.isSneaking() == false) {
			if ((entity.world.getDimensionKey()) == (World.OVERWORLD) && itemstack.getOrCreateTag().getBoolean("cooldown") == false) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Player teleporting expect lag"), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
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

						TpToMineProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 60);
			} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD) && itemstack.getOrCreateTag().getBoolean("cooldown") == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("please wait before teleporting again"), (false));
				}
			}
			if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("oblivion:mining_dim")))
					&& itemstack.getOrCreateTag().getBoolean("cooldown") == false) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Player teleporting expect lag"), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
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

						TpToOverProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 60);
			} else if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
					new ResourceLocation("oblivion:mining_dim"))) && itemstack.getOrCreateTag().getBoolean("cooldown") == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("please wait before teleporting again"), (false));
				}
			}
			if ((entity.world.getDimensionKey()) == (World.THE_NETHER) && itemstack.getOrCreateTag().getBoolean("cooldown") == false) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent("player has just done something that will most likley kill expect lag"), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
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

						TpToMineNetherProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 60);
			} else if ((entity.world.getDimensionKey()) == (World.THE_NETHER) && itemstack.getOrCreateTag().getBoolean("cooldown") == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("please wait before teleporting again"), (false));
				}
			}
		}
	}
}
