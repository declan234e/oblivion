package dev.declan234e.oblivion.datagen;

import dev.declan234e.oblivion.Init.ModBlocks;
import dev.declan234e.oblivion.Init.ModItems;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> URANDIA_SMELTABLE = List.of(ModBlocks.URANDIA_ORE.get());
    private static final List<ItemLike> COFFEE = List.of(ModItems.COLD_COFFEE.get()); // WHY DO I HAVE TO MAKE A LIST FOR ONE ITEM IT MAKES NO SENSE


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Smeltables
        oreBlasting(consumer, URANDIA_SMELTABLE, RecipeCategory.MISC, ModItems.URANDIA_INGOT.get(), 0.25f, 200, "urandia");
        oreSmelting(consumer, URANDIA_SMELTABLE, RecipeCategory.MISC, ModItems.URANDIA_INGOT.get(), 0.25f, 100, "urandia");
        oreSmelting(consumer, COFFEE, RecipeCategory.MISC, ModItems.DARK_COFFEE.get(), 0.25f, 150, "coffee");

        // Crafting
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TINY_REACTOR.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModItems.REINFORCED_CASING.get())
                .define('B', ModItems.URANDIA_INGOT.get())
                .unlockedBy(getHasName(ModItems.URANDIA_INGOT.get()), has(ModItems.URANDIA_INGOT.get()))
                .save(consumer);
    }

    protected static void oreSmelting(
            Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTIme,
            String pGroup
    ) {
        oreCooking(
                pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting"
        );
    }

    protected static void oreBlasting(
            Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup
    ) {
        oreCooking(
                pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting"
        );
    }

    protected static void oreCooking(
            Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pRecipeName
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,   Oblivion.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
