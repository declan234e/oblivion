package dev.declan234e.oblivion;

import dev.declan234e.oblivion.init.*;
import dev.declan234e.oblivion.world.feature.ModConfiguredFeatures;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Oblivion implements ModInitializer {
	public static final String MOD_ID = "oblivion";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.RegisterConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModBlockEntities.registerBlockEntities();
		ModScreensHandler.registerAllScreenHandlers();

		ModRecipes.registerRecipes();

		ModMessages.registerS2CPackets();
		ModMessages.registerC2SPackets();

		LOGGER.info(MOD_ID + " Initializd");
	}
}