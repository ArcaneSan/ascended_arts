package net.arcane.ascended_arts.world.capabilities.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.gameasset.AscendedColliderPreset;
import net.arcane.ascended_arts.gameasset.AscendedSkills;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import yesman.epicfight.api.animation.LivingMotions;

import yesman.epicfight.api.event.types.registry.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;

import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;


public class WeaponCapabilityPresets {
    public static final Function<Item, WeaponCapability.Builder> JIAN = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.JIAN) // Updated to use custom category
                .styleProvider((playerpatch) -> playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == AscendedWeaponCategories.JIAN ? Styles.TWO_HAND : Styles.ONE_HAND)
                .collider(AscendedColliderPreset.JIAN)
                .canBePlacedOffhand(true)
                .newStyleCombo(Styles.ONE_HAND, AscendedAnimations.JIAN_AUTO_1, AscendedAnimations.JIAN_AUTO_2, AscendedAnimations.JIAN_AUTO_3,AscendedAnimations.JIAN_AUTO_4, AscendedAnimations.JIAN_DASH, AscendedAnimations.JIAN_AIRSLASH)
                .newStyleCombo(Styles.TWO_HAND, AscendedAnimations.DUAL_JIAN_AUTO_1, AscendedAnimations.DUAL_JIAN_AUTO_2, AscendedAnimations.DUAL_JIAN_AUTO_3, AscendedAnimations.DUAL_JIAN_AUTO_4, AscendedAnimations.DUAL_JIAN_DASH, AscendedAnimations.DUAL_JIAN_AIRSLASH)
                .innateSkill(Styles.ONE_HAND, (itemstack) -> AscendedSkills.CELESTIAL_PUNISHMENT.get())
                .innateSkill(Styles.TWO_HAND, (itemstack) -> AscendedSkills.CELESTIAL_ONSLAUGHT.get())
                .passiveSkill(AscendedSkills.FLOATING_PASSIVE.get())
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.IDLE, AscendedAnimations.BIPED_HOLD_JIAN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.IDLE, AscendedAnimations.BIPED_HOLD_DUAL_JIAN)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.WALK, AscendedAnimations.BIPED_WALK_JIAN)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.RUN, AscendedAnimations.BIPED_RUN_JIAN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.WALK, AscendedAnimations.BIPED_WALK_DUAL_JIAN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.RUN, AscendedAnimations.BIPED_RUN_DUAL_JIAN)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.BLOCK, AscendedAnimations.JIAN_GUARD)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.KNEEL, AscendedAnimations.BIPED_HOLD_JIAN)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_JIAN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.KNEEL, AscendedAnimations.BIPED_HOLD_DUAL_JIAN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_DUAL_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.CREATIVE_IDLE, AscendedAnimations.BIPED_FLY_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.CREATIVE_FLY, AscendedAnimations.BIPED_FLY_JIAN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, AscendedAnimations.DUAL_JIAN_GUARD);


        return builder;
    };
    public static Function<Item, WeaponCapability.Builder> SCYTHE = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.SCYTHE)
                .styleProvider((playerpatch) -> Styles.OCHS)
                .collider(AscendedColliderPreset.SCYTHE)
                .canBePlacedOffhand(false)
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                .passiveSkill(AscendedSkills.LIFESTEAL_PASSIVE.get())
                .innateSkill(Styles.OCHS, (itemstack) -> AscendedSkills.REAPING_GRASP.get())
                .newStyleCombo(Styles.OCHS, AscendedAnimations.SCYTHE_AUTO_1, AscendedAnimations.SCYTHE_AUTO_2, AscendedAnimations.SCYTHE_AUTO_3, AscendedAnimations.SCYTHE_AUTO_4, AscendedAnimations.SCYTHE_DASH, AscendedAnimations.SCYTHE_AIRSLASH)
                .livingMotionModifier(Styles.OCHS, LivingMotions.IDLE, AscendedAnimations.BIPED_HOLD_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.KNEEL, AscendedAnimations.BIPED_KNEEL_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.WALK, AscendedAnimations.BIPED_WALK_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.RUN, AscendedAnimations.BIPED_RUN_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.SLEEP, AscendedAnimations.BIPED_SCYTHE_SLEEP)
                .livingMotionModifier(Styles.OCHS, LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.CREATIVE_IDLE, AscendedAnimations.BIPED_HOLD_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.CREATIVE_FLY, AscendedAnimations.BIPED_RUN_SCYTHE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.BLOCK, AscendedAnimations.SCYTHE_GUARD);
      return builder;
    };
    public static Function<Item, WeaponCapability.Builder> SWEEPING_SCYTHE = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.SWEEPING_SCYTHE)
                .styleProvider((playerpatch) -> playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == AscendedWeaponCategories.SWEEPING_SCYTHE ? Styles.TWO_HAND : Styles.ONE_HAND)                .collider(AscendedColliderPreset.SWEEPING_SCYTHE)
                .canBePlacedOffhand(true)
                .collider(AscendedColliderPreset.SWEEPING_SCYTHE)
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .swingSound(EpicFightSounds.WHOOSH.get())
                .innateSkill(Styles.ONE_HAND, (itemstack) -> EpicFightSkills.SWEEPING_EDGE.get())
                .innateSkill(Styles.TWO_HAND, (itemStack -> EpicFightSkills.DANCING_EDGE.get()))
                .newStyleCombo(Styles.ONE_HAND,AscendedAnimations.S_SCYTHE_AUTO, AscendedAnimations.S_SCYTHE_AUTO_2, AscendedAnimations.S_SCYTHE_AUTO_3, AscendedAnimations.S_SCYTHE_AUTO_2, AscendedAnimations.S_SCYTHE_AUTO_3, AscendedAnimations.S_SCYTHE_AUTO_2, AscendedAnimations.S_SCYTHE_AUTO_3, AscendedAnimations.S_SCYTHE_DASH, AscendedAnimations.S_SCYTHE_AIRSLASH)
                .newStyleCombo(Styles.TWO_HAND, AscendedAnimations.S_SCYTHE_AUTO, AscendedAnimations.S_DUAL_SCYTHE_AUTO_2, AscendedAnimations.S_DUAL_SCYTHE_AUTO_3, AscendedAnimations.S_DUAL_SCYTHE_AUTO_2, AscendedAnimations.S_DUAL_SCYTHE_AUTO_3, AscendedAnimations.S_DUAL_SCYTHE_AUTO_2, AscendedAnimations.S_DUAL_SCYTHE_AUTO_3, Animations.SWORD_DUAL_DASH, AscendedAnimations.S_DUAL_SCYTHE_AIRSLASH)
                .livingMotionModifier(Styles.COMMON, LivingMotions.IDLE, AscendedAnimations.BIPED_S_SCYTHE_HOLD)
                .livingMotionModifier(Styles.COMMON, LivingMotions.KNEEL, AscendedAnimations.BIPED_S_SCYTHE_KNEEL)
                .livingMotionModifier(Styles.COMMON, LivingMotions.WALK, Animations.BIPED_WALK)
                .livingMotionModifier(Styles.COMMON, LivingMotions.RUN, Animations.BIPED_RUN_DUAL)
                .livingMotionModifier(Styles.COMMON, LivingMotions.SNEAK, Animations.BIPED_SNEAK);
        return builder;
    };
    public static Function<Item, WeaponCapability.Builder> SUP_FLUTE = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.SUP_FLUTE)
                .styleProvider((playerpatch) -> Styles.OCHS)
                .canBePlacedOffhand(true)
                .newStyleCombo(Styles.OCHS, AscendedAnimations.FLUTE_AUTO, AscendedAnimations.FLUTE_AUTO_2, AscendedAnimations.FLUTE_DASH, AscendedAnimations.FLUTE_AIRSLASH)
                .livingMotionModifier(Styles.OCHS, LivingMotions.IDLE, AscendedAnimations.FLUTE_IDLE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.RUN, AscendedAnimations.FLUTE_IDLE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.WALK, AscendedAnimations.FLUTE_IDLE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.SNEAK, AscendedAnimations.FLUTE_IDLE)
                .livingMotionModifier(Styles.OCHS, LivingMotions.KNEEL, AscendedAnimations.FLUTE_IDLE);
                return builder;
    };
    public static Function<Item, WeaponCapability.Builder> PRAY = (item) -> {
      WeaponCapability.Builder builder = WeaponCapability.builder()
              .category(AscendedWeaponCategories.PRAY)
              .styleProvider((playerpatch) -> Styles.OCHS)
              .canBePlacedOffhand(true)
              .newStyleCombo(Styles.OCHS, AscendedAnimations.PRAYER_AUTO, AscendedAnimations.PRAYER_AUTO_2, AscendedAnimations.PRAYER_DASH, AscendedAnimations.PRAYER_AIRSLASH)
              .livingMotionModifier(Styles.OCHS, LivingMotions.IDLE, AscendedAnimations.PRAYER_IDLE)
              .livingMotionModifier(Styles.OCHS, LivingMotions.KNEEL, AscendedAnimations.PRAYER_IDLE)
              .livingMotionModifier(Styles.OCHS, LivingMotions.SNEAK, AscendedAnimations.PRAYER_IDLE)
              .livingMotionModifier(Styles.OCHS, LivingMotions.WALK, AscendedAnimations.PRAYER_IDLE)
              .livingMotionModifier(Styles.OCHS, LivingMotions.RUN, AscendedAnimations.PRAYER_IDLE);
      return builder;
    };

    @SubscribeEvent
    public static void registerMovesets(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID,"jian"), JIAN);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "scythe"), SCYTHE);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "sweeping_scythe"), SWEEPING_SCYTHE);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "flute"), SUP_FLUTE);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "compat_pray"), PRAY);
    }
}
