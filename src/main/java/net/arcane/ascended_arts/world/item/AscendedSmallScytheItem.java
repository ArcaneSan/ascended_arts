package net.arcane.ascended_arts.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;
import yesman.epicfight.world.item.WeaponItem;

public class AscendedSmallScytheItem extends TieredWeaponItem {
    public static ItemAttributeModifiers createAscendedSmallAttributes(Tier tier) {
        return TieredWeaponItem.createAttributes(tier, 2.0F, -2.6F, 0.0F);
    }

    public AscendedSmallScytheItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
}
