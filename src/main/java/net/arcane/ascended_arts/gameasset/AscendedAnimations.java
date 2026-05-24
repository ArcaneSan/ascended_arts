package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;


import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;


import net.neoforged.bus.api.SubscribeEvent;
import yesman.epicfight.api.animation.*;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.HitEntityList;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.QuaternionUtils;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;

import yesman.epicfight.registry.entries.EpicFightParticles;
import yesman.epicfight.registry.entries.EpicFightSounds;



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
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_DUAL_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_SNEAK_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_DUAL_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_SNEAK_DUAL_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_DUAL_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_FLY_JIAN;


    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_SCYTHE_SLEEP;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_SCYTHE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_KNEEL_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_SCYTHE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_SNEAK_SCYTHE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_S_SCYTHE_HOLD;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_S_SCYTHE_KNEEL;


    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_DUAL_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<LongHitAnimation> JIAN_GUARD_BREAK;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_DUAL_GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_DUAL_GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<StaticAnimation> DUAL_JIAN_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> DUAL_JIAN_GUARD_HIT;

    public static AnimationManager.AnimationAccessor<StaticAnimation> SCYTHE_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> SCYTHE_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> SCYTHE_GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> SCYTHE_GUARD_PARRY_2;

    public static AnimationManager.AnimationAccessor<AttackAnimation> JIAN_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> JIAN_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> JIAN_AUTO_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> JIAN_AUTO_4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> JIAN_AIRSLASH;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> JIAN_DASH;

    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_JIAN_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_JIAN_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_JIAN_AUTO_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_JIAN_AUTO_4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_JIAN_DASH;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_JIAN_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> SCYTHE_AUTO_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> SCYTHE_AUTO_4;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> S_SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> S_SCYTHE_AUTO;
    public static AnimationManager.AnimationAccessor<AttackAnimation> S_SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> S_SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> S_SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<DashAttackAnimation> S_DUAL_SCYTHE_DASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> S_DUAL_SCYTHE_AUTO_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> S_DUAL_SCYTHE_AUTO_3;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> S_DUAL_SCYTHE_AIRSLASH;

    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_DIVE;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_DIVE_MISS;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_PUNISHMENT;
    public static AnimationManager.AnimationAccessor<AttackAnimation> CELESTIAL_ONSLAUGHT;


    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> REAPING_GRASP_4;

    public static AnimationManager.AnimationAccessor<EmoteAnimation> BIPED_DAB;
    public static AnimationManager.AnimationAccessor<EmoteAnimation> BIPED_BACKFLIP;
    public static AnimationManager.AnimationAccessor<EmoteAnimation> BRINGITA;
    public static AnimationManager.AnimationAccessor<EmoteAnimation> DOGEZA;




    // public static AnimationManager.AnimationAccessor<BasicAttackAnimation> TESTER;



    public static AnimationManager.AnimationAccessor<StaticAnimation> FLUTE_IDLE;
    public static AnimationManager.AnimationAccessor<AttackAnimation> FLUTE_AUTO;
    public static AnimationManager.AnimationAccessor<AttackAnimation> FLUTE_AUTO_2;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> FLUTE_DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> FLUTE_AIRSLASH;
    public static AnimationManager.AnimationAccessor<StaticAnimation> PRAYER_IDLE;
    public static AnimationManager.AnimationAccessor<AttackAnimation> PRAYER_AUTO;
    public static AnimationManager.AnimationAccessor<AttackAnimation> PRAYER_AUTO_2;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> PRAYER_DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> PRAYER_AIRSLASH;
    public static AnimationManager.AnimationAccessor<MirrorAnimation> BIPED_FLUTE_USE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLUTE_TWOHAND;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLUTE_OFFHAND;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLUTE_MAINHAND;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLUTE_TWOHAND_MOVE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLUTE_OFFHAND_MOVE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLUTE_MAINHAND_MOVE;







    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {



        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_JIAN = builder.nextAccessor("biped/living/jian/jian_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_HOLD_DUAL_JIAN = builder.nextAccessor("biped/living/jian/jian_dual_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_JIAN = builder.nextAccessor("biped/living/jian/jian_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_SNEAK_JIAN = builder.nextAccessor("biped/living/jian/jian_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_JIAN = builder.nextAccessor("biped/living/jian/jian_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_DUAL_JIAN = builder.nextAccessor("biped/living/jian/jian_dual_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_SNEAK_DUAL_JIAN = builder.nextAccessor("biped/living/jian/jian_dual_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_DUAL_JIAN = builder.nextAccessor("biped/living/jian/jian_dual_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_FLY_JIAN = builder.nextAccessor("biped/living/jian/jian_fly", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_SCYTHE = builder.nextAccessor("biped/living/scythe/scythe_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_SCYTHE = builder.nextAccessor("biped/living/scythe/scythe_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_HOLD_SCYTHE = builder.nextAccessor("biped/living/scythe/scythe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_KNEEL_SCYTHE = builder.nextAccessor("biped/living/scythe/scythe_kneel", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_SNEAK_SCYTHE = builder.nextAccessor("biped/living/scythe/scythe_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_SCYTHE_SLEEP = builder.nextAccessor("biped/living/scythe/scythe_sleep", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));


        BIPED_S_SCYTHE_HOLD = builder.nextAccessor("biped/living/ss/sweeping_scythe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_S_SCYTHE_KNEEL = builder.nextAccessor("biped/living/ss/sweeping_scythe_kneel", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));

        BIPED_DAB = builder.nextAccessor("biped/emote/dab", (accessor) ->
                new EmoteAnimation(0.1F, accessor, Armatures.BIPED)
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK, AnimationEvent.Side.CLIENT))
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS, AnimationEvent.Side.CLIENT))
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
        );
        BIPED_BACKFLIP = builder.nextAccessor("biped/emote/backflip", (accessor) ->
                new EmoteAnimation(0.1F, accessor, Armatures.BIPED)
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK, AnimationEvent.Side.CLIENT))
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS, AnimationEvent.Side.CLIENT))
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
        );
        BRINGITA = builder.nextAccessor("biped/emote/bringitaround", (accessor) ->
                new EmoteAnimation(0.1F, true, accessor, Armatures.BIPED)
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK, AnimationEvent.Side.CLIENT))
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS, AnimationEvent.Side.CLIENT))
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
        );
        DOGEZA = builder.nextAccessor("biped/emote/dogeza", (accessor) ->
                new EmoteAnimation(0.1F, true, accessor, Armatures.BIPED)
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_BEGIN_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.SET_TOOLS_BACK, AnimationEvent.Side.CLIENT))
                        .addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, AnimationEvent.SimpleEvent.create(Animations.ReusableSources.REVERT_TO_HANDS, AnimationEvent.Side.CLIENT))
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
        );

        JIAN_GUARD = builder.nextAccessor("biped/skill/jian/jian_guard", (accessor) -> new StaticAnimation(0.15F, true, accessor, Armatures.BIPED));
        DUAL_JIAN_GUARD = builder.nextAccessor("biped/skill/jian/jian_dual_guard", (accessor) -> new StaticAnimation(0.15F, true, accessor, Armatures.BIPED));
        JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/jian/jian_guard_hit", (accessor) -> new GuardAnimation(0.03F, accessor, Armatures.BIPED));
        JIAN_DUAL_GUARD_HIT = builder.nextAccessor("biped/skill/jian/jian_dual_guard_hit", (accessor) -> new GuardAnimation(0.03F, accessor, Armatures.BIPED));
        JIAN_GUARD_BREAK = builder.nextAccessor("biped/skill/jian/jian_guard_break", (accessor) -> new LongHitAnimation(0.05F, accessor, Armatures.BIPED));
        DUAL_JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/jian/jian_dual_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
        SCYTHE_GUARD = builder.nextAccessor("biped/skill/scythe/scythe_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED)
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
        SCYTHE_GUARD_HIT = builder.nextAccessor("biped/skill/scythe/scythe_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));
        JIAN_GUARD_PARRY_1 = builder.nextAccessor("biped/skill/jian/jian_guard_hit_active_1", (accessor) -> new GuardAnimation(0.02F, accessor, Armatures.BIPED));
        JIAN_GUARD_PARRY_2 = builder.nextAccessor("biped/skill/jian/jian_guard_hit_active_2", (accessor) -> new GuardAnimation(0.02F, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true));
        JIAN_DUAL_GUARD_PARRY_1 = builder.nextAccessor("biped/skill/jian/jian_dual_guard_hit_active_1", (accessor) -> new GuardAnimation(0.02F, accessor, Armatures.BIPED));
        JIAN_DUAL_GUARD_PARRY_2 = builder.nextAccessor("biped/skill/jian/jian_dual_guard_hit_active_2", (accessor) -> new GuardAnimation(0.02F, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true));

        SCYTHE_GUARD_PARRY_1 = builder.nextAccessor("biped/skill/scythe/scythe_guard_parry_1", (accessor) -> new GuardAnimation(0.02F, accessor, Armatures.BIPED));
        SCYTHE_GUARD_PARRY_2 = builder.nextAccessor("biped/skill/scythe/scythe_guard_parry_2", (accessor) -> new GuardAnimation(0.02F, accessor, Armatures.BIPED));

        //change times once they work
        JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian/jian_auto_1", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.2F, 0.3F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian/jian_auto_2", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.2F, 0.25F, 0.28F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.29F, 0.29F, 0.3F, 0.4F, 0.45F, 0.49F, Armatures.BIPED.get().toolR, null))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian/jian_auto_3", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.05F, 0.09F, 0.15F, 0.2F, 0.21F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.22F, 0.25F, 0.3F, 0.4F, 0.5F, 0.51F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        JIAN_AUTO_4 = builder.nextAccessor("biped/combat/jian/jian_auto_4", (accessor) ->
                new AttackAnimation(0.12F, 0.2F, 0.25F, 0.4F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(3F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));


        DUAL_JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian/jian_dual_auto_1", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.12F, 0.16F, 0.23F, 0.24F, 0.241F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.242F, 0.12F, 0.24F, 0.35F, 0.36F, 0.37F, Armatures.BIPED.get().toolR, null))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F));

        DUAL_JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian/jian_dual_auto_2", (accessor) ->
                new AttackAnimation(0.12F,accessor, Armatures.BIPED,
                        new AttackAnimation.Phase( 0.0F, 0.12F,0.19F, 0.26F, 0.27F, 0.28F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.29F, 0.12F, 0.22F, 0.37F, 0.39F, 0.4F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F));

        DUAL_JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian/jian_dual_auto_3", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.12F, 0.15F, 0.23F, 0.25F, 0.26F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.27F, 0.12F, 0.25F, 0.38F, 0.39F, 0.4F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F));
        DUAL_JIAN_AUTO_4 = builder.nextAccessor("biped/combat/jian/jian_dual_auto_4", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.08F, 0.12F, 0.22F, 0.26F, 0.27F, InteractionHand.MAIN_HAND,
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null), AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0F));


        JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian/jian_airslash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.12F, 0.2F, 0.3F, 0.42F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.4F))
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.5F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT)
                        ));

        JIAN_DASH = builder.nextAccessor("biped/combat/jian/jian_dash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.12F, 0.23F, 0.32F, 0.45F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.4F))
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.15F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT)
                        ));

        DUAL_JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian/jian_dual_airslash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.05F, 0.08F, 0.21F, 0.22F, 0.23F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.232F, 0.12F, 0.21F, 0.3F, 0.31F, 0.45F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.1F, 0.50F)));

        DUAL_JIAN_DASH = builder.nextAccessor("biped/combat/jian/jian_dual_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.11F, 0.15F, 0.16F, 0.161F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH),
                        new AttackAnimation.Phase(0.162F, 0.163F, 0.164F, 0.18F, 0.19F, 0.191F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH),
                        new AttackAnimation.Phase(0.192F, 0.193F, 0.194F, 0.21F, 0.22F, 0.221F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH),
                        new AttackAnimation.Phase(0.222F, 0.223F, 0.224F, 0.24F, 0.25F, 0.251F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH),
                        new AttackAnimation.Phase(0.252F, 0.253F, 0.254F, 0.28F, 0.30F, 0.301F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH),
                        new AttackAnimation.Phase(0.302F, 0.303F, 0.304F, 0.34F, 0.36F, 0.361F, InteractionHand.MAIN_HAND, Armatures.BIPED.get().torso, AscendedColliderPreset.DASH))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.5F))
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.05F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.07F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT)
                        ));

        SCYTHE_DASH = builder.nextAccessor("biped/combat/scythe/scythe_dash", (accessor) ->
                new DashAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.48F, 0.49F, 0.5F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false)
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
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        SCYTHE_AIRSLASH = builder.nextAccessor("biped/combat/scythe/scythe_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.2F, 0.45F, 0.5F, 0.51F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.51F, 0.2F, 0.71F, 0.8F, 0.9F, 0.91F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.0F)));

        SCYTHE_AUTO_1 = builder.nextAccessor("biped/combat/scythe/scythe_auto_1", (accessor) ->
                new AttackAnimation(0.12F, 0.16F, 0.25F, 0.35F, 0.45F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_2 = builder.nextAccessor("biped/combat/scythe/scythe_auto_2", (accessor) ->
                new AttackAnimation(0.12F,accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.05F, 0.1F, 0.16F, 0.17F, 0.171F, Armatures.BIPED.get().toolR, AscendedColliderPreset.SCYTHE_BOTTOM),
                        new AttackAnimation.Phase(0.172F, 0.19F, 0.29F, 0.36F, 0.45F, 0.451F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(25))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/scythe/scythe_auto_3", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.15F, 0.19F, 0.26F, 0.27F, 0.271F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.272F, 0.35F, 0.42F, 0.55F, 0.65F, 0.651F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        SCYTHE_AUTO_4 = builder.nextAccessor("biped/combat/scythe/scythe_auto_4", (accessor) ->
                new AttackAnimation(0.12F, 0.12F, 0.18F, 0.27F, 0.35F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));

        S_SCYTHE_DASH = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.0F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_SCYTHE_AIRSLASH = builder.nextAccessor("biped/combat/ss/sweeping_scythe_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.3F)));
        S_SCYTHE_AUTO = builder.nextAccessor("biped/combat/ss/sweeping_scythe_auto_1", (accessor) ->
                new AttackAnimation(0.12F, 0.0F, 0.1F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_SCYTHE_AUTO_2 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_auto_2", (accessor) ->
                new AttackAnimation(0.12F, 0.0F, 0.05F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_auto_3", (accessor) ->
                new AttackAnimation(0.12F, 0.0F, 0.05F, 0.3F, 0.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
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
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.05F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.13F, 0.13F, 0.15F, 0.25F, 0.29F, 0.3F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        S_DUAL_SCYTHE_AUTO_3 = builder.nextAccessor("biped/combat/ss/sweeping_scythe_dual_auto_3",(accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.05F, 0.1F, 0.12F, 0.13F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.13F, 0.13F, 0.15F, 0.25F, 0.29F, 0.3F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));

        CELESTIAL_DIVE = builder.nextAccessor("biped/skill/jian/celestial_dive", (accessor) ->
                new AttackAnimation(0.12F, 0.2F, 0.25F, 0.4F, 0.42F, AscendedColliderPreset.KICK, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get())
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.AFFECT_SPEED, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.0F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.REACH, 0.0F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.ATTACK_TARGET_LOCATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, null)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addEvents(
                                AnimationEvent.InPeriodEvent.create(0.0F, 0.45F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.TURNING_LOCKED, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true)
        );
        CELESTIAL_DIVE_MISS = builder.nextAccessor("biped/skill/jian/celestial_dive_miss", (accessor) ->
                new AttackAnimation(0.0F, 0.0F, 0.0F, 0.0F, 0.25F, AscendedColliderPreset.DASH, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, SoundEvents.EMPTY)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.6F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.AFFECT_SPEED, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.0F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_START_KEYFRAME_INDEX, 1)
                        .addState(EntityState.SKILL_EXECUTABLE, false)
                        .addState(EntityState.TURNING_LOCKED, false));

        CELESTIAL_PUNISHMENT = builder.nextAccessor("biped/skill/jian/celestial_punishment", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.25F, 0.37F, 0.38F, 0.381F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.39F, 0.42F, 0.55F, 0.7F, 0.71F, 0.711F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.712F, 0.72F, 0.76F, 0.89F, 0.9F, 0.91F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.1F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.3F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_LOCATION_ROTATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.1F, 1.0F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.06F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.08F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.24F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.27F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.36F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.39F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.54F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.56F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InPeriodEvent.create(0.0F, 1F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.MOVEMENT_LOCKED, true)
        );
        CELESTIAL_ONSLAUGHT = builder.nextAccessor("biped/skill/jian/celestial_onslaught", (accessor) ->
                new AttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.16F, 0.26F, 0.315F, 0.32F, 0.321F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.322F, 0.33F, 0.36F, 0.45F, 0.46F, 0.461F, Armatures.BIPED.get().toolL, null),
                        new AttackAnimation.Phase(0.462F, 0.8F, 0.9F, 1.1F, 1.2F, 1.21F,InteractionHand.MAIN_HAND, AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null)),
                        new AttackAnimation.Phase(1.211F, 1.215F, 1.22F, 1.28F, 1.29F, 1.291F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(1.292F, 1.293F, 1.295F, 1.39F, 1.4F, 1.41F, Armatures.BIPED.get().toolL, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.1F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.3F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_TARGET_LOCATION_ROTATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.1F, 1.4F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.06F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.08F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.24F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.27F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.56F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.59F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.94F, ReusableEvents.CHERRY_PARTICLES, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InTimeEvent.create(0.96F, ReusableEvents.ENDER_IMAGE, AnimationEvent.Side.CLIENT),
                                AnimationEvent.InPeriodEvent.create(0.0F, 1.5F, (entitypatch, self, params) -> {
                                    ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                                    if (entitypatch.getOriginal() instanceof Player) {
                                        Player player = (Player) entitypatch.getOriginal();
                                        player.yCloak = 0.0;
                                        player.yCloakO = 0.0;
                                    }
                                }, AnimationEvent.Side.BOTH)
                        )
                        .addState(EntityState.MOVEMENT_LOCKED, true)
        );

        REAPING_GRASP_1 = builder.nextAccessor("biped/skill/scythe/reaping_grasp_1", (accessor) ->
                new AttackAnimation(0.05F, 0.08F, 0.12F, 0.23F, 0.25F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.7F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                        .addProperty(AnimationProperty.ActionAnimationProperty.RESET_PLAYER_COMBO_COUNTER, false)
                        .newTimePair(0.0F, 0.30F)
                        .addStateRemoveOld(EntityState.COMBO_ATTACKS_DOABLE, false));

        REAPING_GRASP_2 = builder.nextAccessor("biped/skill/scythe/reaping_grasp_2", (accessor) ->
                new AttackAnimation(0.05F, 0.15F, 0.2F, 0.28F, 0.30F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.7F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                        .addProperty(AnimationProperty.ActionAnimationProperty.RESET_PLAYER_COMBO_COUNTER, false)
                        .newTimePair(0.0F, 0.30F)
                        .addStateRemoveOld(EntityState.COMBO_ATTACKS_DOABLE, false));
        REAPING_GRASP_3 = builder.nextAccessor("biped/skill/scythe/reaping_grasp_3", (accessor) ->
                new AttackAnimation(0.05F, 0.08F, 0.12F, 0.23F, 0.24F, null, Armatures.BIPED.get().toolR, accessor,Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.7F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                        .addProperty(AnimationProperty.ActionAnimationProperty.RESET_PLAYER_COMBO_COUNTER, false)
                        .newTimePair(0.0F, 0.30F)
                        .addStateRemoveOld(EntityState.COMBO_ATTACKS_DOABLE, false));
        REAPING_GRASP_4 = builder.nextAccessor("biped/skill/scythe/reaping_grasp_4", (accessor) ->
                new AttackAnimation(0.05F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.02F, 0.04F, 0.1F, 0.12F, 0.121F, Armatures.BIPED.get().toolR, null),
                        new AttackAnimation.Phase(0.122F, 0.13F, 0.16F, 0.27F, 0.29F, 0.291F, Armatures.BIPED.get().toolR, null))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.7F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                        .addProperty(AnimationProperty.ActionAnimationProperty.RESET_PLAYER_COMBO_COUNTER, false)
                        .newTimePair(0.0F, 0.30F)
                        .addStateRemoveOld(EntityState.COMBO_ATTACKS_DOABLE, false));



        BIPED_FLUTE_USE = builder.nextAccessor("biped/living/compat/flute", (accessor) ->
                new MirrorAnimation(0.15F, true, accessor, "biped/living/compat/flute_mainhand", "biped/living/compat/flute_offhand", Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (self, entitypatch, speed, prevElapsedTime, elapsedTime) -> {
                            if (self.isLinkAnimation()) {
                                return speed;
                            }

                            return 0.0F;
                        })
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, (self, pose, entitypatch, elapsedTime, partialTicks) -> {
                            if (entitypatch.isFirstPerson()) {
                                pose.disableAllJoints();
                            } else if (!(self.isLinkAnimation())) {
                                LivingMotion livingMotion = entitypatch.getCurrentLivingMotion();
                                Pose rawPose;

                                if (livingMotion == LivingMotions.SWIM || livingMotion == LivingMotions.FLY || livingMotion == LivingMotions.CREATIVE_FLY) {
                                    rawPose = self.getRawPose(3.3333F);
                                } else {
                                    float xRot = Mth.clamp((entitypatch.getOriginal().getXRot() + 90.0F) * 0.0166666666666667F, 0.0F, 3.0F);
                                    rawPose = self.getRawPose(xRot);
                                    float f = 90.0F;
                                    float ratio = (f - Math.abs(entitypatch.getOriginal().getXRot())) / f;
                                    float yawOffset = entitypatch.getOriginal().getVehicle() != null ? entitypatch.getOriginal().getYHeadRot() : entitypatch.getOriginal().yBodyRot;
                                    rawPose.get("Chest").frontResult(
                                            JointTransform.rotation(QuaternionUtils.YP.rotationDegrees(Mth.wrapDegrees(entitypatch.getOriginal().getYHeadRot() - yawOffset) * ratio))
                                            , OpenMatrix4f::mulAsOriginInverse
                                    );
                                }

                                pose.load(rawPose, Pose.LoadOperation.OVERWRITE);
                            }
                        })
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
        );

        BIPED_HOLD_FLUTE_TWOHAND = builder.nextAccessor("biped/living/compat/hold_flute_twohand", (accessor) ->
                new StaticAnimation(true, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.MAP_ARMS_CORRECTION)
        );
        BIPED_HOLD_FLUTE_OFFHAND = builder.nextAccessor("biped/living/compat/hold_flute_offhand", (accessor) ->
                new StaticAnimation(true, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.MAP_ARMS_CORRECTION)
        );
        BIPED_HOLD_FLUTE_MAINHAND = builder.nextAccessor("biped/living/compat/hold_flute_mainhand", (accessor) ->
                new StaticAnimation(true, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.MAP_ARMS_CORRECTION)
        );
        BIPED_HOLD_FLUTE_TWOHAND_MOVE = builder.nextAccessor("biped/living/compat/hold_flute_twohand_move", (accessor) ->
                new StaticAnimation(true, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.MAP_ARMS_CORRECTION)
        );
        BIPED_HOLD_FLUTE_OFFHAND_MOVE = builder.nextAccessor("biped/living/compat/hold_flute_offhand_move", (accessor) ->
                new StaticAnimation(true, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.MAP_ARMS_CORRECTION)
        );
        BIPED_HOLD_FLUTE_MAINHAND_MOVE = builder.nextAccessor("biped/living/compat/hold_flute_mainhand_move", (accessor) ->
                new StaticAnimation(true, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.MAP_ARMS_CORRECTION)
        );



        FLUTE_IDLE = builder.nextAccessor("biped/living/compat/flute_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        FLUTE_AUTO = builder.nextAccessor("biped/combat/compat/flute_auto", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.2F, 0.4F, 0.5F, AscendedColliderPreset.KICK, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));
        FLUTE_AUTO_2 = builder.nextAccessor("biped/combat/compat/flute_auto_2", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.3F, 0.5F, 0.6F, AscendedColliderPreset.KICK, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 0.5F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));
        FLUTE_DASH = builder.nextAccessor("biped/combat/compat/flute_dash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.2F, 0.4F, 0.6F, 0.7F, AscendedColliderPreset.KICK, Armatures.BIPED.get().legL, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));
        FLUTE_AIRSLASH = builder.nextAccessor("biped/combat/compat/flute_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, 0.1F, 0.3F, 0.4F, AscendedColliderPreset.KICK, Armatures.BIPED.get().legR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));

        PRAYER_IDLE = builder.nextAccessor("biped/living/compat/prayer_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        PRAYER_AUTO = builder.nextAccessor("biped/combat/compat/prayer_auto", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.15F, 0.25F, 0.3F, AscendedColliderPreset.KICK, Armatures.BIPED.get().handL, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));
        PRAYER_AUTO_2 = builder.nextAccessor("biped/combat/compat/prayer_auto_2", (accessor) ->
                new AttackAnimation(0.12F, 0.1F, 0.25F, 0.4F, 0.45F, AscendedColliderPreset.KICK, Armatures.BIPED.get().handL, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));
        PRAYER_DASH = builder.nextAccessor("biped/combat/compat/prayer_dash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.1F, 0.2F, 0.5F, 0.6F, AscendedColliderPreset.KICK, Armatures.BIPED.get().handL, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));
        PRAYER_AIRSLASH = builder.nextAccessor("biped/combat/compat/prayer_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, 0.2F, 0.5F, 0.6F, AscendedColliderPreset.KICK, Armatures.BIPED.get().handL, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(5))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.2F));



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
            entity.level().addParticle(EpicFightParticles.WHITE_AFTERIMAGE.get(), entity.getX(), entity.getY(), entity.getZ(), Double.longBitsToDouble(entity.getId()), 0, 0);
            entity.playSound(SoundEvents.FOX_TELEPORT, 1F, 1.2F);
        };

        //cherry
        public static final AnimationEvent.E0 CHERRY_PARTICLES = (entitypatch, self, params) -> {
            Entity entity = entitypatch.getOriginal();
            RandomSource random = entitypatch.getOriginal().getRandom();
            entity.playSound(SoundEvents.AMETHYST_BLOCK_CHIME, 1F, 1.2F);
            scheduler.schedule(() -> {
                spawnParticlesCherry(entity, random);
            }, 48, TimeUnit.MILLISECONDS);
            spawnParticlesCherryDelayed(entity, random);
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

        public static void spawnParticlesCherry(Entity entity, RandomSource random) {
            ClientLevel clientLevel = Minecraft.getInstance().level;
            if (clientLevel != null) {
                double horizontalRadius = 1.2;
                for (int i = 0; i < ENDER_PARTICLE_COUNT; i++) {
                    double xOffset = (random.nextDouble() - 0.4) * horizontalRadius;
                    double yOffset = (random.nextDouble() - random.nextDouble()) * 1.4D;
                    double zOffset = (random.nextDouble() - 0.4) * horizontalRadius;

                    clientLevel.addParticle(ParticleTypes.CHERRY_LEAVES,
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
        public static void spawnParticlesCherryDelayed(Entity entity, RandomSource random) {
            scheduler.schedule(() -> spawnParticlesCherry(entity, random), 144, TimeUnit.MILLISECONDS);
        }
        public static void spawnCherryParticlesFollowingPlayer_Tiny(Entity entity) {
            if (!activeParticles.containsKey(entity)) {
                activeParticles.put(entity, FOLLOW_DURATION_TINY);
            }
        }

    }
}