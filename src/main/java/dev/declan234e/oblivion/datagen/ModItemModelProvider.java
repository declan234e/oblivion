package dev.declan234e.oblivion.datagen;

import dev.declan234e.oblivion.Init.ModItems;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, Oblivion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.URANDIA_INGOT);
        simpleItem(ModItems.EMPTY_MUG);
        simpleItem(ModItems.PURIFIED_WATER);
        simpleItem(ModItems.DIMENSION_TELEPORTER);
        simpleItem(ModItems.FILTER);
        simpleItem(ModItems.REINFORCED_CASING);
        simpleItem(ModItems.LEAD_INGOT);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Oblivion.MOD_ID, "item/" + item.getId().getPath()));
    }
}
