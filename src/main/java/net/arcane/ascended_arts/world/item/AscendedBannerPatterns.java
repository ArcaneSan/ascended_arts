package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AscendedBannerPatterns {
    public static final DeferredRegister<BannerPattern> PATTERNS =
            DeferredRegister.create(Registries.BANNER_PATTERN, Ascended_arts.MOD_ID);

    public static final DeferredHolder<BannerPattern, BannerPattern> EXAMPLE_PATTERN =
            PATTERNS.register("example_pattern", () -> new BannerPattern(
                    ResourceLocation.fromNamespaceAndPath("yourmodid", "example_pattern"), // Points to your texture
                    "block.yourmodid.banner.example_pattern" // Translation key
            ));
}
