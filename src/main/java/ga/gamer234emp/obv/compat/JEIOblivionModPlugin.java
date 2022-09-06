package ga.gamer234emp.obv.compat;

import ga.gamer234emp.obv.OblivionMod;
import ga.gamer234emp.obv.init.newinit.ModBlocks;
import ga.gamer234emp.obv.recipe.MatterFabRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIOblivionModPlugin implements IModPlugin {
    private static final int PLAYER_INV_S = 4 * 9;

    public static final RecipeType<MatterFabRecipe> MATTER_FAB = RecipeType.create(OblivionMod.MOD_ID, "matter_fab", MatterFabRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(OblivionMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MatterFabRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level.getRecipeManager());
        List<MatterFabRecipe> recipes = rm.getAllRecipesFor(MatterFabRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MatterFabRecipeCategory.UID, MatterFabRecipe.class), recipes);
    }

    /*
    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MatterFabScreen.class, 142, 65, 13, 13, MATTER_FAB);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        IModPlugin.super.registerRecipeTransferHandlers(registration);
        registration.addRecipeTransferHandler(MatterFabMenu.class, MATTER_FAB,0,3, 3, PLAYER_INV_S);
    }
    */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MATTER_FAB.get().asItem()), MATTER_FAB);
    }
}
