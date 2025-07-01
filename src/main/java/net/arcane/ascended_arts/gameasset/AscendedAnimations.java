package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.HitEntityList;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.damagesource.StunType;

public class AscendedAnimations {
    public static DirectStaticAnimation EMPTY_ANIMATION = new DirectStaticAnimation() {
        @Override
        public void loadAnimation() {

        }
        @Override
        public AnimationClip getAnimationClip() {
            return AnimationClip.EMPTY_CLIP;
        }
    };
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_JIAN;
    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_SLEEP;
    public static AnimationManager.AnimationAccessor<StaticAnimation> SCYTHE_SLEEP;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_SCYTHE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_KNEEL_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_SNEAK_SCYTHE;

    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<StaticAnimation> DUAL_JIAN_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> DUAL_JIAN_GUARD_HIT;


    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> JIAN_AIRSLASH;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> JIAN_DASH;

    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_JIAN_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_JIAN_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_JIAN_AUTO_3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_JIAN_AUTO_4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_JIAN_DASH;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_JIAN_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_4;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT_FIRST;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT_SECOND;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT_THIRD;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_FIRST;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_SECOND;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_THIRD;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_FOURTH;

    public static AnimationManager.AnimationAccessor<StaticAnimation> TESTER;



    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {

        TESTER = builder.nextAccessor("biped/living/tester", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_JIAN = builder.nextAccessor("biped/living/jian_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_JIAN = builder.nextAccessor("biped/living/jian_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_JIAN = builder.nextAccessor("biped/living/jian_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        JIAN_SLEEP = builder.nextAccessor("biped/living/jian_sleep", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));

        BIPED_WALK_SCYTHE = builder.nextAccessor("biped/living/scythe_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_SCYTHE = builder.nextAccessor("biped/living/scythe_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_HOLD_SCYTHE = builder.nextAccessor("biped/living/scythe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_KNEEL_SCYTHE = builder.nextAccessor("biped/living/scythe_kneel", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_SNEAK_SCYTHE = builder.nextAccessor("biped/living/scythe_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SCYTHE_SLEEP = builder.nextAccessor("biped/living/scythe_sleep", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));

        JIAN_GUARD = builder.nextAccessor("biped/skill/jian_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        DUAL_JIAN_GUARD = builder.nextAccessor("biped/skill/dual_jian_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/jian_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
        DUAL_JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/dual_jian_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
        JIAN_GUARD_PARRY_1 = builder.nextAccessor("biped/skill/jian_guard_parry_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0F, 0.1F, 0.4F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder( 2.1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(90))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(3))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        JIAN_GUARD_PARRY_2 = builder.nextAccessor("biped/skill/jian_guard_parry_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0F, 0.1F, 0.4F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder( 2.1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(90))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(3))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addState(EntityState.MOVEMENT_LOCKED, true));

        //change times once they work
        JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.2F, 0.3F, 0.6F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.3F, 0.4F, 0.4F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.2F, 0.1F, 0.3F, 1.0F, 1.2F, 1.6F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.3F, 0.4F, 0.3F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.1F, 0.3F, 0.4F, 0.8F, 0.9F, 0.5F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        JIAN_AUTO_4 = builder.nextAccessor("biped/combat/jian_auto_4", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.2F, 0.4F, 0.5F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true));

        DUAL_JIAN_AUTO_1 = builder.nextAccessor("biped/combat/dual_jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.4F, 0.5F, 0.51F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.51F, 0.2F, 0.5F, 0.55F, 0.6F, 0.6F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        DUAL_JIAN_AUTO_2 = builder.nextAccessor("biped/combat/dual_jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F,accessor, Armatures.BIPED,
                        new AttackAnimation.Phase( 0.0F, 0.2F,0.3F, 0.5F, 0.6F, Float.MAX_VALUE, InteractionHand.MAIN_HAND, AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        DUAL_JIAN_AUTO_3 = builder.nextAccessor("biped/combat/dual_jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.4F, 0.5F, 0.6F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)),
                        new AttackAnimation.Phase(0.1F, 0.2F, 0.2F, 0.4F, 0.5F, 0.6F, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)),
                        new AttackAnimation.Phase(0.6F, 0.1F, 0.5F, 0.7F, 0.8F, 0.9F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)),
                        new AttackAnimation.Phase(0.6F, 0.1F, 0.5F, 0.7F, 0.8F, 0.9F, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        DUAL_JIAN_AUTO_4 = builder.nextAccessor("biped/combat/dual_jian_auto_4", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.5F, 0.6F, 0.7F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)),
                        new AttackAnimation.Phase(0.1F, 0.2F, 0.4F, 0.5F, 0.6F, 0.8F, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)),
                        new AttackAnimation.Phase(0.7F, 0.2F, 0.6F, 1.0F, 1.1F, 1.2F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)),
                        new AttackAnimation.Phase(0.8F, 0.2F, 0.6F, 1.0F, 1.1F, 1.2F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));


        JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian_airslash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0F, 0.2F, 0.5F, 0.6F, 0.8F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.3F, 0F, 0.5F, 1F, 1.2F, 3.5F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 3.2F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.SYNCHED_TARGET_ENTITY_LOCATION_VARIABLE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_UPDATE_TIME, TimePairList.create(0.0F, 0.75F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, null)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_GET, MoveCoordFunctions.WORLD_COORD)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 3.5F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH))
        );
        JIAN_DASH = builder.nextAccessor("biped/combat/jian_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.5F, 0.6F, 0.6F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.6F, 0.5F, 0.4F, 0.9F, 1F, 1.1F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true)

                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.2F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)));

        DUAL_JIAN_AIRSLASH = builder.nextAccessor("biped/combat/dual_jian_airslash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.4F, 0.5F, 0.6F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.1F, 0.2F, 0.5F, 0.9F, 1.0F, 1.1F, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG),
                        new AttackAnimation.Phase(0.2F, 0.2F, 0.5F, 0.9F, 1.0F, 1.1F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 1.0F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.SYNCHED_TARGET_ENTITY_LOCATION_VARIABLE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_UPDATE_TIME, TimePairList.create(0.0F, 0.75F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, null)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_GET, MoveCoordFunctions.WORLD_COORD)

                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.0F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)));

        DUAL_JIAN_DASH = builder.nextAccessor("biped/combat/dual_jian_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.2F, 0.4F, 0.45F, 0.46F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.46F, 0.0F, 0.35F, 0.5F, 0.55F, 0.56F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.56F, 0.2F, 0.6F, 0.8F, 0.85F, 0.86F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.86F, 0.2F, 0.6F, 1.0F, 1.1F, 1.3F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true)

                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.2F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH))
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));

        SCYTHE_DASH = builder.nextAccessor("biped/combat/scythe_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.5F, 0.6F, 0.7F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.7F, 0.1F, 0.5F, 0.8F, 1.0F, 1.2F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.2F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH))
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        SCYTHE_AIRSLASH = builder.nextAccessor("biped/combat/scythe_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.2F, 0.45F, 0.5F, 0.51F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.51F, 0.2F, 0.71F, 0.8F, 0.9F, 0.91F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.0F)));

        SCYTHE_AUTO_1 = builder.nextAccessor("biped/combat/scythe_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.02F, 0.15F, 0.3F, 0.35F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_2 = builder.nextAccessor("biped/combat/scythe_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.1F, 0.2F, 0.4F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(25))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/scythe_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.28F, 0.3F, 0.31F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.31F, 0.2F, 0.36F,0.6F, 0.65F, 0.66F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_4 = builder.nextAccessor("biped/combat/scythe_auto_4", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.02F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.13F, 0.2F, 0.4F, 0.55F, 0.6F, 0.61F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));

        CELESTIAL_PUNISHMENT_FIRST = builder.nextAccessor("biped/skill/celestial_punishment_first", (accessor) ->
                new AttackAnimation(0.12F, 0.3F, 0.5F, 1.0F, 1.1F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        CELESTIAL_PUNISHMENT_SECOND = builder.nextAccessor("biped/skill/celestial_punishment_second", (accessor) ->
                new AttackAnimation(0.12F, 0.3F, 0.3F, 0.8F, 0.9F, AscendedColliderPreset.KICK, Armatures.BIPED.get().thighR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.08F, 1.0F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.1F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        CELESTIAL_PUNISHMENT_THIRD = builder.nextAccessor("biped/skill/celestial_punishment_third", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.01F, 0.2F, 0.25F, 0.26F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.26F, 0.1F, 0.1F, 0.5F, 0.55F, 0.6F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.6F, 0.1F, 0.6F, 1.0F, 1.2F, 0.8F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.9F, 0.1F, 0.8F, 1.9F, 2.0F, 1.5F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 3.3F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 3.3F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));

        CELESTIAL_ONSLAUGHT_FIRST = builder.nextAccessor("biped/skill/celestial_onslaught_first", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.4F, 0.42F, 0.43F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.43F, 0.2F, 0.3F, 0.5F, 0.6F, 0.7F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        CELESTIAL_ONSLAUGHT_SECOND = builder.nextAccessor("biped/skill/celestial_onslaught_second", (accessor) ->
                new AttackAnimation(0.12F, 0.2F, 0.3F, 0.9F, 1.0F, AscendedColliderPreset.SHOULDER, Armatures.BIPED.get().handR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.08F, 1.0F))
                .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                .addEvents(
                        AnimationEvent.InPeriodEvent.create(0.0F, 1.1F, (entitypatch, self, params) -> {
                            ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                            if (entitypatch.getOriginal() instanceof Player) {
                                Player player = (Player) entitypatch.getOriginal();
                                player.yCloak = 0.0;
                                player.yCloakO = 0.0;
                            }
                        }, AnimationEvent.Side.BOTH))
                .addState(EntityState.LOCKON_ROTATE, true)
                .addState(EntityState.MOVEMENT_LOCKED, true));

        CELESTIAL_ONSLAUGHT_THIRD = builder.nextAccessor("biped/skill/celestial_onslaught_third", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.2F, 0.25F, 0.26F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.26F,  0.1F, 0.1F, 0.2F, 0.26F, 0.27F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.27F,  0.2F, 0.5F, 0.7F, 0.8F, 0.81F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.81F,  0.2F, 0.6F, 0.8F, 0.9F, 9.1F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.91F,  0.2F, 0.8F, 1.0F, 1.1F, 1.11F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(1.11F,  0.2F, 0.9F, 1.2F, 1.3F, 1.31F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(1.31F,  0.2F, 1.1F, 1.3F, 1.4F, 1.41F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(1.41F,  0.2F, 1.2F, 1.4F, 1.5F, 1.6F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 3.3F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 3.3F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));

        CELESTIAL_ONSLAUGHT_FOURTH = builder.nextAccessor("biped/skill/celestial_onslaught_fourth", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.5F, 0.6F, 0.65F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.65F,0.5F, 0.6F, 0.8F, 0.9F, 1.0F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.3F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(AnimationEvent.InTimeEvent.create(0.5F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(2.2F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 2.1D, 0.55F))
                        .addEvents(AnimationEvent.InTimeEvent.create(1.0F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(2.2F, -0.24F, -2.0F), Armatures.BIPED.get().toolL, 2.1D, 0.55F))
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.3F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));


    }

}
