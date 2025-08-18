package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.item.custom.RoyalHunterArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RoyalHunterArmorModel extends GeoModel<RoyalHunterArmorItem> {
    @Override
    public ResourceLocation getModelResource(RoyalHunterArmorItem royalHunterArmorItem) {
        return new ResourceLocation(Ascended_arts.MOD_ID, "geo/royal_hunter_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RoyalHunterArmorItem royalHunterArmorItem) {
        return new ResourceLocation(Ascended_arts.MOD_ID, "textures/armor/royal_hunter_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RoyalHunterArmorItem royalHunterArmorItem) {
        return new ResourceLocation(Ascended_arts.MOD_ID, "animations/royal_hunter_armor.animation.json");
    }
}
