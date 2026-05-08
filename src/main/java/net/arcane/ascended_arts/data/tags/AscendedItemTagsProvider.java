package net.arcane.ascended_arts.data.tags;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;

import net.minecraft.core.HolderLookup.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class AscendedItemTagsProvider extends ItemTagsProvider {
    public AscendedItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @org.jetbrains.annotations.Nullable net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {super(output, lookupProvider, blockTags, Ascended_arts.MOD_ID, existingFileHelper);}

    @Override
    protected void addTags(Provider provider) {
        this.tag(ItemTags.SWORDS)
                .add(
                        AscendedAddonItems.WOODEN_JIAN.get(),
                        AscendedAddonItems.IRON_JIAN.get(),
                        AscendedAddonItems.GOLDEN_JIAN.get(),
                        AscendedAddonItems.DIAMOND_JIAN.get(),
                        AscendedAddonItems.NETHERITE_JIAN.get(),
                        AscendedAddonItems.SMALL_WOODEN_SCYTHE.get(),
                        AscendedAddonItems.SMALL_IRON_SCYTHE.get(),
                        AscendedAddonItems.SMALL_GOLDEN_SCYTHE.get(),
                        AscendedAddonItems.SMALL_DIAMOND_SCYTHE.get(),
                        AscendedAddonItems.SMALL_NETHERITE_SCYTHE.get(),
                        AscendedAddonItems.ETHERVEIL_SCYTHE.get(),
                        AscendedAddonItems.SKYSPLITTER_JIAN.get()
                );
        this.tag(ItemTags.HEAD_ARMOR)
                .add(
                        AscendedAddonItems.HANFU_HOOD.get(),
                        AscendedAddonItems.IRON_HANFU_HOOD.get(),
                        AscendedAddonItems.GOLD_HANFU_HOOD.get(),
                        AscendedAddonItems.DIAMOND_HANFU_HOOD.get(),
                        AscendedAddonItems.NETHERITE_HANFU_HOOD.get(),
                        AscendedAddonItems.ROYAL_HUNTER_MASK.get(),
                        AscendedAddonItems.VOID_SLAYER_HALO.get()
                );
        this.tag(ItemTags.CHEST_ARMOR)
                .add(
                        AscendedAddonItems.HANFU_ROBE.get(),
                        AscendedAddonItems.IRON_HANFU_ROBE.get(),
                        AscendedAddonItems.GOLD_HANFU_ROBE.get(),
                        AscendedAddonItems.DIAMOND_HANFU_ROBE.get(),
                        AscendedAddonItems.NETHERITE_HANFU_ROBE.get(),
                        AscendedAddonItems.ROYAL_HUNTER_ROBES.get(),
                        AscendedAddonItems.VOID_SLAYER_ROBES.get()
                );
        this.tag(ItemTags.LEG_ARMOR)
                .add(
                        AscendedAddonItems.HANFU_PANTS.get(),
                        AscendedAddonItems.IRON_HANFU_PANTS.get(),
                        AscendedAddonItems.GOLD_HANFU_PANTS.get(),
                        AscendedAddonItems.DIAMOND_HANFU_PANTS.get(),
                        AscendedAddonItems.NETHERITE_HANFU_PANTS.get(),
                        AscendedAddonItems.ROYAL_HUNTER_LEGGINGS.get(),
                        AscendedAddonItems.VOID_SLAYER_LEGGINGS.get()
                );
        this.tag(ItemTags.FOOT_ARMOR)
                .add(
                        AscendedAddonItems.HANFU_BOOTS.get(),
                        AscendedAddonItems.IRON_HANFU_BOOTS.get(),
                        AscendedAddonItems.GOLD_HANFU_BOOTS.get(),
                        AscendedAddonItems.DIAMOND_HANFU_BOOTS.get(),
                        AscendedAddonItems.NETHERITE_HANFU_BOOTS.get(),
                        AscendedAddonItems.ROYAL_HUNTER_BOOTS.get(),
                        AscendedAddonItems.VOID_SLAYER_BOOTS.get()
                );

    }

}
