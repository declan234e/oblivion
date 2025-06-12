/*
 * MIT License
 * Copyright (c) 2025. Declan
 */

package dev.declan234e.oblivion.Items;

import dev.declan234e.oblivion.Oblivion;
import guideme.GuidesCommon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GuideItem extends Item {

    public static final ResourceLocation GUIDE_ID = ResourceLocation.fromNamespaceAndPath(Oblivion.MOD_ID, "guide");

    public GuideItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        GuidesCommon.openGuide(player, GUIDE_ID);
        return InteractionResultHolder.pass(stack);
    }
}
