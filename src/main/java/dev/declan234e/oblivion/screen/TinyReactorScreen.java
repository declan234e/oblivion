package dev.declan234e.oblivion.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.block.Entity.TinyReactorBlockEntity;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;



public class TinyReactorScreen extends HandledScreen<TinyReactorScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Oblivion.MOD_ID, "textures/gui/ui/tiny_reactor_gui.png");

    public TinyReactorScreen(TinyReactorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        activeLight(matrices, x, y);


    }

    private void activeLight(MatrixStack matrices, int x, int y) {
        if(handler.isActive()) {
            drawTexture(matrices, x + 55, y + 3, 230, 0, 5, 5);
        }
    }


    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
        addDrawableChild(new ButtonWidget(x + 66, y + 62, 44, 11, Text.literal("start"), button -> {
            handler.makeActive();

        }));
    }
}
