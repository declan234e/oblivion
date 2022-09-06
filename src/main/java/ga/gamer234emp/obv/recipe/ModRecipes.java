package ga.gamer234emp.obv.recipe;

//  MCreator doesn't touch this file

import ga.gamer234emp.obv.OblivionMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, OblivionMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<MatterFabRecipe>> MATTER_FAB_SERIALIZER =
            SERIALIZERS.register("matter_fab", () -> MatterFabRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
