package ga.gamer234emp.obv.event;

//  MCreator doesn't touch this file

import ga.gamer234emp.obv.OblivionMod;
import ga.gamer234emp.obv.recipe.MatterFabRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.launch.platform.MainAttributes;

@Mod.EventBusSubscriber(modid = OblivionMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, MatterFabRecipe.Type.ID, MatterFabRecipe.Type.INSTANCE);
    }
}
