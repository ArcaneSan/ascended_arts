package net.arcane.ascended_arts.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class AscendedSmallScytheItem extends WeaponItem {
    public AscendedSmallScytheItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 2, -2.6F, build);
    }
}
