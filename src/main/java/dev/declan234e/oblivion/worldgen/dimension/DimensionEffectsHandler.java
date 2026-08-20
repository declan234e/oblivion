package dev.declan234e.oblivion.worldgen.dimension;

import dev.declan234e.oblivion.Oblivion;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DimensionEffectsHandler {
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class SpecialEffectsHandler {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {


            DimensionSpecialEffects miningEffect = new DimensionSpecialEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.END, false, false) {
                @Override
                public Vec3 getBrightnessDependentFogColor(Vec3 fogColor, float brightness) {
                    return fogColor;
                }

                @Override
                public boolean isFoggyAt(int x, int y) {
                    return false;
                }
            };


            event.register(ResourceLocation.fromNamespaceAndPath(Oblivion.MOD_ID, "mining_dim"), miningEffect);
        }
    }
}
