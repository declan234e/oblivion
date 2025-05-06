package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Oblivion;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oblivion.MOD_ID);


    // Items to add
    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register("coffee_powder", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
