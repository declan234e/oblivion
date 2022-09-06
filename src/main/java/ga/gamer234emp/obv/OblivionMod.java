/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package ga.gamer234emp.obv;

import ga.gamer234emp.obv.init.newinit.ModBlockEntities;
import ga.gamer234emp.obv.init.newinit.ModBlocks;
import ga.gamer234emp.obv.init.newinit.ModItems;
import ga.gamer234emp.obv.recipe.ModRecipes;
import ga.gamer234emp.obv.screens.MatterFabScreen;
import ga.gamer234emp.obv.screens.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;

import ga.gamer234emp.obv.init.OblivionModTabs;
import ga.gamer234emp.obv.init.OblivionModItems;
import ga.gamer234emp.obv.init.OblivionModFeatures;
import ga.gamer234emp.obv.init.OblivionModBlocks;
import ga.gamer234emp.obv.init.OblivionModBlockEntities;
import ga.gamer234emp.obv.init.OblivionModBiomes;
import net.minecraftforge.fml.ModList;

@Mod(OblivionMod.MOD_ID)
public class OblivionMod {
	public static final String MOD_ID = "oblivion";
	public static final Logger LOGGER = LogManager.getLogger(OblivionMod.class);
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public OblivionMod() {
		OblivionModTabs.load();
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		OblivionModBlocks.REGISTRY.register(eventBus);
		OblivionModItems.REGISTRY.register(eventBus);

		ModBlockEntities.register(eventBus);
		ModBlocks.register(eventBus);
		ModRecipes.register(eventBus);
		ModItems.register(eventBus);
		ModMenuTypes.register(eventBus);

		OblivionModBlockEntities.REGISTRY.register(eventBus);
		OblivionModFeatures.REGISTRY.register(eventBus);

		OblivionModBiomes.REGISTRY.register(eventBus);

	}
	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}
	public static String getVersion() {
		return "v" + ModList.get().getModContainerById(MOD_ID).get().getModInfo().getVersion().toString();
	}
}
