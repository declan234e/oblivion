/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Oblivion;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Oblivion.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OBLIVION_TAB = CREATIVE_MODE_TABS.register("oblivion_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COFFEE_POWDER.get())).title(Component.translatable("itemGroup.oblivion.oblivion")).displayItems((itemDisplayParameters, pOutput) -> {
        // Items
        pOutput.accept(ModItems.EMPTY_MUG.get());
        pOutput.accept(ModItems.FILTER.get());
        pOutput.accept(ModItems.COFFEE_POWDER.get());
        pOutput.accept(ModItems.COFFEE_BEANS.get());

        // Hot Coffee
        pOutput.accept(ModItems.REGULAR_COFFEE.get());
        pOutput.accept(ModItems.DARK_COFFEE.get());
        pOutput.accept(ModItems.MAGMA_COFFEE.get());


        // Cold Coffee
        pOutput.accept(ModItems.COLD_REGULAR_COFFEE.get());
        pOutput.accept(ModItems.COLD_DARK_COFFEE.get());
        pOutput.accept(ModItems.COLD_MAGMA_COFFEE.get());

        // Functional
        pOutput.accept(ModBlocks.DRINK_STATION.get());
        pOutput.accept(ModBlocks.COFFEE_GRINDER.get());
    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
