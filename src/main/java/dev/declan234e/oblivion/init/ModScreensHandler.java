package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.screen.ElectricFurnaceScreenHandler;
import dev.declan234e.oblivion.screen.MatterFabScreenHandler;
import dev.declan234e.oblivion.screen.TinyReactorScreenHandler;
import dev.declan234e.oblivion.screen.WaterPuridierScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;

public class ModScreensHandler {
    public static ScreenHandlerType<MatterFabScreenHandler> MATTER_FAB_SCREEN_HANDLER;
    public static ScreenHandlerType<WaterPuridierScreenHandler> WATER_PURIFIER_SCREEN_HANDLER;
    public static ScreenHandlerType<ElectricFurnaceScreenHandler> ELECTRIC_FURNACE_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(ElectricFurnaceScreenHandler::new);
    public static ScreenHandlerType<TinyReactorScreenHandler> TINY_REACTOR_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        MATTER_FAB_SCREEN_HANDLER = new ScreenHandlerType<>(MatterFabScreenHandler::new);
        WATER_PURIFIER_SCREEN_HANDLER = new ScreenHandlerType<>(WaterPuridierScreenHandler::new);
        TINY_REACTOR_SCREEN_HANDLER = new ScreenHandlerType<>(TinyReactorScreenHandler::new);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(Oblivion.MOD_ID, "electric_furnace_sh"), ELECTRIC_FURNACE_SCREEN_HANDLER);

        Oblivion.LOGGER.debug("Reg Mod Screen Handlers for " + Oblivion.MOD_ID);
    }

}
