package net.arcane.ascended_arts.item.client;

import net.arcane.ascended_arts.item.custom.SkySplitterItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SkySplitterRenderer extends GeoItemRenderer<SkySplitterItem> {
    public SkySplitterRenderer() {
        super(new SkySplitterModel());
    }
}
