package net.arcane.ascended_arts.skill.guard;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;


import net.neoforged.bus.api.SubscribeEvent;

import yesman.epicfight.api.client.event.types.registry.RegisterWeaponCategoryIconEvent;
import yesman.epicfight.api.event.types.registry.SkillBuilderModificationEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;

import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.skill.identity.MeteorSlamSkill;
import yesman.epicfight.skill.passive.EmergencyEscapeSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;


import java.util.List;


public class AscendedCompatSkills {

    public static void onGuardSkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.GUARD.getId())) {
            if ((event.getSkillBuilder() instanceof GuardSkill.Builder builder)) {
                builder.addGuardMotion(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                                AscendedAnimations.JIAN_GUARD_HIT : AscendedAnimations.JIAN_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(AscendedWeaponCategories.JIAN, (item, player) -> {
                            return AscendedAnimations.JIAN_GUARD_BREAK;
                        });
                builder.addGuardMotion(AscendedWeaponCategories.SCYTHE, (item, player) -> {
                    return AscendedAnimations.SCYTHE_GUARD_HIT;
                }).addGuardBreakMotion(AscendedWeaponCategories.SCYTHE, (item, player) -> {
                    return Animations.BIPED_COMMON_NEUTRALIZED;
                });
                System.out.println("[AscendedCompatSkills] Guard animations have been actualized");
            }
        }
    }
        public static void onParrySkillCreation(SkillBuilderModificationEvent event) {
            if (event.getRegistryName().equals(EpicFightSkills.PARRYING.getId())) {
                if ((event.getSkillBuilder() instanceof GuardSkill.Builder builder)) {

                    builder.addGuardMotion(AscendedWeaponCategories.JIAN, (item, player) -> {
                        return AscendedAnimations.JIAN_GUARD_HIT;
                    }).addGuardBreakMotion(AscendedWeaponCategories.JIAN, (item, player) -> {
                        return AscendedAnimations.JIAN_GUARD_BREAK;
                    }).addAdvancedGuardMotion(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(AscendedAnimations.JIAN_GUARD_PARRY_1, AscendedAnimations.JIAN_GUARD_PARRY_2)
                            : List.of(AscendedAnimations.JIAN_DUAL_GUARD_PARRY_1, AscendedAnimations.JIAN_DUAL_GUARD_PARRY_2)
                    );
                    builder.addGuardMotion(AscendedWeaponCategories.SCYTHE, (item, player) -> {
                        return AscendedAnimations.SCYTHE_GUARD_HIT;
                    }).addGuardBreakMotion(AscendedWeaponCategories.SCYTHE, (item, player) -> {
                        return Animations.BIPED_COMMON_NEUTRALIZED;
                    }).addAdvancedGuardMotion(AscendedWeaponCategories.SCYTHE, (item, player) -> {
                        return List.of(AscendedAnimations.SCYTHE_GUARD_PARRY_1, AscendedAnimations.SCYTHE_GUARD_PARRY_2);
                    });
                    System.out.println("[AscendedCompatSkills] Parrying animations have been actualized");
                }
            }
        }

    public static  void onEFNParrySkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("efn","efn_parry"))) {
            GuardSkill.Builder builder = (ParryingSkill.Builder) event.getSkillBuilder();
            builder.addGuardMotion(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                            AscendedAnimations.JIAN_GUARD_HIT : AscendedAnimations.JIAN_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(AscendedWeaponCategories.JIAN, (item, player) -> {
                        return AscendedAnimations.JIAN_GUARD_BREAK;
                    }).
                    addAdvancedGuardMotion(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                List.of(AscendedAnimations.JIAN_GUARD_PARRY_1, AscendedAnimations.JIAN_GUARD_PARRY_2)
                : List.of(AscendedAnimations.JIAN_DUAL_GUARD_PARRY_1, AscendedAnimations.JIAN_DUAL_GUARD_PARRY_2)
        );
            System.out.println("[AscendedCompatSkills] Enhanced Parry animations have been actualized");
        }
    }


    public static void onEmergencyEscapeSkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.EMERGENCY_ESCAPE.getId())) {
            if (event.getSkillBuilder() instanceof EmergencyEscapeSkill.Builder builder) {
                builder.addAvailableWeaponCategory(AscendedWeaponCategories.JIAN)
                        .addAvailableWeaponCategory(AscendedWeaponCategories.SCYTHE)
                        .addAvailableWeaponCategory(AscendedWeaponCategories.SWEEPING_SCYTHE);
                System.out.println("[AscendedCompatSkills] You may escape now");

            }
        }
    }

    public static void onMeteorSlamSkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.METEOR_SLAM.getId())) {
            if (event.getSkillBuilder() instanceof MeteorSlamSkill.Builder builder) {
                builder.addSlamMotion(AscendedWeaponCategories.SCYTHE, (item, player) -> Animations.METEOR_SLAM);
                System.out.println("[AscenededCompatSkills] You may now SLAM IT");
            }
        }
    }


    public static void onSwordMasterSkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.SWORD_MASTER.getId())) {
            if (event.getSkillBuilder() instanceof SwordmasterSkill.Builder builder) {
                builder.addAvailableWeaponCategory(AscendedWeaponCategories.JIAN);
                System.out.println("[AscenededCompatSkills] You are now a Swordmaster");
            }
        }
    }

    public static void onWeaponCategoryIconCreation(RegisterWeaponCategoryIconEvent icon) {
        icon.registerCategory(AscendedWeaponCategories.JIAN, new ItemStack(AscendedAddonItems.IRON_JIAN.get()));
        icon.registerCategory(AscendedWeaponCategories.SCYTHE, new ItemStack(AscendedAddonItems.ETHERVEIL_SCYTHE.get()));
        icon.registerCategory(AscendedWeaponCategories.SWEEPING_SCYTHE, new ItemStack(AscendedAddonItems.SMALL_IRON_SCYTHE.get()));
        System.out.println("[AscendedCompatSkills] Skill icons have been actualized");
    }
}
