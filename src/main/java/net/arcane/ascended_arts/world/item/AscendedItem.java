package net.arcane.ascended_arts.world.item;


import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;


public class AscendedItem extends TieredWeaponItem {
    public static ItemAttributeModifiers createAscendedNormalAttributes(Tier tier) {
        return TieredWeaponItem.createAttributes(tier, 3.0F, -2.2F, 0.0F);
    }

    public AscendedItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
}
