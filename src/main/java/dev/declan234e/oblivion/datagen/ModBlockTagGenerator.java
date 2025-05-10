package dev.declan234e.oblivion.datagen;

import dev.declan234e.oblivion.Init.ModBlocks;
import dev.declan234e.oblivion.Oblivion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Oblivion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.URANDIA_ORE.get(),
                        ModBlocks.TINY_REACTOR.get()

                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
               .add(ModBlocks.URANDIA_ORE.get()).addTag(Tags.Blocks.ORES)
               .add(ModBlocks.TINY_REACTOR.get()

               );

    }
}
