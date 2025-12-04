package net.arcane.ascended_arts.Util;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AscendedTags {

    public static class Items {

        public static final TagKey<Item> HANFU_TRIMS = tag("hanfu_trims");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, name));
        }
    }
}
