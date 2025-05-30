package arcane.ascended_arts.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class AscendLargeItem extends WeaponItem {
    public AscendLargeItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 6, -3F, build);
    }

}
