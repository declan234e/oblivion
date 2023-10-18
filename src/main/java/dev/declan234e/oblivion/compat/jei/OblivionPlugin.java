package dev.declan234e.oblivion.compat.jei;

/*
import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.recipe.MatterFabRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Objects;
@JeiPlugin
public class OblivionPlugin implements IModPlugin {
    public static RecipeType<MatterFabRecipe> MATTER_FAB_TYPE = new RecipeType<>(MatterFabricatorRecipeCatagory.UID, MatterFabRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Oblivion.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MatterFabricatorRecipeCatagory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(MinecraftClient.getInstance().getNetworkHandler().getRecipeManager());
        List<MatterFabRecipe> recipesMatFab = rm.listAllOfType(MatterFabRecipe.Type.INSTANCE);
        registration.addRecipes(MATTER_FAB_TYPE, recipesMatFab);
    }
}
*/