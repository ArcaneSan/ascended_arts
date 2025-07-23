package net.arcane.ascended_arts.world.capabilities.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.gameasset.AscendedColliderPreset;
import net.arcane.ascended_arts.gameasset.AscendedSkills;

import net.arcane.ascended_arts.skill.weaponpassive.FloatingPassive;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)

public class WeaponCapabilityPresets {


    public static final Function<Item, CapabilityItem.Builder> JIAN = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.JIAN) // Updated to use custom category
                .styleProvider((playerpatch) -> playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == AscendedWeaponCategories.JIAN ? Styles.TWO_HAND : Styles.ONE_HAND)
                .collider(AscendedColliderPreset.JIAN)
                .canBePlacedOffhand(true)
                .newStyleCombo(Styles.ONE_HAND, AscendedAnimations.JIAN_AUTO_1, AscendedAnimations.JIAN_AUTO_2, AscendedAnimations.JIAN_AUTO_3, AscendedAnimations.JIAN_DASH, AscendedAnimations.JIAN_AIRSLASH)
                .newStyleCombo(Styles.TWO_HAND, AscendedAnimations.DUAL_JIAN_AUTO_1, AscendedAnimations.DUAL_JIAN_AUTO_2, AscendedAnimations.DUAL_JIAN_AUTO_3, AscendedAnimations.DUAL_JIAN_DASH, AscendedAnimations.DUAL_JIAN_AIRSLASH)
                .innateSkill(Styles.ONE_HAND, (itemstack) -> AscendedSkills.CELESTIAL_PUNISHMENT)
                .innateSkill(Styles.TWO_HAND, (itemstack) -> AscendedSkills.CELESTIAL_ONSLAUGHT)
                .passiveSkill(AscendedSkills.FLOATING_PASSIVE)
                .livingMotionModifier(Styles.COMMON, LivingMotions.IDLE, AscendedAnimations.BIPED_HOLD_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.WALK, AscendedAnimations.BIPED_WALK_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.RUN, AscendedAnimations.BIPED_RUN_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.SWIM, AscendedAnimations.JIAN_SWIM)
                .livingMotionModifier(Styles.COMMON, LivingMotions.DEATH, AscendedAnimations.JIAN_DEATH)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.BLOCK, AscendedAnimations.JIAN_GUARD)
                .livingMotionModifier(Styles.COMMON, LivingMotions.KNEEL, AscendedAnimations.BIPED_HOLD_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.SNEAK, AscendedAnimations.BIPED_WALK_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.CREATIVE_IDLE, AscendedAnimations.BIPED_HOLD_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.CREATIVE_FLY, AscendedAnimations.BIPED_RUN_JIAN)
                .livingMotionModifier(Styles.COMMON, LivingMotions.SLEEP, AscendedAnimations.JIAN_SLEEP)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, AscendedAnimations.DUAL_JIAN_GUARD)
                .livingMotionModifier(Styles.COMMON, LivingMotions.EAT, AscendedAnimations.JIAN_EAT)
                .livingMotionModifier(Styles.COMMON, LivingMotions.DRINK, AscendedAnimations.JIAN_DRINK)
                .weaponCombinationPredicator((entitypatch) -> EpicFightCapabilities.getItemStackCapability(entitypatch.getOriginal().getOffhandItem()).getWeaponCategory() == AscendedWeaponCategories.JIAN);

        return builder;
    };
    public static Function<Item, CapabilityItem.Builder> SCYTHE = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.SCYTHE)
                .styleProvider((playerpatch) -> Styles.TWO_HAND)
                .collider(AscendedColliderPreset.SCYTHE)
                .canBePlacedOffhand(false)
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                .passiveSkill(AscendedSkills.FLOATING_PASSIVE)
                .innateSkill(Styles.TWO_HAND, (itemstack) -> AscendedSkills.REAPING_GRASP)
                .newStyleCombo(Styles.TWO_HAND, AscendedAnimations.SCYTHE_AUTO_1, AscendedAnimations.SCYTHE_AUTO_2, AscendedAnimations.SCYTHE_AUTO_3, AscendedAnimations.SCYTHE_AUTO_4, AscendedAnimations.SCYTHE_DASH, AscendedAnimations.SCYTHE_AIRSLASH)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.IDLE, AscendedAnimations.BIPED_HOLD_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.KNEEL, AscendedAnimations.BIPED_KNEEL_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.WALK, AscendedAnimations.BIPED_WALK_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.RUN, AscendedAnimations.BIPED_RUN_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SLEEP, AscendedAnimations.SCYTHE_SLEEP)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.CREATIVE_IDLE, AscendedAnimations.BIPED_HOLD_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.CREATIVE_FLY, AscendedAnimations.BIPED_RUN_SCYTHE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, AscendedAnimations.SCYTHE_GUARD)
                .weaponCombinationPredicator((entitypatch) -> EpicFightCapabilities.getItemStackCapability(entitypatch.getOriginal().getOffhandItem()).getWeaponCategory() == AscendedWeaponCategories.SCYTHE);
      return builder;
    };

    @SubscribeEvent
    public static void registerMovesets(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID,"jian"), JIAN);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "scythe"), SCYTHE);
    }
}
