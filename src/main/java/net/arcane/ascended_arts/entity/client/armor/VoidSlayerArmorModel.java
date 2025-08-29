package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.item.custom.VoidSlayerArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VoidSlayerArmorModel extends GeoModel<VoidSlayerArmorItem> {

    @Override
    public ResourceLocation getModelResource(VoidSlayerArmorItem voidSlayerArmorItem) {
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "geo/void_slayer_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VoidSlayerArmorItem voidSlayerArmorItem) {
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "textures/armor/void_slayer_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VoidSlayerArmorItem voidSlayerArmorItem) {
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "animations/void_slayer_armor.animation.json");
    }
}
