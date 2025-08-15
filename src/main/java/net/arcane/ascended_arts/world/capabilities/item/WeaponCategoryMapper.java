package net.arcane.ascended_arts.world.capabilities.item;

import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WeaponCategoryMapper {
    private static final Map<AscendedWeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(AscendedWeaponCategories.JIAN, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(AscendedWeaponCategories.SCYTHE, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(AscendedWeaponCategories.SWEEPING_SCYTHE, CapabilityItem.WeaponCategories.SWORD);
    }

    public static CapabilityItem.Builder apply(Item item, AscendedWeaponCategories category) {
        WeaponCategory mappedCategory = categoryMap.getOrDefault(category, category);
        try {
            Method applyMethod = mappedCategory.getClass().getMethod("apply", Item.class);
            return (CapabilityItem.Builder) applyMethod.invoke(mappedCategory, item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
