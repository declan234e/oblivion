package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import dev.declan234e.oblivion.recipe.MatterFabRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Oblivion.MOD_ID, MatterFabRecipe.Serializer.ID), MatterFabRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Oblivion.MOD_ID, MatterFabRecipe.Type.ID), MatterFabRecipe.Type.INSTANCE);

        Oblivion.LOGGER.debug("Reg Mod Recipes for " + Oblivion.MOD_ID);
    }
}
