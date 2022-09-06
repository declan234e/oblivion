package ga.gamer234emp.obv.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import ga.gamer234emp.obv.OblivionMod;
import ga.gamer234emp.obv.init.newinit.ModBlocks;
import ga.gamer234emp.obv.recipe.MatterFabRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class MatterFabRecipeCategory implements IRecipeCategory<MatterFabRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(OblivionMod.MOD_ID, "matter_fab");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(OblivionMod.MOD_ID, "textures/screens/b_fab_ui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated animatedProgressArrow;

    public MatterFabRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MATTER_FAB.get()));
        IDrawableStatic progressArrow = helper.createDrawable(TEXTURE, 176, 0, 24, 17);
        this.animatedProgressArrow = helper.createAnimatedDrawable(progressArrow, 18, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends MatterFabRecipe> getRecipeClass() {
        return MatterFabRecipe.class;
    }


    @Override
    public Component getTitle() {
        return new TextComponent("Matter Fabricator");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull MatterFabRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 16).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 35).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 53).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 115, 35).addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(MatterFabRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        animatedProgressArrow.draw(stack, 79, 35);
    }
}
