package net.arcane.ascended_arts.trim;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.ForgeRegistries;

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

    public static void bootstrap(BootstapContext<TrimPattern> context) {
        register(context, AscendedAddonItems.SILENCE_HANFU_SMITHING_TEMPLATE.get(), SILENCE_HANFU);
        register(context, AscendedAddonItems.COAST_HANFU_SMITHING_TEMPLATE.get(), COAST_HANFU);
        register(context, AscendedAddonItems.DUNE_HANFU_SMITHING_TEMPLATE.get(), DUNE_HANFU);
        register(context, AscendedAddonItems.EYE_HANFU_SMITHING_TEMPLATE.get(), EYE_HANFU);
        register(context, AscendedAddonItems.HOST_HANFU_SMITHING_TEMPLATE.get(), HOST_HANFU);
        register(context, AscendedAddonItems.RAISER_HANFU_SMITHING_TEMPLATE.get(), RAISER_HANFU);
        register(context, AscendedAddonItems.RIB_HANFU_SMITHING_TEMPLATE.get(), RIB_HANFU);
        register(context, AscendedAddonItems.SENTRY_HANFU_SMITHING_TEMPLATE.get(), SENTRY_HANFU);
        register(context, AscendedAddonItems.SNOUT_HANFU_SMITHING_TEMPLATE.get(), SNOUT_HANFU);
        register(context, AscendedAddonItems.SPIRE_HANFU_SMITHING_TEMPLATE.get(), SPIRE_HANFU);
        register(context, AscendedAddonItems.SHAPER_HANFU_SMITHING_TEMPLATE.get(), SHAPER_HANFU);
        register(context, AscendedAddonItems.TIDE_HANFU_SMITHING_TEMPLATE.get(), TIDE_HANFU);
        register(context, AscendedAddonItems.VEX_HANFU_SMITHING_TEMPLATE.get(), VEX_HANFU);
        register(context, AscendedAddonItems.WARD_HANFU_SMITHING_TEMPLATE.get(), WARD_HANFU);
        register(context, AscendedAddonItems.WAYFINDER_HANFU_SMITHING_TEMPLATE.get(), WAYFINDER_HANFU);
        register(context, AscendedAddonItems.WILD_HANFU_SMITHING_TEMPLATE.get(), WILD_HANFU);
    }



    private static void register(BootstapContext<TrimPattern> context, Item item,ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), ForgeRegistries.ITEMS.getHolder(item).get(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())));
        context.register(key, trimPattern);
    }
}
