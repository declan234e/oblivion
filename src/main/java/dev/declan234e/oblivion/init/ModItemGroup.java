package dev.declan234e.oblivion.init;

import dev.declan234e.oblivion.Oblivion;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup OBLIVION = FabricItemGroupBuilder.build(new Identifier(Oblivion.MOD_ID, "oblivion"), () -> new ItemStack(ModItems.URANDIA_INGOT));
    public static final ItemGroup OBLIVION_DIMENSIONS = FabricItemGroupBuilder.build(new Identifier(Oblivion.MOD_ID, "oblivion_dimensions"), () -> new ItemStack(ModItems.DIMENSION_TELEPORTER));
}
