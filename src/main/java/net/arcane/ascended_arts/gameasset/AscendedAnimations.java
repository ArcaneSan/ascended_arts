package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
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
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.damagesource.EpicFightDamageType;
import yesman.epicfight.world.damagesource.StunType;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static net.arcane.ascended_arts.api.animation.JointTrack.getJointWithTranslation;

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
    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_EAT;
    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_DRINK;
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
    public static AnimationManager.AnimationAccessor<StaticAnimation> SCYTHE_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> SCYTHE_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_GUARD_PARRY_2;

    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_3;
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

    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_4;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_FINAL;

    public static AnimationManager.AnimationAccessor<StaticAnimation> TESTER;



    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {

        TESTER = builder.nextAccessor("biped/living/tester", (accessor) -> new StaticAnimation(false, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.ON_ITEM_CHANGE_EVENT, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK_WHEN_ITEM_CHANGED, AnimationEvent.Side.CLIENT))
                .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS,
                        AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK, AnimationEvent.Side.CLIENT))
                .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS, AnimationEvent.Side.CLIENT))
                .newTimePair(0.0F, 500.0F));
        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_JIAN = builder.nextAccessor("biped/living/jian_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_JIAN = builder.nextAccessor("biped/living/jian_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_JIAN = builder.nextAccessor("biped/living/jian_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        JIAN_SLEEP = builder.nextAccessor("biped/living/jian_sleep", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        JIAN_EAT = builder.nextAccessor("biped/living/jian_eat", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        JIAN_DRINK = builder.nextAccessor("biped/living/jian_drink", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));

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
        SCYTHE_GUARD = builder.nextAccessor("biped/skill/scythe_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED)
                .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.2F, (entitypatch, self, params) -> {
                    ((LivingEntity)entitypatch.getOriginal()).isInWater();
                    if (entitypatch.getOriginal() instanceof Player) {
                        Player player = (Player)entitypatch.getOriginal();
                        int numParticles = 2;
                        for (int i = 0; i < numParticles; i++) {
                            Vec3 pos = getJointWithTranslation(Minecraft.getInstance().player, player, new Vec3f(0, 0, 0), Armatures.BIPED.get().toolL);
                            if (pos != null) {
                                Random random = new Random();
                                double angle = random.nextDouble() * Math.PI * 2;
                                double phi = Math.acos(2 * random.nextDouble() - 1);
                                double speed = 0.1;
                                double vx = speed * Math.sin(phi) * Math.cos(angle);
                                double vy = speed * Math.sin(phi) * Math.sin(angle);
                                double vz = Math.cos(phi) * speed;

                                Particle particle = Minecraft.getInstance().particleEngine.createParticle(
                                        ParticleTypes.SCULK_SOUL, pos.x, pos.y, pos.z, vx, vy, vz
                                );
                                if (particle != null) {
                                    particle.scale(0.52f);
                                    particle.setLifetime(5);
                                }
                            }
                        }
                    }
                }, AnimationEvent.Side.CLIENT)));
        SCYTHE_GUARD_HIT = builder.nextAccessor("biped/skill/scythe_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
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
        SCYTHE_GUARD_PARRY_1 = builder.nextAccessor("biped/skill/scythe_guard_parry_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0F, 0.1F, 0.4F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder( 2.1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(90))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(3))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        SCYTHE_GUARD_PARRY_2 = builder.nextAccessor("biped/skill/scythe_guard_parry_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0F, 0.1F, 0.4F, 0.5F, AscendedColliderPreset.KICK, Armatures.BIPED.get().thighL, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder( 2.1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(20))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addState(EntityState.MOVEMENT_LOCKED, true));

        //change times once they work
        JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.1F, 0.15F, 0.3F, 0.31F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.08F, 0.12F, 0.14F, 0.15F, Armatures.BIPED.get().handL, AscendedColliderPreset.KICK),
                        new AttackAnimation.Phase(0.15F, 0.19F, 0.22F, 0.3F, 0.33F, 0.335F, Armatures.BIPED.get().toolR, null))
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.15F, ReusableEvents.FIRE_PARTICLES_HANDL, AnimationEvent.Side.CLIENT)));
        JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.3F, 0.31F, 0.32F, Armatures.BIPED.get().legR, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.32F, 0.32F, 0.45F, 0.55F, 0.6F, 0.61F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2F)
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.3F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT)));


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
                        new AttackAnimation.Phase(0.0F, 0F, 0.0F, 0.4F, 0.45F, 0.46F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.46F, 0.2F, 0.6F, 0.875F, 0.9F, 0.91F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG),
                        new AttackAnimation.Phase(0.91F, 0.2F, 0.91F, 1.3F, 1.4F, 1.5F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 1.5F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.SYNCHED_TARGET_ENTITY_LOCATION_VARIABLE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_UPDATE_TIME, TimePairList.create(0.0F, 1.5F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, null)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_GET, MoveCoordFunctions.WORLD_COORD)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.5F, (entitypatch, self, params) -> {
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
                                }, AnimationEvent.Side.BOTH))
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.15F, ReusableEvents.ENDER_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.21F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

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
                        new AttackAnimation.Phase(0.7F, 0.1F, 0.5F, 0.8F, 1.4F, 1.5F, Armatures.BIPED.get().toolR, null))
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
                new BasicAttackAnimation(0.12F, 0.02F, 0.15F, 0.3F, 0.5F, AscendedColliderPreset.SCYTHE_BOTTOM, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_2 = builder.nextAccessor("biped/combat/scythe_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.1F, 0.2F, 0.4F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(25))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/scythe_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.28F, 0.3F, 0.31F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.31F, 0.2F, 0.36F,0.6F, 0.8F, 0.81F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_4 = builder.nextAccessor("biped/combat/scythe_auto_4", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.02F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.13F, 0.2F, 0.4F, 0.55F, 0.8F, 0.81F, Armatures.BIPED.get().toolR, null))
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
                        new AttackAnimation.Phase(0.26F, 0.2F, 0.45F, 0.7F, 0.73F, 0.74F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.74F, 0.1F, 0.6F, 1.0F, 1.2F, 0.8F, Armatures.BIPED.get().toolR, null),
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
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.4F, 0.42F, 0.43F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD),
                        new AttackAnimation.Phase(0.43F, 0.0F, 0.2F, 0.5F, 0.6F, 0.7F, Armatures.BIPED.get().toolL, null))
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
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.0F, 0.14F, 0.15F, 0.16F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.16F,  0.1F, 0.12F, 0.2F, 0.25F, 0.26F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.26F,  0.2F, 0.5F, 0.65F, 0.66F, 0.67F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.67F,  0.2F, 0.67F, 0.8F, 0.81F, 0.82F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.82F,  0.2F, 0.82F, 0.95F, 0.96F, 0.97F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.97F,  0.2F, 0.97F, 1.05F, 1.06F, 1.07F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(1.07F,  0.2F, 1.07F, 1.3F, 1.31F, 1.32F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(1.32F,  0.2F, 1.1F, 1.35F, 1.36F, 1.37F, InteractionHand.OFF_HAND, Armatures.BIPED.get().toolL, null))
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
                        .addEvents(AnimationEvent.InTimeEvent.create(0.55F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(2.2F, 0.24F, -1.8F), Armatures.BIPED.get().toolR, 2.1D, 0.55F))
                        .addEvents(AnimationEvent.InTimeEvent.create(0.90F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(2.2F, 0.24F, -1.8F), Armatures.BIPED.get().toolL, 2.1D, 0.55F))
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

        REAPING_GRASP_1 = builder.nextAccessor("biped/skill/reaping_grasp_1", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.2F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true));

        REAPING_GRASP_2 = builder.nextAccessor("biped/skill/reaping_grasp_2", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        REAPING_GRASP_3 = builder.nextAccessor("biped/skill/reaping_grasp_3", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.4F, 0.5F, 0.51F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.51F, 0.2F, 0.51F, 0.8F, 0.9F, 0.91F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true));

        REAPING_GRASP_4 = builder.nextAccessor("biped/skill/reaping_grasp_4", (accessor) ->
        new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.4F, 0.45F, 0.46F, Armatures.BIPED.get().toolR, null),
                new AttackAnimation.Phase(0.46F, 0.2F, 0.46F, 0.6F, 0.65F, 0.66F, Armatures.BIPED.get().toolR, null)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        REAPING_GRASP_FINAL = builder.nextAccessor("biped/skill/reaping_grasp_final", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.5F, 0.8F, 0.85F, 0.86F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true));


    }
    public interface IProxy {
        @Nullable
        Entity getClientPlayer();
    }
    public static class ClientProxy implements IProxy {
        @Override
        public Entity getClientPlayer() {
            return Minecraft.getInstance().player;
        }
    }
    public static class ServerProxy implements IProxy {
        @Override
        public Entity getClientPlayer() {
            return null;
        }
    }
    // Particles and stuff
    public static class ReusableEvents {
        private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        private static final int ENDER_PARTICLE_COUNT = 69;
        private static final int PARTICLE_COUNT = 20;
        private static final int FOLLOW_DURATION = 18;
        private static final int PARTICLE_COUNT_TINY = 12;
        private static final int FOLLOW_DURATION_TINY = 12;
        private static final int SPAWN_ALWAYS = 1;
        private static final int SPAWN_INTERVAL = 2;
        private static int tickCounter = 1;
        private static final Map<Entity, Integer> activeParticles = new HashMap<>();
        private static final Map<Entity, Integer> activeParticlesWither = new HashMap<>();
        private static final Map<Entity, Integer> activeParticlesWitherBig = new HashMap<>();
        private static final Map<Entity, Integer> activeParticlesWitherTiny = new HashMap<>();
        private static final Map<Entity, Integer> activeParticlesAmethyst = new HashMap<>();

        //ENDER
        private static final AnimationEvent.E0 ENDER_PARTICLES = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            RandomSource random = entitypatch.getOriginal().getRandom();
            entity.playSound(SoundEvents.FOX_TELEPORT, 1F, 1.2F);
            scheduler.schedule(() -> {
                spawnParticlesEnder(entity, random);
            }, 48, TimeUnit.MILLISECONDS);
            spawnParticlesEnderDelayed(entity, random);
        };
        private static final AnimationEvent.E0 ENDER_IMAGE = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            entity.level().addParticle(
                    EpicFightParticles.ENTITY_AFTER_IMAGE.get(),
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    Double.longBitsToDouble(entity.getId()),
                    0,
                    0
            );
        };

        //fire?
        private static final AnimationEvent.E0 FIRE_PARTICLES = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnFireParticlesFollowingPlayer(playerEntity);
            }
        };
        private static final AnimationEvent.E0 FIRE_PARTICLES_TINY = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnFireParticlesFollowingPlayer_Tiny(playerEntity);
            }
        };
        private static final AnimationEvent.E0 FIRE_PARTICLES_HANDL = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                int numParticles = 5;
                for (int i = 0; i < numParticles; i++) {
                    Vec3 wep = getJointWithTranslation(Minecraft.getInstance().player, entity, new Vec3f(0F, 0F, 0F), Armatures.BIPED.get().handL);
                    if (wep != null) {
                        Vec3 direction = playerEntity.getLookAngle().normalize();
                        double t = (double)i / numParticles;
                        Vec3 point = wep.add(direction.scale(t * 2));
                        Particle particle1 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME,
                                point.x, point.y, point.z,
                                0,
                                0,
                                0
                        );
                        Particle particle2 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.SMOKE,
                                point.x, point.y, point.z,
                                0,
                                0,
                                0
                        );
                        if (particle1 != null & particle2 != null) {
                            particle1.scale(0.86F);
                            particle1.setLifetime(12);
                            particle2.scale(0.86F);
                            particle2.setLifetime(8);
                        }
                    }
                }
            }
        };
        private static final AnimationEvent.E0 FIRE_PARTICLES_LEGR = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                int numParticles = 2;
                for (int i = 0; i < numParticles; i++) {
                    Vec3 wep = getJointWithTranslation(Minecraft.getInstance().player, entity, new Vec3f(0F, 0F, 0F), Armatures.BIPED.get().legR);
                    if (wep != null) {
                        Vec3 direction = playerEntity.getLookAngle().normalize();
                        double t = (double)i / numParticles;
                        Vec3 point = wep.add(direction.scale(t * 2));
                        Particle particle1 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME,
                                point.x, point.y, point.z,
                                0,
                                0,
                                0
                        );
                        Particle particle2 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.SMOKE,
                                point.x, point.y, point.z,
                                0,
                                0,
                                0
                        );
                        if (particle1 != null & particle2 != null) {
                            particle1.scale(0.86F);
                            particle1.setLifetime(6);
                            particle2.scale(0.86F);
                            particle2.setLifetime(3);
                        }
                    }
                }
            }
        };


        //WITHER
        private static final AnimationEvent.E0 WITHER_PARTICLES = (entitypatch, self, params) -> {
                Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnWitherParticlesFollowingPlayer(playerEntity);
            }
        };
        private static final AnimationEvent.E0 WITHER_PARTICLES_TINY = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnWitherParticlesFollowingPlayer_Tiny(playerEntity);
            }
        };
        private static final AnimationEvent.E0 WITHER_PARTICLES_BIG = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnWitherParticlesFollowingPlayer_Big(playerEntity);
            }
        };
        private static final AnimationEvent.E0 WITHER_PARTICLES_INSTANT = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            Entity entity = entitypatch.getOriginal();
            RandomSource random = entitypatch.getOriginal().getRandom();
            if (playerEntity != null) {
                spawnParticlesWitherInstant(entity, random);
            }
        };
        private static final AnimationEvent.E0 WITHER_PARTICLES_SOUND = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                entity.playSound(SoundEvents.WITHER_AMBIENT);
            }
        };

        //AMETHYST
        private static final AnimationEvent.E0 AMETHYST_PARTICLES = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnAmethystParticlesFollowingPlayer(playerEntity);
            }
        };
        private static final AnimationEvent.E0 AMETHYST_IMAGE_PARTICLES_TINY = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                entity.level().addParticle(
                        EpicFightParticles.ENTITY_AFTER_IMAGE.get(),
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        Double.longBitsToDouble(entity.getId()),
                        0,
                        0
                );
            }
        };
        private static final AnimationEvent.E0 AMETHYST_PARTICLES_TINY = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnAmethystParticlesFollowingPlayer_Tiny(playerEntity);
            }
        };

        //PARTICLE SPAWNERS
        private static void spawnParticlesEnder(Entity entity, RandomSource random) {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {
                double horizontalRadius = 1.2;
                for (int i = 0; i < ENDER_PARTICLE_COUNT; i++) {
                    double xOffset = (random.nextDouble() - 0.4) * horizontalRadius;
                    double yOffset = (random.nextDouble() - random.nextDouble()) * 1.4D;
                    double zOffset = (random.nextDouble() - 0.4) * horizontalRadius;

                    clientLevel.addParticle(ParticleTypes.PORTAL,
                            entity.getX() + xOffset,
                            entity.getY() + yOffset,
                            entity.getZ() + zOffset,
                            0,
                            0.6,
                            0
                    );
                }
            }
        }

        public static void spawnParticlesFire() {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {

                RandomSource random = RandomSource.create();
                tickCounter++;

                activeParticles.entrySet().removeIf(entry -> {
                    Entity entity = entry.getKey();
                    int ticksRemaining = entry.getValue();
                    if (ticksRemaining <= 0 || !entity.isAlive()) {
                        return true;
                    }
                    if (tickCounter % SPAWN_INTERVAL == 0) {
                        double sphereRadius = 0.69;
                        double yStretchFactor = 1.42;
                        for (int i = 0; i < PARTICLE_COUNT; i++) {
                            double theta = random.nextDouble() * 2 * Math.PI;
                            double phi = Math.acos(2 * random.nextDouble() - 1);
                            double xOffset = sphereRadius * Math.sin(phi) * Math.cos(theta);
                            double yOffset = sphereRadius * Math.sin(phi) * Math.sin(theta) * yStretchFactor + 0.5;
                            double zOffset = sphereRadius * Math.cos(phi);
                            double vxOffset = xOffset * -0.1;
                            double vyOffset = yOffset * -0.1;
                            double vzOffset = zOffset * -0.1;
                            clientLevel.addParticle(ParticleTypes.RAIN,
                                    entity.getX() + xOffset,
                                    entity.getY() + yOffset + 0.3,
                                    entity.getZ() + zOffset,
                                    vxOffset,
                                    vyOffset,
                                    vzOffset
                            );
                        }
                    }
                    entry.setValue(ticksRemaining - 1);
                    return false;
                });
            }
        }
        public static void spawnParticlesFireTiny() {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {

                RandomSource random = RandomSource.create();
                tickCounter++;

                activeParticles.entrySet().removeIf(entry -> {
                    Entity entity = entry.getKey();
                    int ticksRemaining = entry.getValue();

                    if (ticksRemaining <= 0 || !entity.isAlive()) {
                        return true;
                    }
                    if (tickCounter % SPAWN_INTERVAL == 0) {
                        double horizontalRadius = 1.2;
                        for (int i = 0; i < PARTICLE_COUNT_TINY; i++) {
                            double xOffset = (random.nextDouble() - 0.5) * horizontalRadius;
                            double yOffset = (random.nextDouble() - random.nextDouble()) * 1.5D;
                            double zOffset = (random.nextDouble() - 0.5) * horizontalRadius;

                            clientLevel.addParticle(ParticleTypes.FALLING_WATER,
                                    entity.getX() + xOffset,
                                    entity.getY() + yOffset,
                                    entity.getZ() + zOffset,
                                    0,
                                    0.5,
                                    0
                            );
                        }
                    }
                    entry.setValue(ticksRemaining - 1);
                    return false;
                });
            }
        }

        public static void spawnParticlesWither() {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {

                RandomSource random = RandomSource.create();
                tickCounter++;

                activeParticlesWither.entrySet().removeIf(entry -> {
                    Entity entity = entry.getKey();
                    int ticksRemaining = entry.getValue();
                    if (ticksRemaining <= 0 || !entity.isAlive()) {
                        return true;
                    }
                    if (tickCounter % SPAWN_INTERVAL == 0) {
                        double sphereRadius = 0.66;
                        for (int i = 0; i < PARTICLE_COUNT_TINY; i++) {
                            double theta = random.nextDouble() * 2 * Math.PI;
                            double phi = Math.acos(2 * random.nextDouble() - 1);
                            double xOffset = sphereRadius * Math.sin(phi) * Math.cos(theta);
                            double yOffset = sphereRadius * Math.sin(phi) * Math.sin(theta);
                            double zOffset = sphereRadius * Math.cos(phi);
                            double vxOffset = xOffset * 0.2;
                            double vyOffset = yOffset * 0.2;
                            double vzOffset = zOffset * 0.2;
                            clientLevel.addParticle(ParticleTypes.LARGE_SMOKE,
                                    entity.getX() + xOffset,
                                    entity.getY() + yOffset + 0.6,
                                    entity.getZ() + zOffset,
                                    vxOffset,
                                    vyOffset,
                                    vzOffset
                            );
                        }
                    }
                    entry.setValue(ticksRemaining - 1);
                    return false;
                });
            }
        }
        public static void spawnParticlesWitherBig() {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {

                RandomSource random = RandomSource.create();
                tickCounter++;

                activeParticlesWitherBig.entrySet().removeIf(entry -> {
                    Entity entity = entry.getKey();
                    int ticksRemaining = entry.getValue();
                    if (ticksRemaining <= 0 || !entity.isAlive()) {
                        return true;
                    }
                    if (tickCounter % SPAWN_ALWAYS == 0) {
                        double sphereRadius = 2;
                        for (int i = 0; i < PARTICLE_COUNT; i++) {
                            double theta = random.nextDouble() * 2 * Math.PI;
                            double phi = Math.acos(2 * random.nextDouble() - 1);
                            double xOffset = sphereRadius * Math.sin(phi) * Math.cos(theta);
                            double yOffset = sphereRadius * Math.sin(phi) * Math.sin(theta);
                            double zOffset = sphereRadius * Math.cos(phi);
                            double vxOffset = xOffset * 0.2;
                            double vyOffset = yOffset * 0.2;
                            double vzOffset = zOffset * 0.2;
                            clientLevel.addParticle(ParticleTypes.LARGE_SMOKE,
                                    entity.getX() + xOffset,
                                    entity.getY() + yOffset,
                                    entity.getZ() + zOffset,
                                    vxOffset,
                                    vyOffset,
                                    vzOffset
                            );
                        }
                    }
                    entry.setValue(ticksRemaining - 1);
                    return false;
                });
            }
        }
        public static void spawnParticlesWitherTiny() {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {

                RandomSource random = RandomSource.create();
                tickCounter++;

                activeParticlesWitherTiny.entrySet().removeIf(entry -> {
                    Entity entity = entry.getKey();
                    int ticksRemaining = entry.getValue();

                    if (ticksRemaining <= 0 || !entity.isAlive()) {
                        return true;
                    }
                    if (tickCounter % SPAWN_INTERVAL == 0) {
                        double horizontalRadius = 1.2;
                        for (int i = 0; i < PARTICLE_COUNT; i++) {
                            double hxOffset = (random.nextDouble() - 0.6) * horizontalRadius;
                            double hyOffset = (random.nextDouble() - random.nextDouble()) * 1.8D;
                            double hzOffset = (random.nextDouble() - 0.6) * horizontalRadius;
                            double vxOffset = random.nextDouble() * (0.06 - (-0.06)) - 0.06;
                            double vyOffset = 0.066;
                            double vzOffset = random.nextDouble() * (0.06 - (-0.06)) - 0.06;

                            clientLevel.addParticle(ParticleTypes.SMOKE,
                                    entity.getX() + hxOffset,
                                    entity.getY() + hyOffset,
                                    entity.getZ() + hzOffset,
                                    vxOffset,
                                    vyOffset,
                                    vzOffset
                            );
                        }
                    }
                    entry.setValue(ticksRemaining - 1);
                    return false;
                });
            }
        }
        private static void spawnParticlesWitherInstant(Entity entity, RandomSource random) {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {
                double sphereRadius = 0.66;
                for (int i = 0; i < 18; i++) {
                    double theta = random.nextDouble() * 2 * Math.PI;
                    double phi = Math.acos(2 * random.nextDouble() - 1);
                    double xOffset = sphereRadius * Math.sin(phi) * Math.cos(theta);
                    double yOffset = sphereRadius * Math.sin(phi) * Math.sin(theta);
                    double zOffset = sphereRadius * Math.cos(phi);
                    double vxOffset = xOffset * 0.2;
                    double vyOffset = yOffset * 0.2;
                    double vzOffset = zOffset * 0.2;

                    clientLevel.addParticle(ParticleTypes.LARGE_SMOKE,
                            entity.getX() + xOffset,
                            entity.getY() + yOffset + 0.6,
                            entity.getZ() + zOffset,
                            vxOffset,
                            vyOffset,
                            vzOffset
                    );
                }
            }
        }

        public static void spawnParticlesAmethyst() {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {

                RandomSource random = RandomSource.create();
                tickCounter++;

                activeParticlesAmethyst.entrySet().removeIf(entry -> {
                    Entity entity = entry.getKey();
                    int ticksRemaining = entry.getValue();
                    if (ticksRemaining <= 0 || !entity.isAlive()) {
                        return true;
                    }
                    if (tickCounter % SPAWN_INTERVAL == 0) {
                        double sphereRadius = 1;
                        double yStretchFactor = 1.2;
                        for (int i = 0; i < PARTICLE_COUNT; i++) {
                            double theta = random.nextDouble() * 2 * Math.PI;
                            double phi = Math.acos(2 * random.nextDouble() - 1);
                            double xOffset = sphereRadius * Math.sin(phi) * Math.cos(theta);
                            double yOffset = sphereRadius * Math.sin(phi) * Math.sin(theta) * yStretchFactor + 0.4;
                            double zOffset = sphereRadius * Math.cos(phi);
                            double vxOffset = xOffset * -0.64;
                            double vyOffset = yOffset * -0.64;
                            double vzOffset = zOffset * -0.64;
                            clientLevel.addParticle(ParticleTypes.ENCHANT,
                                    entity.getX() + xOffset,
                                    entity.getY() + yOffset + 0.7,
                                    entity.getZ() + zOffset,
                                    vxOffset,
                                    vyOffset,
                                    vzOffset
                            );
                        }
                    }
                    entry.setValue(ticksRemaining - 1);
                    return false;
                });
            }
        }

        private static void spawnParticlesEnderDelayed(Entity entity, RandomSource random) {
            scheduler.schedule(() -> spawnParticlesEnder(entity, random), 144, TimeUnit.MILLISECONDS);
        }
        public static void spawnFireParticlesFollowingPlayer(Entity entity) {
            if (!activeParticles.containsKey(entity)) {
                activeParticles.put(entity, FOLLOW_DURATION);
            }
        }
        public static void spawnFireParticlesFollowingPlayer_Tiny(Entity entity) {
            if (!activeParticles.containsKey(entity)) {
                activeParticles.put(entity, FOLLOW_DURATION_TINY);
            }
        }
        public static void spawnWitherParticlesFollowingPlayer(Entity entity) {
            if (!activeParticlesWither.containsKey(entity)) {
                activeParticlesWither.put(entity, FOLLOW_DURATION_TINY);
            }
        }
        public static void spawnWitherParticlesFollowingPlayer_Big(Entity entity) {
            if (!activeParticlesWitherBig.containsKey(entity)) {
                activeParticlesWitherBig.put(entity, FOLLOW_DURATION);
            }
        }
        public static void spawnWitherParticlesFollowingPlayer_Tiny(Entity entity) {
            if (!activeParticlesWitherTiny.containsKey(entity)) {
                activeParticlesWitherTiny.put(entity, FOLLOW_DURATION_TINY);
            }
        }
        public static void spawnAmethystParticlesFollowingPlayer(Entity entity) {
            if (!activeParticlesAmethyst.containsKey(entity)) {
                activeParticlesAmethyst.put(entity, FOLLOW_DURATION);
            }
        }
        public static void spawnAmethystParticlesFollowingPlayer_Tiny(Entity entity) {
            if (!activeParticlesAmethyst.containsKey(entity)) {
                activeParticlesAmethyst.put(entity, FOLLOW_DURATION_TINY);
            }
        }
    }
}