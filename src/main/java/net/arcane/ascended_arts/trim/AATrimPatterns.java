package net.arcane.ascended_arts.trim;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.neoforged.neoforge.registries.DeferredItem;


public class AATrimPatterns {
    public static final ResourceKey<TrimPattern> COAST_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "coast_hanfu"));
    public static final ResourceKey<TrimPattern> DUNE_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "dune_hanfu"));
    public static final ResourceKey<TrimPattern> EYE_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "eye_hanfu"));
    public static final ResourceKey<TrimPattern> HOST_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "host_hanfu"));
    public static final ResourceKey<TrimPattern> RAISER_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "raiser_hanfu"));
    public static final ResourceKey<TrimPattern> RIB_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "rib_hanfu"));
    public static final ResourceKey<TrimPattern> SENTRY_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "sentry_hanfu"));
    public static final ResourceKey<TrimPattern> SNOUT_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "snout_hanfu"));
    public static final ResourceKey<TrimPattern> SPIRE_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "spire_hanfu"));
    public static final ResourceKey<TrimPattern> TIDE_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "tide_hanfu"));
    public static final ResourceKey<TrimPattern> VEX_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "vex_hanfu"));
    public static final ResourceKey<TrimPattern> WARD_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "ward_hanfu"));
    public static final ResourceKey<TrimPattern> WAYFINDER_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "wayfinder_hanfu"));
    public static final ResourceKey<TrimPattern> WILD_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "wild_hanfu"));
    public static final ResourceKey<TrimPattern> SHAPER_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "shaper_hanfu"));
    public static final ResourceKey<TrimPattern> SILENCE_HANFU = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "silence_hanfu"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, AscendedAddonItems.SILENCE_HANFU_SMITHING_TEMPLATE, SILENCE_HANFU);
        register(context, AscendedAddonItems.COAST_HANFU_SMITHING_TEMPLATE, COAST_HANFU);
        register(context, AscendedAddonItems.DUNE_HANFU_SMITHING_TEMPLATE, DUNE_HANFU);
        register(context, AscendedAddonItems.EYE_HANFU_SMITHING_TEMPLATE, EYE_HANFU);
        register(context, AscendedAddonItems.HOST_HANFU_SMITHING_TEMPLATE, HOST_HANFU);
        register(context, AscendedAddonItems.RAISER_HANFU_SMITHING_TEMPLATE, RAISER_HANFU);
        register(context, AscendedAddonItems.RIB_HANFU_SMITHING_TEMPLATE, RIB_HANFU);
        register(context, AscendedAddonItems.SENTRY_HANFU_SMITHING_TEMPLATE, SENTRY_HANFU);
        register(context, AscendedAddonItems.SNOUT_HANFU_SMITHING_TEMPLATE, SNOUT_HANFU);
        register(context, AscendedAddonItems.SPIRE_HANFU_SMITHING_TEMPLATE, SPIRE_HANFU);
        register(context, AscendedAddonItems.SHAPER_HANFU_SMITHING_TEMPLATE, SHAPER_HANFU);
        register(context, AscendedAddonItems.TIDE_HANFU_SMITHING_TEMPLATE, TIDE_HANFU);
        register(context, AscendedAddonItems.VEX_HANFU_SMITHING_TEMPLATE, VEX_HANFU);
        register(context, AscendedAddonItems.WARD_HANFU_SMITHING_TEMPLATE, WARD_HANFU);
        register(context, AscendedAddonItems.WAYFINDER_HANFU_SMITHING_TEMPLATE, WAYFINDER_HANFU);
        register(context, AscendedAddonItems.WILD_HANFU_SMITHING_TEMPLATE, WILD_HANFU);
    }



    private static void register(BootstrapContext<TrimPattern> context, DeferredItem<Item> item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), item.getDelegate(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}
