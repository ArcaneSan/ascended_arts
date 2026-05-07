package net.arcane.ascended_arts.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;


import java.util.List;

public class AscendedToolTiers {

    public static final Tier MYTHOS = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            4000, 9.0F, 5.0F, 45, () -> Ingredient.of(Items.PHANTOM_MEMBRANE));
    public static final Tier NETHERITEPLUS = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            3000, 9.0F, 4.0F, 25, () -> Ingredient.of(Items.NETHERITE_INGOT));
    public static final Tier DIAMONDPLUS = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            2500, 8.0F, 3.0F, 20, () -> Ingredient.of(Items.DIAMOND));
    public static final  Tier IRONPLUS = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            550, 6.0F, 2.0F, 24, () -> Ingredient.of(Items.IRON_INGOT));
    public static final Tier GOLDPLUS = new SimpleTier(BlockTags.INCORRECT_FOR_GOLD_TOOL,
            64, 12.0F, 0.0F, 32, () -> Ingredient.of(Items.GOLD_INGOT));
    public static final Tier WOODPLUS = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            120, 2.0F, 0.0F, 25, () -> Ingredient.of(ItemTags.PLANKS));




}
