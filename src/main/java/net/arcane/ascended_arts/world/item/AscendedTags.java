package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class AscendedTags {
    public static void initTags() {}

    public static final TagKey<BannerPattern> PATTERN_ITEM_PLUM =
            TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "pattern_item/plum_blossom"));
}
