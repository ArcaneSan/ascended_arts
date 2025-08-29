package net.arcane.ascended_arts.item.client;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.item.custom.SkySplitterItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SkySplitterModel extends GeoModel<SkySplitterItem> {

    @Override
    public ResourceLocation getModelResource(SkySplitterItem skySplitterItem) {
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "geo/skysplitter_jian.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkySplitterItem skySplitterItem) {
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "textures/item/skysplitter_jian.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkySplitterItem skySplitterItem) {
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "animations/skysplitter_jian.animation.json");
    }
}
