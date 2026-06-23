package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.skill.ascension_path.FoundationBuildingSkill;
import net.arcane.ascended_arts.skill.ascension_path.QiBuildingSkill;
import net.arcane.ascended_arts.skill.martial_sect.PlumBlossomSect;
import net.arcane.ascended_arts.skill.weaponinnate.*;
import net.arcane.ascended_arts.skill.weaponpassive.FloatingPassive;


import net.arcane.ascended_arts.skill.weaponpassive.LifeStealPassive;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.passive.PassiveSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;


import java.util.Set;

@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AscendedSkills {
    public static Skill CELESTIAL_PUNISHMENT;
    public static Skill CELESTIAL_ONSLAUGHT;
    public static Skill FLOATING_PASSIVE;
    public static Skill LIFESTEAL_PASSIVE;
    public static Skill REAPING_GRASP;
    public static Skill QI_BUILDING;
    public static Skill FOUNDATION_BUILDING;
    public static Skill PLUM_BLOSSOM;




    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent build) {
        SkillBuildEvent.ModRegistryWorker modRegistry = build.createRegistryWorker(Ascended_arts.MOD_ID);

        QI_BUILDING = modRegistry.build("qi_building", QiBuildingSkill::new, QiBuildingSkill.createQiBuildingBuilder());
        FOUNDATION_BUILDING = modRegistry.build("foundation_building", FoundationBuildingSkill::new, FoundationBuildingSkill.createFoundationBuildingBuilder());
        PLUM_BLOSSOM = modRegistry.build("plum_blossom", PlumBlossomSect::new, PlumBlossomSect.createPlumBlossomBuilder());


        WeaponInnateSkill celestial_punishment = modRegistry.build("celestial_punishment", CelestialPunishmentSkill :: new, WeaponInnateSkill.createWeaponInnateBuilder());
        celestial_punishment
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
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER));
        CELESTIAL_PUNISHMENT = celestial_punishment;

        WeaponInnateSkill celestial_onslaught = modRegistry.build("celestial_onslaught", CelestialOnslaughtSkill :: new, WeaponInnateSkill.createWeaponInnateBuilder());
        celestial_onslaught
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
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER));
        CELESTIAL_ONSLAUGHT = celestial_onslaught;

        WeaponInnateSkill reaping_grasp = modRegistry.build("reaping_grasp", ReapingGraspSkill :: new, WeaponInnateSkill.createWeaponInnateBuilder());
        reaping_grasp
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
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER));
        REAPING_GRASP = reaping_grasp;


        FLOATING_PASSIVE = modRegistry.build("floating_passive", FloatingPassive::new, PassiveSkill.createPassiveBuilder().setCategory(SkillCategories.WEAPON_PASSIVE).setActivateType(Skill.ActivateType.ONE_SHOT));
        LIFESTEAL_PASSIVE = modRegistry.build("lifesteal_passive", LifeStealPassive::new, PassiveSkill.createPassiveBuilder().setCategory(SkillCategories.WEAPON_PASSIVE).setActivateType(Skill.ActivateType.ONE_SHOT));



    }

    public AscendedSkills() {

    }
    public static void registerAscendedSkills(RegisterEvent bus) {

    }

}
