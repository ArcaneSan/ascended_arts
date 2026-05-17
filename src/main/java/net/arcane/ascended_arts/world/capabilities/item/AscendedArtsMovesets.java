package net.arcane.ascended_arts.world.capabilities.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.gameasset.AscendedSkills;

import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.data.Moveset;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.deferred.MovesetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredMoveset;
import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;


public class AscendedArtsMovesets
{
    private AscendedArtsMovesets() {}

    public static final MovesetRegister REGISTRY = MovesetRegister.create(Ascended_arts.MOD_ID);

    public static final DeferredMoveset JIAN_1H = REGISTRY.registerMoveset("jian_1h",
            () -> Moveset.builder()
                    .addLivingMotionsRecursive(AscendedAnimations.BIPED_HOLD_JIAN,
                            LivingMotions.IDLE, LivingMotions.KNEEL)
                    .addLivingMotionsRecursive(AscendedAnimations.BIPED_FLY_JIAN,
                            LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionModifier(LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_JIAN)
                    .addLivingMotionModifier(LivingMotions.WALK, AscendedAnimations.BIPED_WALK_JIAN)
                    .addLivingMotionModifier(LivingMotions.RUN, AscendedAnimations.BIPED_RUN_JIAN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AscendedAnimations.JIAN_GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, AscendedAnimations.JIAN_GUARD_HIT)
                    .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, AscendedAnimations.JIAN_GUARD_PARRY_1,
                            AscendedAnimations.JIAN_GUARD_PARRY_2)
                    .addComboAttacks(
                            AscendedAnimations.JIAN_AUTO_1, AscendedAnimations.JIAN_AUTO_2, AscendedAnimations.JIAN_AUTO_3,
                            AscendedAnimations.JIAN_AUTO_4, AscendedAnimations.JIAN_DASH, AscendedAnimations.JIAN_AIRSLASH
                    )
                    .addInnateSkill((itemstack, playerPatch) -> AscendedSkills.CELESTIAL_PUNISHMENT.get())
                    .setPassiveSkill(AscendedSkills.FLOATING_PASSIVE)
    );
    public static final DeferredMoveset JIAN_DUAL = REGISTRY.registerMoveset("jian_dual",
            () -> Moveset.builder()
                    .addLivingMotionsRecursive(AscendedAnimations.BIPED_HOLD_DUAL_JIAN,
                            LivingMotions.IDLE, LivingMotions.KNEEL)
                    .addLivingMotionsRecursive(AscendedAnimations.BIPED_FLY_JIAN,
                            LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionModifier(LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_DUAL_JIAN)
                    .addLivingMotionModifier(LivingMotions.WALK, AscendedAnimations.BIPED_WALK_DUAL_JIAN)
                    .addLivingMotionModifier(LivingMotions.RUN, AscendedAnimations.BIPED_RUN_DUAL_JIAN)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AscendedAnimations.DUAL_JIAN_GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, AscendedAnimations.DUAL_JIAN_GUARD_HIT)
                    .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, AscendedAnimations.JIAN_DUAL_GUARD_PARRY_1,
                            AscendedAnimations.JIAN_DUAL_GUARD_PARRY_2)
                    .addComboAttacks(
                            AscendedAnimations.DUAL_JIAN_AUTO_1, AscendedAnimations.DUAL_JIAN_AUTO_2, AscendedAnimations.DUAL_JIAN_AUTO_3,
                            AscendedAnimations.DUAL_JIAN_AUTO_4, AscendedAnimations.DUAL_JIAN_DASH, AscendedAnimations.DUAL_JIAN_AIRSLASH)
                    .addInnateSkill((itemstack, playerPatch) -> AscendedSkills.CELESTIAL_ONSLAUGHT.get())
                    .setPassiveSkill(AscendedSkills.FLOATING_PASSIVE)

            );
    public static final DeferredMoveset SCYTHE_2H = REGISTRY.registerMoveset("scythe",
            () -> Moveset.builder()
                    .addLivingMotionsRecursive(AscendedAnimations.BIPED_HOLD_SCYTHE,
                            LivingMotions.IDLE, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionsRecursive(AscendedAnimations.BIPED_RUN_SCYTHE,
                            LivingMotions.RUN, LivingMotions.CREATIVE_FLY)
                    .addLivingMotionModifier(LivingMotions.KNEEL, AscendedAnimations.BIPED_KNEEL_SCYTHE)
                    .addLivingMotionModifier(LivingMotions.WALK, AscendedAnimations.BIPED_WALK_SCYTHE)
                    .addLivingMotionModifier(LivingMotions.RUN, AscendedAnimations.BIPED_RUN_SCYTHE)
                    .addLivingMotionModifier(LivingMotions.SNEAK, AscendedAnimations.BIPED_SNEAK_SCYTHE)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AscendedAnimations.SCYTHE_GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, AscendedAnimations.SCYTHE_GUARD_HIT)
                    .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, AscendedAnimations.SCYTHE_GUARD_PARRY_1,
                            AscendedAnimations.SCYTHE_GUARD_PARRY_2)
                    .addComboAttacks(
                            AscendedAnimations.SCYTHE_AUTO_1, AscendedAnimations.SCYTHE_AUTO_2, AscendedAnimations.SCYTHE_AUTO_3,
                            AscendedAnimations.SCYTHE_AUTO_4, AscendedAnimations.SCYTHE_DASH, AscendedAnimations.SCYTHE_AIRSLASH)
                    .addInnateSkill((itemstack, playerPatch) -> AscendedSkills.REAPING_GRASP.get())
    );
    public static final DeferredMoveset S_SCYTHE = REGISTRY.registerMoveset("s_scythe",
            () -> Moveset.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, AscendedAnimations.BIPED_S_SCYTHE_HOLD)
                    .addLivingMotionModifier(LivingMotions.KNEEL, AscendedAnimations.BIPED_S_SCYTHE_KNEEL)
                    .addComboAttacks(
                            AscendedAnimations.S_SCYTHE_AUTO, AscendedAnimations.S_SCYTHE_AUTO_2, AscendedAnimations.S_SCYTHE_AUTO_3,
                            AscendedAnimations.S_SCYTHE_AUTO_2, AscendedAnimations.S_SCYTHE_AUTO_3, AscendedAnimations.S_SCYTHE_DASH,
                            AscendedAnimations.S_SCYTHE_AIRSLASH
                    )
                    .addInnateSkill((itemstack, playerPatch) -> EpicFightSkills.SWEEPING_EDGE.get())
    );
    public static final DeferredMoveset S_SCYTHE_2 = REGISTRY.registerMoveset("s_scythe_2",
            () -> Moveset.builder()
                    .parent(S_SCYTHE)
                    .addComboAttacks(
                            AscendedAnimations.S_SCYTHE_AUTO, AscendedAnimations.S_DUAL_SCYTHE_AUTO_2, AscendedAnimations.S_DUAL_SCYTHE_AUTO_3,
                            AscendedAnimations.S_DUAL_SCYTHE_AUTO_2, AscendedAnimations.S_DUAL_SCYTHE_AUTO_3, Animations.SWORD_DUAL_DASH,
                            AscendedAnimations.S_DUAL_SCYTHE_AIRSLASH
                    )
                    .addInnateSkill((itemstack, playerPatch) -> EpicFightSkills.DANCING_EDGE.get())
    );
    public static final DeferredMoveset SUP_FLUTE = REGISTRY.registerMoveset("flute",
            () -> Moveset.builder()
                    .addLivingMotionsRecursive(AscendedAnimations.FLUTE_IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.KNEEL, LivingMotions.SNEAK)
                    .addComboAttacks(
                            AscendedAnimations.FLUTE_AUTO, AscendedAnimations.FLUTE_AUTO_2,
                            AscendedAnimations.FLUTE_DASH, AscendedAnimations.FLUTE_AIRSLASH)
    );
    public static final DeferredMoveset PRAY = REGISTRY.registerMoveset("pray",
            () -> Moveset.builder()
                    .addLivingMotionsRecursive(AscendedAnimations.PRAYER_IDLE,
                            LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.KNEEL, LivingMotions.SNEAK)
                    .addComboAttacks(
                            AscendedAnimations.PRAYER_AUTO, AscendedAnimations.PRAYER_AUTO_2,
                            AscendedAnimations.PRAYER_DASH, AscendedAnimations.PRAYER_AIRSLASH
                    )
    );


}
