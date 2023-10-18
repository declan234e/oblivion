package dev.declan234e.oblivion.compat.jei;
/*
import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.init.ModBlocks;
import dev.declan234e.oblivion.init.ModItems;
import dev.declan234e.oblivion.recipe.MatterFabRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class MatterFabricatorRecipeCatagory implements IRecipeCategory<MatterFabRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Oblivion.MOD_ID, "matter_fabrication");
    private final static ResourceLocation TEXTURE = new ResourceLocation(Oblivion.MOD_ID, "textures/gui/ui/b_fab_ui.png");
    private final static ResourceLocation ICON = new ResourceLocation(Oblivion.MOD_ID, "textures/block/matter_fab.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MatterFabricatorRecipeCatagory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawable(ICON, 0, 0, 16, 16);
    }

    @Override
    public RecipeType<MatterFabRecipe> getRecipeType() {
        return OblivionPlugin.MATTER_FAB_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Matter Fabricator");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MatterFabRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 16).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 35).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 53).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 115, 35).addItemStack(recipe.getOutput());
    }



}
*/

