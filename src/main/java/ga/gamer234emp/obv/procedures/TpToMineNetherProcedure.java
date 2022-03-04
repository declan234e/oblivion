package ga.gamer234emp.obv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;
import java.util.Collections;

import ga.gamer234emp.obv.OblivionMod;

public class TpToMineNetherProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OblivionMod.LOGGER.warn("Failed to load dependency world for procedure TpToMineNether!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OblivionMod.LOGGER.warn("Failed to load dependency x for procedure TpToMineNether!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OblivionMod.LOGGER.warn("Failed to load dependency y for procedure TpToMineNether!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OblivionMod.LOGGER.warn("Failed to load dependency z for procedure TpToMineNether!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OblivionMod.LOGGER.warn("Failed to load dependency entity for procedure TpToMineNether!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				OblivionMod.LOGGER.warn("Failed to load dependency itemstack for procedure TpToMineNether!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/tellraw @p {\"text\":\"WARNING: DIMENSIONAL CORE UNSTABLE\",\"color\":\"red\"}");
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
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/tellraw @p [\"\",{\"text\":\"TE\",\"color\":\"red\"},{\"text\":\"lepo\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\"RTIN\",\"color\":\"red\"},{\"text\":\"g\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\" dffffdf\",\"obfuscated\":true,\"color\":\"red\"}]");
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
						if (Math.random() < 0.7) {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("oblivion:mining_dim"));
									ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
									if (nextWorld != null) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
										((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
												nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
												_ent.rotationPitch);
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
										for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
										}
										((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate((Math.random() * 1000), 2, (Math.random() * 1000));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.random() * 1000), 2, (Math.random() * 1000),
											_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
								}
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"/tellraw @p [\"\",{\"text\":\"E\",\"color\":\"light_purple\"},{\"text\":\"RROR\",\"obfuscated\":true,\"color\":\"light_purple\"},{\"text\":\" CO\",\"color\":\"light_purple\"},{\"text\":\"R\",\"obfuscated\":true,\"color\":\"light_purple\"},{\"text\":\"E DA\",\"color\":\"light_purple\"},{\"text\":\"MAG\",\"obfuscated\":true,\"color\":\"light_purple\"},{\"text\":\"ED \",\"color\":\"light_purple\"},{\"text\":\"T\",\"color\":\"red\"},{\"text\":\"E\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\"LEP\",\"color\":\"red\"},{\"text\":\"ORT\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\" FAI\",\"color\":\"red\"},{\"text\":\"LED\",\"obfuscated\":true,\"color\":\"red\"}]");
							}
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 6000, (int) 2, (false), (false)));
						} else {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("oblivion:mining_dim"));
									ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
									if (nextWorld != null) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
										((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
												nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
												_ent.rotationPitch);
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
										for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
										}
										((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
							if (itemstack.getOrCreateTag().getBoolean("mineTpSET") == true) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate((itemstack.getOrCreateTag().getDouble("mineDimXPOS")),
											(itemstack.getOrCreateTag().getDouble("mineDimYPOS")),
											(itemstack.getOrCreateTag().getDouble("mineDimZPOS")));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(
												(itemstack.getOrCreateTag().getDouble("mineDimXPOS")),
												(itemstack.getOrCreateTag().getDouble("mineDimYPOS")),
												(itemstack.getOrCreateTag().getDouble("mineDimZPOS")), _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tellraw @a [\"\",{\"text\":\"T\",\"obfuscated\":true,\"color\":\"green\"},{\"text\":\"ELEPORT CORE REPAIRED (lucky)\",\"color\":\"green\"},{\"text\":\" \"}]");
								}
							} else if (itemstack.getOrCreateTag().getBoolean("mineTpSET") == false) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tellraw @a [\"\",{\"text\":\"T\",\"obfuscated\":true,\"color\":\"green\"},{\"text\":\"ELEPORT CORE REPAIRED (lucky)\",\"color\":\"green\"},{\"text\":\" \"}]");
								}
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 40);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 60);
	}
}
