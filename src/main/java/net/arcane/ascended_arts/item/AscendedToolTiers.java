package net.arcane.ascended_arts.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class AscendedToolTiers {
    public static final Tier Mythos = TierSortingRegistry.registerTier(
            new ForgeTier(5, 4000, 9.0F, 5.0F, 45,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.DIAMOND)),
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "mythos"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier WoodPlus = TierSortingRegistry.registerTier(
            new ForgeTier(0, 120, 2.0F, 0.0F, 25,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ItemTags.PLANKS)),
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "wood_plus"), List.of(Tiers.WOOD), List.of());
    public static final Tier IronPlus = TierSortingRegistry.registerTier(
            new ForgeTier(2, 550, 6.0F, 2.0F, 24,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "iron_plus"), List.of(Tiers.IRON), List.of());
    public static final Tier GoldPlus = TierSortingRegistry.registerTier(
            new ForgeTier(0, 64, 12.0F, 0.0F, 32,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.GOLD_INGOT)),
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "gold_plus"), List.of(Tiers.GOLD), List.of());
    public static final Tier DiamondPlus = TierSortingRegistry.registerTier(
            new ForgeTier(3, 2500, 8.0F, 3.0F, 20,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.DIAMOND)),
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "diamond_plus"), List.of(Tiers.DIAMOND), List.of());
    public static final Tier NetheritePlus = TierSortingRegistry.registerTier(
            new ForgeTier(4, 3000, 9.0F, 4.0F, 25,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT)),
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "netherite_plus"), List.of(Tiers.NETHERITE), List.of());

}
