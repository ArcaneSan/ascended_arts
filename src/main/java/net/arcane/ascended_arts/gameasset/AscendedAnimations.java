package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
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
import yesman.epicfight.world.damagesource.StunType;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_JIAN_SLEEP;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_JIAN_SWIM;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_JIAN_EAT;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_JIAN_DRINK;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_SCYTHE_SLEEP;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_SCYTHE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_KNEEL_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_SNEAK_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_SCYTHE_SWIM;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_S_SCYTHE_HOLD;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_S_SCYTHE_KNEEL;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_S_SCYTHE_WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_S_SCYTHE_SNEAK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_S_SCYTHE_RUN;

    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<LongHitAnimation> JIAN_GUARD_BREAK;
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
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_JIAN_DASH;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_JIAN_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SCYTHE_AUTO_4;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> S_SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> S_SCYTHE_AUTO;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> S_SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> S_SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> S_SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> S_DUAL_SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> S_DUAL_SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> S_DUAL_SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> S_DUAL_SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT_FIRST;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT_SECOND;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT_FAIL;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_FIRST;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_FAIL;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_SECOND;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_SECOND_LAND;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT_THIRD;

    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_4;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_FINAL;

    public static AnimationManager.AnimationAccessor<AttackAnimation> CHASING_SWEEP;
    public static AnimationManager.AnimationAccessor<AttackAnimation> UNRELENTING_ASSAULT;

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
        BIPED_HOLD_JIAN = builder.nextAccessor("biped/living/jian/jian_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_JIAN = builder.nextAccessor("biped/living/jian/jian_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_JIAN = builder.nextAccessor("biped/living/jian/jian_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_JIAN_SLEEP = builder.nextAccessor("biped/living/jian/jian_sleep", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_JIAN_EAT = builder.nextAccessor("biped/living/jian/jian_eat", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_JIAN_DRINK = builder.nextAccessor("biped/living/jian/jian_drink", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_JIAN_SWIM = builder.nextAccessor("biped/living/jian/jian_swim", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.ON_ITEM_CHANGE_EVENT, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK_WHEN_ITEM_CHANGED, AnimationEvent.Side.CLIENT))
                .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS,
                        AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK, AnimationEvent.Side.CLIENT))
                .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS, AnimationEvent.Side.CLIENT))
                .newTimePair(0.0F, 500.0F));

        BIPED_WALK_SCYTHE = builder.nextAccessor("biped/living/scythe_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_SCYTHE = builder.nextAccessor("biped/living/scythe_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_HOLD_SCYTHE = builder.nextAccessor("biped/living/scythe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_KNEEL_SCYTHE = builder.nextAccessor("biped/living/scythe_kneel", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_SNEAK_SCYTHE = builder.nextAccessor("biped/living/scythe_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_SCYTHE_SLEEP = builder.nextAccessor("biped/living/scythe_sleep", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_SCYTHE_SWIM = builder.nextAccessor("biped/living/scythe_swim", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));

        BIPED_S_SCYTHE_HOLD = builder.nextAccessor("biped/living/ss/sweeping_scythe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_S_SCYTHE_KNEEL = builder.nextAccessor("biped/living/ss/sweeping_scythe_kneel", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_S_SCYTHE_WALK = builder.nextAccessor("biped/living/ss/sweeping_scythe_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_S_SCYTHE_SNEAK = builder.nextAccessor("biped/living/ss/sweeping_scythe_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_S_SCYTHE_RUN = builder.nextAccessor("biped/living/ss/sweeping_scythe_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));

        JIAN_GUARD = builder.nextAccessor("biped/skill/jian/jian_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        DUAL_JIAN_GUARD = builder.nextAccessor("biped/skill/jian/dual_jian_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/jian/jian_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
        JIAN_GUARD_BREAK = builder.nextAccessor("biped/skill/jian/jian_guard_break", (accessor) -> new LongHitAnimation(0.05F, accessor, Armatures.BIPED));
        DUAL_JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/jian/dual_jian_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
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
        JIAN_GUARD_PARRY_1 = builder.nextAccessor("biped/skill/jian/jian_guard_parry_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0F, 0.1F, 0.4F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder( 2.1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(90))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(3))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        JIAN_GUARD_PARRY_2 = builder.nextAccessor("biped/skill/jian/jian_guard_parry_2", (accessor) ->
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
        JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian/jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.1F, 0.15F, 0.3F, 0.31F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian/jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.08F, 0.12F, 0.14F, 0.15F, Armatures.BIPED.get().handL, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()),
                        new AttackAnimation.Phase(0.15F, 0.19F, 0.22F, 0.3F, 0.33F, 0.335F, Armatures.BIPED.get().toolR, null))
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.15F, ReusableEvents.FIRE_PARTICLES_HANDL, AnimationEvent.Side.CLIENT)));
        JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian/jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.3F, 0.31F, 0.32F, Armatures.BIPED.get().legR, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT)
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()),
                        new AttackAnimation.Phase(0.32F, 0.32F, 0.45F, 0.55F, 0.6F, 0.61F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2F)
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.3F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT)));


        DUAL_JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian/dual_jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.4F, 0.5F, 0.51F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.51F, 0.2F, 0.5F, 0.55F, 0.6F, 0.6F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));

        DUAL_JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian/dual_jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F,accessor, Armatures.BIPED,
                        new AttackAnimation.Phase( 0.0F, 0.2F,0.2F, 0.35F, 0.4F, 0.41F, Armatures.BIPED.get().legR, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()),
                        new AttackAnimation.Phase(0.42F, 0.42F, 0.45F, 0.5F, 0.55F, 0.56F, Armatures.BIPED.get().toolR, null))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.35F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT)));

        DUAL_JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian/dual_jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.5F, 0.6F, 0.61F, Armatures.BIPED.get().legR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()),
                        new AttackAnimation.Phase(0.61F, 0.61F, 0.64F, 0.7F, 0.75F, 0.76F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.7F))
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.0F, 0.55F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT)));


        JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian/jian_airslash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0F, 0.05F, 0.3F, 0.35F, 0.36F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.36F, 0.36F, 0.6F, 0.72F, 0.77F, 0.78F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 0.9F))
                        .addEvents(AnimationEvent.InTimeEvent.create(0.7F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(0.24F,-0.24F, -0.24F),
                                Armatures.BIPED.get().toolR, 2.1D, 0.8F))
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 0.9F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH))
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.15F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.21F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        JIAN_DASH = builder.nextAccessor("biped/combat/jian/jian_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.5F, 0.6F, 0.6F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.6F, 0.5F, 0.4F, 0.9F, 1F, 1.1F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.0F))
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
                                AnimationEvent.InTimeEvent.create(0.15F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.21F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        DUAL_JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian/dual_jian_airslash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.05F, 0.2F, 0.25F, 0.26F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.26F, 0.26F, 0.4F, 0.5F, 0.55F, 0.56F, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG),
                        new AttackAnimation.Phase(0.56F, 0.56F, 0.7F, 0.85F, .9F, 0.91F, InteractionHand.MAIN_HAND,
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null), AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null)),
                        new AttackAnimation.Phase(0.91F, 0.91F, 0.95F, 1.1F, 1.2F, 1.25F, InteractionHand.MAIN_HAND,
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().legR, AscendedColliderPreset.KICK), AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().legL, AscendedColliderPreset.KICK))
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 1.0F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.6F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT)
                        )
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.0F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH))
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(1.0F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(1.05F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        DUAL_JIAN_DASH = builder.nextAccessor("biped/combat/jian/dual_jian_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.2F, 0.35F, 0.37F, 0.38F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.38F, 0.2F, 0.39F, 0.45F, 0.47F, 0.48F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.48F, 0.48F, 0.55F, 0.8F, 0.85F, 0.86F, InteractionHand.MAIN_HAND,
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null), AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.5F))
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
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.49F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.51F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        SCYTHE_DASH = builder.nextAccessor("biped/combat/scythe_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.48F, 0.49F, 0.5F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.5F, 0.5F, 0.52F, 0.85F, 0.89F, 0.9F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.0F))
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.0F, (entitypatch, self, params) -> {
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

        S_SCYTHE_DASH = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.0F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_SCYTHE_AIRSLASH = builder.nextAccessor("biped/combat/ss/sweeping_scythe_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.3F)));
        S_SCYTHE_AUTO = builder.nextAccessor("biped/combat/ss/sweeping_scythe_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.0F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_SCYTHE_AUTO_2 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.0F, 0.05F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.0F, 0.05F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));

        S_DUAL_SCYTHE_DASH = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dual_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.3F, 0.35F, 0.39F, InteractionHand.MAIN_HAND,
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null), AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null)))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_DUAL_SCYTHE_AIRSLASH = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dual_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.05F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.13F, 0.13F, 0.15F, 0.3F, 0.35F, 0.37F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.3F)));
        S_DUAL_SCYTHE_AUTO_2 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dual_auto_2",(accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.05F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.13F, 0.13F, 0.15F, 0.25F, 0.29F, 0.3F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_DUAL_SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dual_auto_3",(accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.05F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.13F, 0.13F, 0.15F, 0.25F, 0.29F, 0.3F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));

        CELESTIAL_PUNISHMENT_FAIL = builder.nextAccessor("biped/skill/jian/celestial_punishment_fail", (accessor) ->
                new AttackAnimation(0.0F, 0.0F, 0.0F, 0.0F, 0.25F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.3F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.6F));

        CELESTIAL_PUNISHMENT_FIRST = builder.nextAccessor("biped/skill/jian/celestial_punishment_first", (accessor) ->
                new AttackAnimation(0.12F, 0.2F, 0.3F, 0.6F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.8F)));
        CELESTIAL_PUNISHMENT_SECOND = builder.nextAccessor("biped/skill/jian/celestial_punishment_second", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.5F, 0.51F, 0.52F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.52F, 0.52F, 0.6F, 0.72F, 0.75F, 0.76F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.76F, 0.76F, 0.9F, 1.1F, 1.15F, 1.16F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(1.16F, 1.16F, 1.2F, 1.4F, 1.45F, 1.46F, Armatures.BIPED.get().legR, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()))
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.08F, 1.5F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.0F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(AnimationEvent.InPeriodEvent.create(1.2F, 1.5F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT))
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
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(1.20F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(1.25F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        CELESTIAL_ONSLAUGHT_FIRST = builder.nextAccessor("biped/skill/jian/celestial_onslaught_first", (accessor) ->
                new AttackAnimation(0.12F, 0.2F, 0.3F, 0.52F, 0.55F, AscendedColliderPreset.KICK, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.2F, 0.5F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.08F, 0.65F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        CELESTIAL_ONSLAUGHT_FAIL = builder.nextAccessor("biped/skill/jian/celestial_onslaught_fail", (accessor) ->
                new AttackAnimation(0.0F, 0.0F, 0.0F, 0.0F, 0.25F, null, Armatures.BIPED.get().toolR,accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.3F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.6F));

        CELESTIAL_ONSLAUGHT_SECOND = builder.nextAccessor("biped/skill/jian/celestial_onslaught_second", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.25F, 0.3F, 0.31F, Armatures.BIPED.get().legL, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()),
                        new AttackAnimation.Phase(0.31F, 0.32F, 0.55F, 0.7F, 0.75F, 0.76F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.76F, 0.76F, 0.8F, 0.92F, 0.94F, 0.95F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.95F, 0.95F, 1.0F, 1.2F, 1.25F, 1.26F, Armatures.BIPED.get().toolL, null))
                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.8F)
                .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.08F, 1.25F))
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
        CELESTIAL_ONSLAUGHT_SECOND_LAND = builder.nextAccessor("biped/skill/jian/celestial_onslaught_second_land", (accessor) ->
                new AttackAnimation(0.0F, 0.0F, 0.0F, 0.0F, 0.25F, null, Armatures.BIPED.get().toolR,accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.3F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.6F)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.10F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.15F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        CELESTIAL_ONSLAUGHT_THIRD = builder.nextAccessor("biped/skill/jian/celestial_onslaught_third", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.5F, 0.6F, 0.62F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.62F,  0.62F, 0.63F, 0.7F, 0.73F, 0.74F, Armatures.BIPED.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.74F,  0.74F, 0.74F, 0.85F, 0.96F, 1.0F, Armatures.BIPED.get().legR, AscendedColliderPreset.KICK)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.1F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addEvents(AnimationEvent.InPeriodEvent.create(0.7F, 0.85F, ReusableEvents.FIRE_PARTICLES_LEGR, AnimationEvent.Side.CLIENT))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.2F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.66F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.69F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));


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

        CHASING_SWEEP = builder.nextAccessor("biped/skill/ss/chasing_sweep", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.45F, 0.62F, 0.64F, 0.65F, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH),
                        new AttackAnimation.Phase(0.65F, 0.65F, 0.7F, 0.75F, 0.8F, 0.81F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.9F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true));
        UNRELENTING_ASSAULT = builder.nextAccessor("biped/skill/ss/unrelenting_assault", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.21F, 0.22F, 0.23F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.23F, 0.23F, 0.24F, 0.34F, 0.36F, 0.37F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.37F, 0.37F, 0.37F, 0.45F, 0.47F, 0.48F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.48F,0.48F, 0.6F, 0.88F, 0.92F, 0.93F, InteractionHand.MAIN_HAND, AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));


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
        private static final int SPAWN_INTERVAL = 2;
        private static int tickCounter = 1;
        private static final Map<Entity, Integer> activeParticles = new HashMap<>();


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
                    EpicFightParticles.WHITE_AFTERIMAGE.get(),
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    Double.longBitsToDouble(entity.getId()),
                    0,
                    0
            );
        };

        //cherry
        private static final AnimationEvent.E0 CHERRY_PARTICLES = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            playerEntity.playSound(SoundEvents.AMETHYST_BLOCK_CHIME, 1F, 1.2F);
            if (playerEntity != null) {
                spawnCherryParticlesFollowingPlayer(playerEntity);
            }
        };
        private static final AnimationEvent.E0 CHERRY_PARTICLES_TINY = (entitypatch, self, params) -> {
            Entity playerEntity = Ascended_arts.proxy.getClientPlayer();
            if (playerEntity != null) {
                spawnCherryParticlesFollowingPlayer_Tiny(playerEntity);
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

        public static void spawnParticlesCherry() {
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
                            clientLevel.addParticle(ParticleTypes.CHERRY_LEAVES,
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
        public static void spawnParticlesCherryTiny() {
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
        private static void spawnParticlesEnderDelayed(Entity entity, RandomSource random) {
            scheduler.schedule(() -> spawnParticlesEnder(entity, random), 144, TimeUnit.MILLISECONDS);
        }
        public static void spawnCherryParticlesFollowingPlayer(Entity entity) {
            if (!activeParticles.containsKey(entity)) {
                activeParticles.put(entity, FOLLOW_DURATION);
            }
        }
        public static void spawnCherryParticlesFollowingPlayer_Tiny(Entity entity) {
            if (!activeParticles.containsKey(entity)) {
                activeParticles.put(entity, FOLLOW_DURATION_TINY);
            }
        }

    }
}