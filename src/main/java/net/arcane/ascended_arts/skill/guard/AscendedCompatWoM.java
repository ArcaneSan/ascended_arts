package net.arcane.ascended_arts.skill.guard;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.minecraft.world.item.ItemStack;


//import reascer.wom.gameasset.WOMSkills;


import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.IEventBus;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;

import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class AscendedCompatWoM implements ICompatModule {
    public static void registerGuard(Event event) {
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBus(IEventBus eventBus) {

    }


    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBusClient(IEventBus eventBus) {

    }





   /* public static void regIcon(WeaponCategoryIconRegisterEvent event) {
        event.registerCategory(AscendedWeaponCategories.JIAN, new ItemStack(AscendedAddonItems.IRON_JIAN.get()));
    }

    public static boolean regGuarded = false;

    public static void buildSkillEvent(RegisterEvent event) {
        if (EpicFightSkills.GUARD == null) {
            return;
        }
        if (regGuarded) {
            return;
        }
        try {
            regGuard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        regGuarded = true;
    }

    public static void regGuard() throws NoSuchFieldException, IllegalAccessException {
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> guardMotions = new HashMap<>();
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> guardBreakMotions = new HashMap<>();
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> advancedGuardMotions = new HashMap<>();

        guardMotions.put(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                        AscendedAnimations.JIAN_GUARD_HIT : AscendedAnimations.JIAN_DUAL_GUARD_HIT);
        guardBreakMotions.put(AscendedWeaponCategories.JIAN, (item, player) ->
                     AscendedAnimations.JIAN_GUARD_BREAK);
        advancedGuardMotions.put(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) ->  itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                List.of(AscendedAnimations.JIAN_GUARD_PARRY_1, AscendedAnimations.JIAN_GUARD_PARRY_2)
                : List.of(AscendedAnimations.JIAN_DUAL_GUARD_PARRY_1, AscendedAnimations.JIAN_DUAL_GUARD_PARRY_2));



        Field temp;
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> target;
        temp = GuardSkill.class.getDeclaredField("guardMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.VENGEFUL_PARRY);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }

        temp = GuardSkill.class.getDeclaredField("guardBreakMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.VENGEFUL_PARRY);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }

        temp = GuardSkill.class.getDeclaredField("advancedGuardMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : advancedGuardMotions.keySet()) {
            target.put(weaponCapability, advancedGuardMotions.get(weaponCapability));
        }*/
    }

