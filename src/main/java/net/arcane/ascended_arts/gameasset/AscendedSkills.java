package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;

import net.arcane.ascended_arts.skill.MartialSect.PlumBlossomSect;
import net.arcane.ascended_arts.skill.ascension_path.AscensionSkill;
import net.arcane.ascended_arts.skill.ascension_path.FoundationBuildingSkill;
import net.arcane.ascended_arts.skill.ascension_path.QiBuildingSkill;
import net.arcane.ascended_arts.skill.weaponinnate.*;
import net.arcane.ascended_arts.skill.weaponpassive.FloatingPassive;






import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.api.animation.property.AnimationProperty;

import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;


import java.util.Set;

public class AscendedSkills {
private AscendedSkills () {}

    public static final DeferredRegister<Skill> REGISTRY =
            DeferredRegister.create(EpicFightRegistries.Keys.SKILL, Ascended_arts.MOD_ID);



    public static final DeferredHolder<Skill, QiBuildingSkill> QI_BUILDING = REGISTRY.register("qi_building", key ->
            QiBuildingSkill.createAscensionBuilder(QiBuildingSkill::new).build(key));
    public static final DeferredHolder<Skill, FoundationBuildingSkill> FOUNDATION_BUILDING = REGISTRY.register("foundation_building", key ->
        FoundationBuildingSkill.createAscensionBuilder(FoundationBuildingSkill::new).build(key));
    public static final DeferredHolder<Skill, PlumBlossomSect> PLUM_BLOSSOM_SECT = REGISTRY.register("plum_blossom", key ->
            PlumBlossomSect.createMartialSectBuilder(PlumBlossomSect::new).build(key));


    public static final DeferredHolder <Skill, CelestialPunishmentSkill> CELESTIAL_PUNISHMENT = REGISTRY.register("celestial_punishment", key ->
            WeaponInnateSkill.createWeaponInnateBuilder(CelestialPunishmentSkill::new).setCategory(SkillCategories.WEAPON_INNATE)
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1))
                    .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(6))
                    .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1))
                    .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(100))
                    .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                .newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(1))
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(8))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER))
                    .build(key)
    );

    public static final DeferredHolder <Skill, CelestialOnslaughtSkill> CELESTIAL_ONSLAUGHT= REGISTRY.register("celestial_onslaught", key ->
            WeaponInnateSkill.createWeaponInnateBuilder(CelestialOnslaughtSkill::new).setCategory(SkillCategories.WEAPON_INNATE)
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1))
                    .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(6))
                    .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1))
                    .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(100))
                    .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(1))
                    .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(8))
                    .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER))
                    .build(key)

    );

    public static final DeferredHolder <Skill, ReapingGraspSkill> REAPING_GRASP = REGISTRY.register("reaping_grasp", key ->
            WeaponInnateSkill.createWeaponInnateBuilder(ReapingGraspSkill::new).setCategory(SkillCategories.WEAPON_INNATE)
                .newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(50))
                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(2))
                .newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(2))
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(50))
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(2))
                    .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(50))
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(2))
                    .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(50))
                    .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER))
                    .build(key)

    );

    public static final DeferredHolder <Skill, SimpleWeaponInnateSkill> REPEATING_SWEEP = REGISTRY.register("repeating_sweep", key ->
            SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                    .setAnimations(AscendedAnimations.REPEATING_SWEEP)
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.6F))
                    .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(6))
                    .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.6F))
                    .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE))
                    .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .build(key));

    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> CHASING_SWEEP = REGISTRY.register("chasing_sweep", key ->
            SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                    .setAnimations(AscendedAnimations.CHASING_SWEEP)
                    .newProperty()
                    .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.6F))
                    .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE))
                    .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                    .build(key));










}
