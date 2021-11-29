
package tas.atlas.gui;

import tas.atlas.procedures.WDReturnProcedure;
import tas.atlas.procedures.TwoRodReturnProcedure;
import tas.atlas.procedures.ThreeRodReturnProcedure;
import tas.atlas.procedures.StartThingProcedure;
import tas.atlas.procedures.ReturnW80Procedure;
import tas.atlas.procedures.ReturnW60Procedure;
import tas.atlas.procedures.ReturnW40Procedure;
import tas.atlas.procedures.ReturnW20Procedure;
import tas.atlas.procedures.ReturnW100Procedure;
import tas.atlas.procedures.RedUiLightProcedure;
import tas.atlas.procedures.OrangeUiLightProcedure;
import tas.atlas.procedures.OneRodReturnProcedure;
import tas.atlas.procedures.OneFilterProcedure;
import tas.atlas.procedures.GreenUiLightProcedure;
import tas.atlas.procedures.EnergyMoreThan2kProcedure;
import tas.atlas.procedures.EnergyMoreThan1kProcedure;
import tas.atlas.procedures.EnergyLessThan1kProcedure;
import tas.atlas.procedures.Energy9kProcedure;
import tas.atlas.procedures.Energy8kProcedure;
import tas.atlas.procedures.Energy7kProcedure;
import tas.atlas.procedures.Energy6kProcedure;
import tas.atlas.procedures.Energy5KProcedure;
import tas.atlas.procedures.Energy4KProcedure;
import tas.atlas.procedures.Energy3KProcedure;
import tas.atlas.procedures.Energy15kProcedure;
import tas.atlas.procedures.Energy14kProcedure;
import tas.atlas.procedures.Energy13kProcedure;
import tas.atlas.procedures.Energy12kProcedure;
import tas.atlas.procedures.Energy11kProcedure;
import tas.atlas.procedures.Energy10kProcedure;
import tas.atlas.AtlasMultiMod;

import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class TinyReactorGuiGuiWindow extends ContainerScreen<TinyReactorGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = TinyReactorGuiGui.guistate;
	public TinyReactorGuiGuiWindow(TinyReactorGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("atlas_multi:textures/tiny_reactor_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tiny_reactor_gui.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		if (OneRodReturnProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tiny_reactor_fuelrod.png"));
			this.blit(ms, this.guiLeft + 64, this.guiTop + 46, 0, 0, 46, 2, 46, 2);
		}
		if (TwoRodReturnProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tiny_reactor_fuelrod.png"));
			this.blit(ms, this.guiLeft + 64, this.guiTop + 51, 0, 0, 46, 2, 46, 2);
		}
		if (ThreeRodReturnProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tiny_reactor_fuelrod.png"));
			this.blit(ms, this.guiLeft + 64, this.guiTop + 56, 0, 0, 46, 2, 46, 2);
		}
		if (OneFilterProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/filtergui.png"));
			this.blit(ms, this.guiLeft + 119, this.guiTop + 21, 0, 0, 14, 3, 14, 3);
		}
		if (RedUiLightProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/red_light.png"));
			this.blit(ms, this.guiLeft + 75, this.guiTop + 3, 0, 0, 5, 5, 5, 5);
		}
		if (OrangeUiLightProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/orange_light.png"));
			this.blit(ms, this.guiLeft + 65, this.guiTop + 3, 0, 0, 5, 5, 5, 5);
		}
		if (GreenUiLightProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/green_light.png"));
			this.blit(ms, this.guiLeft + 55, this.guiTop + 3, 0, 0, 5, 5, 5, 5);
		}
		if (OneFilterProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/filtergui.png"));
			this.blit(ms, this.guiLeft + 119, this.guiTop + 10, 0, 0, 14, 3, 14, 3);
		}
		if (ReturnW20Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tank_20.png"));
			this.blit(ms, this.guiLeft + 147, this.guiTop + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW40Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tank_40.png"));
			this.blit(ms, this.guiLeft + 147, this.guiTop + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW60Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tank_60.png"));
			this.blit(ms, this.guiLeft + 147, this.guiTop + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW80Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tank_80.png"));
			this.blit(ms, this.guiLeft + 147, this.guiTop + 8, 0, 0, 19, 32, 19, 32);
		}
		if (ReturnW100Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tank_full.png"));
			this.blit(ms, this.guiLeft + 147, this.guiTop + 8, 0, 0, 19, 32, 19, 32);
		}
		if (WDReturnProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("atlas_multi:textures/tank_button_empty.png"));
			this.blit(ms, this.guiLeft + 155, this.guiTop + 43, 0, 0, 18, 18, 18, 18);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		if (EnergyLessThan1kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "" + (new Object() {
				public int getEnergyStored(BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) + " FE", 40, 22, -3355444);
		if (EnergyMoreThan1kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "1K FE", 41, 22, -3355444);
		if (EnergyMoreThan2kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "2k FE", 41, 22, -3355444);
		if (Energy3KProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "3K FE", 41, 22, -3355444);
		if (Energy4KProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "4K FE", 41, 22, -3355444);
		if (Energy5KProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "5k FE", 41, 22, -3355444);
		if (Energy6kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "6K FE", 41, 22, -3355444);
		if (Energy7kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "7K FE", 41, 22, -3355444);
		if (Energy8kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "8K FE", 41, 22, -3355444);
		if (Energy9kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "9K FE", 41, 22, -3355444);
		if (Energy10kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "10K FE", 41, 22, -3355444);
		if (Energy11kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "11K FE", 41, 22, -3355444);
		if (Energy12kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "12K FE", 41, 22, -3355444);
		if (Energy13kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "13K FE", 41, 22, -3355444);
		if (Energy14kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "14K FE", 41, 22, -3355444);
		if (Energy15kProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "15K FE", 41, 22, -3355444);
		this.font.drawString(ms, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "temperature")) + "\u00B0", 118, 30, -12829636);
		this.font.drawString(ms, "" + (new Object() {
			public int getFluidTankLevel(BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(new BlockPos((int) x, (int) y, (int) z), 1)) + "", -104, -5, -13369600);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("state")) + "", -106, -17, -52429);
		this.font.drawString(ms, "" + (new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) + "", -102, 7, -16711732);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 154, this.guiTop + 42, 18, 20, new StringTextComponent(" g"), e -> {
			if (StartThingProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
				AtlasMultiMod.PACKET_HANDLER.sendToServer(new TinyReactorGuiGui.ButtonPressedMessage(0, x, y, z));
				TinyReactorGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (StartThingProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 64, this.guiTop + 62, 51, 20, new StringTextComponent("start"), e -> {
			if (StartThingProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
				AtlasMultiMod.PACKET_HANDLER.sendToServer(new TinyReactorGuiGui.ButtonPressedMessage(1, x, y, z));
				TinyReactorGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (StartThingProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
