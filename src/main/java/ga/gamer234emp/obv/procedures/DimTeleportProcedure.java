package ga.gamer234emp.obv.procedures;

import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.Registry;
import net.minecraft.Util;

public class DimTeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()
				&& (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("oblivion:mining_dim")))) {
			itemstack.getOrCreateTag().putDouble("mineDimXPOS", x);
			itemstack.getOrCreateTag().putDouble("mineDimYPOS", y);
			itemstack.getOrCreateTag().putDouble("mineDimZPOS", z);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("mining dimension tp cords set"), (false));
			itemstack.getOrCreateTag().putBoolean("mineTpSET", (true));
		}
		if (entity.isShiftKeyDown() && (entity.level.dimension()) == (Level.OVERWORLD)) {
			itemstack.getOrCreateTag().putDouble("overDimXPOS", x);
			itemstack.getOrCreateTag().putDouble("overDimYPOS", y);
			itemstack.getOrCreateTag().putDouble("overDimZPOS", z);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("overworld tp cords set"), (false));
			itemstack.getOrCreateTag().putBoolean("overTpSET", (true));
		}
		if (entity.isShiftKeyDown() == false) {
			if ((entity.level.dimension()) == (Level.OVERWORLD) && itemstack.getOrCreateTag().getBoolean("cooldown") == false) {
				if (!world.isClientSide()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().broadcastMessage(new TextComponent("Player teleporting expect lag"), ChatType.SYSTEM, Util.NIL_UUID);
				}
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
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
						TpToMineProcedure.execute(entity, itemstack);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 60);
			} else if ((entity.level.dimension()) == (Level.OVERWORLD) && itemstack.getOrCreateTag().getBoolean("cooldown") == true) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("please wait before teleporting again"), (false));
			}
			if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("oblivion:mining_dim")))
					&& itemstack.getOrCreateTag().getBoolean("cooldown") == false) {
				if (!world.isClientSide()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().broadcastMessage(new TextComponent("Player teleporting expect lag"), ChatType.SYSTEM, Util.NIL_UUID);
				}
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
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
						TpToOverProcedure.execute(entity, itemstack);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 60);
			} else if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("oblivion:mining_dim")))
					&& itemstack.getOrCreateTag().getBoolean("cooldown") == true) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("please wait before teleporting again"), (false));
			}
			if ((entity.level.dimension()) == (Level.NETHER) && itemstack.getOrCreateTag().getBoolean("cooldown") == false) {
				if (!world.isClientSide()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().broadcastMessage(
								new TextComponent("player has just done something that will most likley kill expect lag"), ChatType.SYSTEM,
								Util.NIL_UUID);
				}
				itemstack.getOrCreateTag().putBoolean("cooldown", (true));
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
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
						TpToMineNetherProcedure.execute(world, x, y, z, entity, itemstack);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 60);
			} else if ((entity.level.dimension()) == (Level.NETHER) && itemstack.getOrCreateTag().getBoolean("cooldown") == true) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("please wait before teleporting again"), (false));
			}
		}
	}
}
