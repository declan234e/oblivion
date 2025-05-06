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
        pOutput.accept(ModItems.COFFEE_POWDER.get()); // Items in creative tab
        pOutput.accept(ModItems.COFFEE_BEANS.get());
    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
