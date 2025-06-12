/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Datagen;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.Init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, Oblivion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Items
        simpleItem(ModItems.FILTER);
        simpleItem(ModItems.EMPTY_MUG);
        coffeeItem(ModItems.COFFEE_BEANS, "coffee_beans");
        coffeeItem(ModItems.COFFEE_POWDER, "coffee_powder");
        simpleItem(ModItems.GUIDE);

        // Hot Coffee
        coffeeItem(ModItems.REGULAR_COFFEE, "regular_coffee");
        coffeeItem(ModItems.DARK_COFFEE, "dark_coffee");
        coffeeItem(ModItems.MAGMA_COFFEE, "magma_coffee");

        // Cold Coffee
        coffeeItem(ModItems.COLD_REGULAR_COFFEE, "cold_regular_coffee");
        coffeeItem(ModItems.COLD_DARK_COFFEE, "cold_regular_coffee");
        coffeeItem(ModItems.COLD_MAGMA_COFFEE, "cold_regular_coffee");




    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(Oblivion.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder coffeeItem(RegistryObject<Item> item, String name) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(Oblivion.MOD_ID, "item/coffee/" + name));
    }
}
