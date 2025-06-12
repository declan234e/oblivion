/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Datagen.loot;

import dev.declan234e.oblivion.Blocks.CoffeeBeanCrop;
import dev.declan234e.oblivion.Init.ModBlocks;
import dev.declan234e.oblivion.Init.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        cropLootTable(ModBlocks.COFFEE_CROP.get(),ModItems.COFFEE_BEANS.get(), ModItems.COFFEE_BEANS.get(), CoffeeBeanCrop.AGE, CoffeeBeanCrop.MAX_AGE);
        this.dropSelf(ModBlocks.DRINK_STATION.get());
        this.dropSelf(ModBlocks.COFFEE_GRINDER.get());
        this.dropSelf(ModBlocks.DIMENSIONAL_TELEPORTER.get());
    }

    private void cropLootTable(Block crop, Item seeds, Item result, IntegerProperty age, int maxAge) {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(crop)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, maxAge));
        this.add(crop, createCropDrops(crop, result, seeds, lootitemcondition$builder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
