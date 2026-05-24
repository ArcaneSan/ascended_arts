package net.arcane.ascended_arts.world.capabilities.item;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.List;
import java.util.function.Function;

public enum AscendedWeaponCategories implements WeaponCategory, Function<Item, CapabilityItem.Builder> {
    JIAN,
    SCYTHE,
    SWEEPING_SCYTHE,
    SUP_FLUTE,
    PRAY;


    final List<WeaponCategory> parents;
    final int id;

    AscendedWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
        this.parents = ImmutableList.of();

    }
    AscendedWeaponCategories(WeaponCategory... parents){
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
        this.parents = ImmutableList.copyOf(parents);
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }
    @Override
    public CapabilityItem.Builder apply(Item item) {
        return WeaponCategoryMapper.apply(item, this);
    }
}