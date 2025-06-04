package arcane.ascended_arts.world.capabilities.item;

import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

public class JianWeaponCategories implements WeaponCategory, Function<Item, CapabilityItem> {
    public static WeaponCategory JIAN;


    final  int id;

    JianWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }








    @Override
    public CapabilityItem apply(Item item) {
        return null;
    }

    @Override
    public int universalOrdinal() {
        return 0;
    }
}
