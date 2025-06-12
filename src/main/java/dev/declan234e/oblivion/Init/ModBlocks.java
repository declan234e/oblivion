/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Init;

import dev.declan234e.oblivion.Blocks.CoffeeBeanCrop;
import dev.declan234e.oblivion.Blocks.CoffeeGrinderBlock;
import dev.declan234e.oblivion.Blocks.DimesionalTeleporter;
import dev.declan234e.oblivion.Blocks.DrinkStationBlock;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Oblivion.MOD_ID);

    // Functional
    public static final RegistryObject<Block> DRINK_STATION = registerBlock("drink_station", () -> new DrinkStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COFFEE_GRINDER = registerBlock("coffee_grinder", () -> new CoffeeGrinderBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> DIMENSIONAL_TELEPORTER = registerBlock("dimensional_teleporter", () -> new DimesionalTeleporter(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    // Ores


    // Crops
    public static final RegistryObject<Block> COFFEE_CROP = BLOCKS.register("coffee_crop", () -> new CoffeeBeanCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
