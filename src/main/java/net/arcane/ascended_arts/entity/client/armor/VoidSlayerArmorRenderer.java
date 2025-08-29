package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.item.custom.VoidSlayerArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class VoidSlayerArmorRenderer extends GeoArmorRenderer<VoidSlayerArmorItem> {
    public VoidSlayerArmorRenderer() {
        super(new VoidSlayerArmorModel());
    }
}
