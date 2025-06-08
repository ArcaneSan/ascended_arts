package arcane.ascended_arts.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class AscendedItem extends WeaponItem {
    public AscendedItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 4, -2.2F, build);
    }

}
