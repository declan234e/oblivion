/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Datagen;

import dev.declan234e.oblivion.Init.ModItems;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Smeltables
        smelting(consumer, ModItems.COLD_REGULAR_COFFEE.get(), RecipeCategory.FOOD, ModItems.REGULAR_COFFEE.get(), 0.30f, 200, "coffee");
        smelting(consumer, ModItems.COLD_DARK_COFFEE.get(), RecipeCategory.FOOD, ModItems.DARK_COFFEE.get(), 0.25f, 200, "coffee");
        smelting(consumer, ModItems.COLD_MAGMA_COFFEE.get(), RecipeCategory.FOOD, ModItems.MAGMA_COFFEE.get(), 0.25f, 200, "coffee");


        // Crafting
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COLD_REGULAR_COFFEE.get(), 1)
                .requires(ModItems.COLD_DARK_COFFEE.get())
                .requires(Items.MILK_BUCKET)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.COFFEE_BEANS.get()), has(ModItems.COFFEE_BEANS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COLD_DARK_COFFEE.get(), 1)
                .requires(ModItems.EMPTY_MUG.get())
                .requires(ModItems.COFFEE_POWDER.get())
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModItems.COFFEE_BEANS.get()), has(ModItems.COFFEE_BEANS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COLD_MAGMA_COFFEE.get(), 1)
                .requires(ModItems.EMPTY_MUG.get())
                .requires(ModItems.COFFEE_POWDER.get())
                .requires(Items.MAGMA_BLOCK)
                .unlockedBy(getHasName(ModItems.COFFEE_BEANS.get()), has(ModItems.COFFEE_BEANS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_MUG.get())
                .pattern("AA ")
                .pattern("AAA")
                .pattern("AA ")
                .define('A', Items.STONE)
                .unlockedBy(getHasName(ModItems.COFFEE_BEANS.get()), has(ModItems.COFFEE_BEANS.get()))
                .save(consumer);
    }

    protected static void smelting(
            Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            ItemLike pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTIme,
            String pGroup
    ) {
        ISmelting(
                pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting"
        );
    }

    protected static void blasting(
            Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            ItemLike pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTIme,
            String pGroup
    ) {
        ISmelting(
                pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_blasting"
        );
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

    protected static void ISmelting(
            Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
            ItemLike pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pRecipeName
    ) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(pIngredients), has(pIngredients))
                    .save(pFinishedRecipeConsumer,   Oblivion.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredients)
                    );
    }


}
