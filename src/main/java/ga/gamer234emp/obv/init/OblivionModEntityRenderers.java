
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ga.gamer234emp.obv.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import ga.gamer234emp.obv.client.renderer.VicwinRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OblivionModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(OblivionModEntities.VICWIN, VicwinRenderer::new);
	}
}
