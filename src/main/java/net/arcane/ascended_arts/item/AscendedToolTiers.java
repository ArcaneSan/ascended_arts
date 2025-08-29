package net.arcane.ascended_arts.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.resources.ResourceLocation;
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
}
