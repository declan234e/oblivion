package ga.gamer234emp.obv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class TpToMineNetherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"text\":\"WARNING: DIMENSIONAL CORE UNSTABLE\",\"color\":\"red\"}");
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
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p [\"\",{\"text\":\"TE\",\"color\":\"red\"},{\"text\":\"lepo\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\"RTIN\",\"color\":\"red\"},{\"text\":\"g\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\" dffffdf\",\"obfuscated\":true,\"color\":\"red\"}]");
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
						if (Math.random() < 0.7) {
							if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY,
										new ResourceLocation("oblivion:mining_dim"));
								if (_player.level.dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
											nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							{
								Entity _ent = entity;
								_ent.teleportTo((Math.random() * 1000), (-60), (Math.random() * 1000));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((Math.random() * 1000), (-60), (Math.random() * 1000), _ent.getYRot(),
											_ent.getXRot());
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
												_level.getServer(), null).withSuppressedOutput(),
										"/tellraw @p [\"\",{\"text\":\"E\",\"color\":\"light_purple\"},{\"text\":\"RROR\",\"obfuscated\":true,\"color\":\"light_purple\"},{\"text\":\" CO\",\"color\":\"light_purple\"},{\"text\":\"R\",\"obfuscated\":true,\"color\":\"light_purple\"},{\"text\":\"E DA\",\"color\":\"light_purple\"},{\"text\":\"MAG\",\"obfuscated\":true,\"color\":\"light_purple\"},{\"text\":\"ED \",\"color\":\"light_purple\"},{\"text\":\"T\",\"color\":\"red\"},{\"text\":\"E\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\"LEP\",\"color\":\"red\"},{\"text\":\"ORT\",\"obfuscated\":true,\"color\":\"red\"},{\"text\":\" FAI\",\"color\":\"red\"},{\"text\":\"LED\",\"obfuscated\":true,\"color\":\"red\"}]");
							if (entity instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 6000, 2, (false), (false)));
						} else {
							if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY,
										new ResourceLocation("oblivion:mining_dim"));
								if (_player.level.dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, nextLevel.getSharedSpawnPos().getX(), nextLevel.getSharedSpawnPos().getY() + 1,
											nextLevel.getSharedSpawnPos().getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							if (itemstack.getOrCreateTag().getBoolean("mineTpSET") == true) {
								{
									Entity _ent = entity;
									_ent.teleportTo((itemstack.getOrCreateTag().getDouble("mineDimXPOS")),
											(itemstack.getOrCreateTag().getDouble("mineDimYPOS")),
											(itemstack.getOrCreateTag().getDouble("mineDimZPOS")));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((itemstack.getOrCreateTag().getDouble("mineDimXPOS")),
												(itemstack.getOrCreateTag().getDouble("mineDimYPOS")),
												(itemstack.getOrCreateTag().getDouble("mineDimZPOS")), _ent.getYRot(), _ent.getXRot());
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @a [\"\",{\"text\":\"T\",\"obfuscated\":true,\"color\":\"green\"},{\"text\":\"ELEPORT CORE REPAIRED (lucky)\",\"color\":\"green\"},{\"text\":\" \"}]");
							} else if (itemstack.getOrCreateTag().getBoolean("mineTpSET") == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @a [\"\",{\"text\":\"T\",\"obfuscated\":true,\"color\":\"green\"},{\"text\":\"ELEPORT CORE REPAIRED (lucky)\",\"color\":\"green\"},{\"text\":\" \"}]");
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 40);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 60);
	}
}
