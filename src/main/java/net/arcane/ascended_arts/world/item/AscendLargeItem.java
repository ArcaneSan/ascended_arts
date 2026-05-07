package net.arcane.ascended_arts.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class AscendLargeItem extends TieredWeaponItem {
    public static ItemAttributeModifiers createAscendedLargeAttributes(Tier tier) {
        return TieredWeaponItem.createAttributes(tier, 6.0F, -3.0F, 0.0F);
    }

    public AscendLargeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
}
