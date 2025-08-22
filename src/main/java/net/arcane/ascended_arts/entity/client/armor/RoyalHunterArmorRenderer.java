package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.item.custom.RoyalHunterArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RoyalHunterArmorRenderer extends GeoArmorRenderer<RoyalHunterArmorItem> {
    public RoyalHunterArmorRenderer() {
        super(new RoyalHunterArmorModel());
    }
}
