
package ga.gamer234emp.obv.client.gui;

import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.concurrent.atomic.AtomicInteger;

import ga.gamer234emp.obv.world.inventory.TinyReactorGuiMenu;
import ga.gamer234emp.obv.procedures.WDReturnProcedure;
import ga.gamer234emp.obv.procedures.TwoRodReturnProcedure;
import ga.gamer234emp.obv.procedures.ThreeRodReturnProcedure;
import ga.gamer234emp.obv.procedures.StartThingProcedure;
import ga.gamer234emp.obv.procedures.ReturnW80Procedure;
import ga.gamer234emp.obv.procedures.ReturnW60Procedure;
import ga.gamer234emp.obv.procedures.ReturnW40Procedure;
import ga.gamer234emp.obv.procedures.ReturnW20Procedure;
import ga.gamer234emp.obv.procedures.ReturnW100Procedure;
import ga.gamer234emp.obv.procedures.RedUiLightProcedure;
import ga.gamer234emp.obv.procedures.OrangeUiLightProcedure;
import ga.gamer234emp.obv.procedures.OneRodReturnProcedure;
import ga.gamer234emp.obv.procedures.OneFilterProcedure;
import ga.gamer234emp.obv.procedures.GreenUiLightProcedure;
import ga.gamer234emp.obv.procedures.EnergyMoreThan2kProcedure;
import ga.gamer234emp.obv.procedures.EnergyMoreThan1kProcedure;
import ga.gamer234emp.obv.procedures.EnergyLessThan1kProcedure;
import ga.gamer234emp.obv.procedures.Energy9kProcedure;
import ga.gamer234emp.obv.procedures.Energy8kProcedure;
import ga.gamer234emp.obv.procedures.Energy7kProcedure;
import ga.gamer234emp.obv.procedures.Energy6kProcedure;
import ga.gamer234emp.obv.procedures.Energy5KProcedure;
import ga.gamer234emp.obv.procedures.Energy4KProcedure;
import ga.gamer234emp.obv.procedures.Energy3KProcedure;
import ga.gamer234emp.obv.procedures.Energy15kProcedure;
import ga.gamer234emp.obv.procedures.Energy14kProcedure;
import ga.gamer234emp.obv.procedures.Energy13kProcedure;
import ga.gamer234emp.obv.procedures.Energy12kProcedure;
import ga.gamer234emp.obv.procedures.Energy11kProcedure;
import ga.gamer234emp.obv.procedures.Energy10kProcedure;
import ga.gamer234emp.obv.network.TinyReactorGuiButtonMessage;
import ga.gamer234emp.obv.OblivionMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TinyReactorGuiScreen extends AbstractContainerScreen<TinyReactorGuiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TinyReactorGuiScreen(TinyReactorGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("oblivion:textures/tiny_reactor_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tiny_reactor_gui.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		if (OneRodReturnProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tiny_reactor_fuelrod.png"));
			this.blit(ms, this.leftPos + 64, this.topPos + 46, 0, 0, 46, 2, 46, 2);
		}
		if (TwoRodReturnProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tiny_reactor_fuelrod.png"));
			this.blit(ms, this.leftPos + 64, this.topPos + 51, 0, 0, 46, 2, 46, 2);
		}
		if (ThreeRodReturnProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tiny_reactor_fuelrod.png"));
			this.blit(ms, this.leftPos + 64, this.topPos + 56, 0, 0, 46, 2, 46, 2);
		}
		if (OneFilterProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/filtergui.png"));
			this.blit(ms, this.leftPos + 119, this.topPos + 21, 0, 0, 14, 3, 14, 3);
		}
		if (RedUiLightProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/red_light.png"));
			this.blit(ms, this.leftPos + 75, this.topPos + 3, 0, 0, 5, 5, 5, 5);
		}
		if (OrangeUiLightProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/orange_light.png"));
			this.blit(ms, this.leftPos + 65, this.topPos + 3, 0, 0, 5, 5, 5, 5);
		}
		if (GreenUiLightProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/green_light.png"));
			this.blit(ms, this.leftPos + 55, this.topPos + 3, 0, 0, 5, 5, 5, 5);
		}
		if (OneFilterProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/filtergui.png"));
			this.blit(ms, this.leftPos + 119, this.topPos + 10, 0, 0, 14, 3, 14, 3);
		}
		if (ReturnW20Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tank_20.png"));
			this.blit(ms, this.leftPos + 147, this.topPos + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW40Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tank_40.png"));
			this.blit(ms, this.leftPos + 147, this.topPos + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW60Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tank_60.png"));
			this.blit(ms, this.leftPos + 147, this.topPos + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW80Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tank_80.png"));
			this.blit(ms, this.leftPos + 147, this.topPos + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW100Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tank_full.png"));
			this.blit(ms, this.leftPos + 147, this.topPos + 8, 0, 0, 19, 32, 19, 32);
		}
		if (WDReturnProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("oblivion:textures/tank_button_empty.png"));
			this.blit(ms, this.leftPos + 155, this.topPos + 43, 0, 0, 18, 18, 18, 18);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		if (EnergyLessThan1kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "" + (new Object() {
				public int getEnergyStored(BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) + " FE", 40, 22, -3355444);
		if (EnergyMoreThan1kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "1K FE", 41, 22, -3355444);
		if (EnergyMoreThan2kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "2k FE", 41, 22, -3355444);
		if (Energy3KProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "3K FE", 41, 22, -3355444);
		if (Energy4KProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "4K FE", 41, 22, -3355444);
		if (Energy5KProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "5k FE", 41, 22, -3355444);
		if (Energy6kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "6K FE", 41, 22, -3355444);
		if (Energy7kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "7K FE", 41, 22, -3355444);
		if (Energy8kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "8K FE", 41, 22, -3355444);
		if (Energy9kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "9K FE", 41, 22, -3355444);
		if (Energy10kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "10K FE", 41, 22, -3355444);
		if (Energy11kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "11K FE", 41, 22, -3355444);
		if (Energy12kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "12K FE", 41, 22, -3355444);
		if (Energy13kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "13K FE", 41, 22, -3355444);
		if (Energy14kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "14K FE", 41, 22, -3355444);
		if (Energy15kProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "15K FE", 41, 22, -3355444);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "temperature")) + "\u00B0", 118, 30, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public int getFluidTankLevel(BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(new BlockPos((int) x, (int) y, (int) z), 1)) + "", -104, -5, -13369600);
		this.font.draw(poseStack, "" + (entity.getPersistentData().getString("isActive")) + "", -106, -17, -52429);
		this.font.draw(poseStack, "" + (new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) + "", -102, 7, -16711732);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 154, this.topPos + 42, 18, 20, new TextComponent(" g"), e -> {
			if (StartThingProcedure.execute(world, x, y, z)) {
				OblivionMod.PACKET_HANDLER.sendToServer(new TinyReactorGuiButtonMessage(0, x, y, z));
				TinyReactorGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (StartThingProcedure.execute(world, x, y, z))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 64, this.topPos + 62, 51, 20, new TextComponent("start"), e -> {
			if (StartThingProcedure.execute(world, x, y, z)) {
				OblivionMod.PACKET_HANDLER.sendToServer(new TinyReactorGuiButtonMessage(1, x, y, z));
				TinyReactorGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (StartThingProcedure.execute(world, x, y, z))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
