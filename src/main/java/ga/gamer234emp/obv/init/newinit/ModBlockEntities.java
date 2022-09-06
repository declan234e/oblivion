package ga.gamer234emp.obv.init.newinit;

//  MCreator doesn't touch this file

import ga.gamer234emp.obv.OblivionMod;
import ga.gamer234emp.obv.block.entity.MatterFabBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import ga.gamer234emp.obv.init.newinit.ModBlocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, OblivionMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<MatterFabBlockEntity>> MATTER_FAB_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("matter_fab_block_entity", () ->
                    BlockEntityType.Builder.of(MatterFabBlockEntity::new,
                            ModBlocks.MATTER_FAB.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}




