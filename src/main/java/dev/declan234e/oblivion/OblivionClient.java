package dev.declan234e.oblivion;

import dev.declan234e.oblivion.init.ModBlocks;
import dev.declan234e.oblivion.init.ModScreensHandler;
import dev.declan234e.oblivion.screen.ElectricFurnaceScreen;
import dev.declan234e.oblivion.screen.MatterFabScreen;
import dev.declan234e.oblivion.screen.WaterPurifierScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class OblivionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIOME_SNOWGLOBE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BASIC_SOLAR_PANEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WATER_PURIFIER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TINY_REACTOR, RenderLayer.getCutout());

        HandledScreens.register(ModScreensHandler.MATTER_FAB_SCREEN_HANDLER, MatterFabScreen::new);
        HandledScreens.register(ModScreensHandler.WATER_PURIFIER_SCREEN_HANDLER, WaterPurifierScreen::new);
        HandledScreens.register(ModScreensHandler.ELECTRIC_FURNACE_SCREEN_HANDLER, ElectricFurnaceScreen::new);
    }
}
