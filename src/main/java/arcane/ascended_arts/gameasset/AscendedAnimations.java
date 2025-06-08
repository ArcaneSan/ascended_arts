package arcane.ascended_arts.gameasset;

import arcane.ascended_arts.Ascended_arts;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
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
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_Jian;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_WALK_JIAN;
    public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_JIAN;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_SCYTHE;

    public static AnimationManager.AnimationAccessor<StaticAnimation> JIAN_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JIAN_GUARD_HIT;


    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AUTO_4;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JIAN_AIRSLASH;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> JIAN_DASH;

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {
        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_Jian = builder.nextAccessor("biped/living/jian_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        BIPED_WALK_JIAN = builder.nextAccessor("biped/living/jian_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_RUN_JIAN = builder.nextAccessor("biped/living/jian_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BIPED_HOLD_SCYTHE = builder.nextAccessor("biped/living/scythe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));

        JIAN_GUARD = builder.nextAccessor("biped/skill/jian_guard", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        JIAN_GUARD_HIT = builder.nextAccessor("biped/skill/jian_guard_hit", (accessor) -> new GuardAnimation(0, accessor, Armatures.BIPED));

        //change times once they work
        JIAN_AUTO_1 = builder.nextAccessor("biped/combat/jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.1F, 0.2F, 0.5F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        JIAN_AUTO_2 = builder.nextAccessor("biped/combat/jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.1F, 0.1F, 0.3F, 0.4F, 0.6F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.2F, 0.1F, 0.3F, 0.8F, 0.9F, 1.1F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        JIAN_AUTO_3 = builder.nextAccessor("biped/combat/jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.3F, 0.4F, 0.3F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.1F, 0.3F, 0.4F, 0.8F, 0.9F, 0.5F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        JIAN_AUTO_4 = builder.nextAccessor("biped/combat/jian_auto_4", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.1F, 0.2F, 0.6F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true));

        //JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian_airslash", (accessor) ->
                //new AirSlashAnimation(0.12F, accessor, Armatures.BIPED,
                  //      new AttackAnimation.Phase(0.0F, 0.2F, 0.1F, 0.4F, 0.3F, 0.3F, Armatures.BIPED.get().toolR, null)
                   //             .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                   //     new AttackAnimation.Phase(0.3F, 0.5F, 0.4F, 0.9F, 0.3F, 0.3F, Armatures.BIPED.get().toolR, null)
                  //              .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG),
                   //     new AttackAnimation.Phase(0.5F, 0.8F, 0.7F, 1.2F, 0.5F, 0.5F, Armatures.BIPED.get().toolR, null)
                   //             .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.FINISHER)))
                   //     .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 0.22F))
                   //     .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, true)
                   //     .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                   //     .addEvents(
                   //             AnimationEvent.InPeriodEvent.create(0.0F, 0.32F, (entitypatch, self, params) -> {
                    //                ((LivingEntity) entitypatch.getOriginal()).resetFallDistance();
                    //                if (entitypatch.getOriginal() instanceof Player) {
                    //                    Player player = (Player) entitypatch.getOriginal();
                    //                    player.yCloak = 0.0;
                    //                    player.yCloakO = 0.0;
                     //               }
                    //            }, AnimationEvent.Side.BOTH)
                     //   ));
        JIAN_AIRSLASH = builder.nextAccessor("biped/combat/jian_airslash", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0F, 0.2F, 0.5F, 0.6F, 0.8F, Armatures.BIPED.get().toolR, null)
                                     .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                             new AttackAnimation.Phase(0.3F, 0F, 0.5F, 1F, 1.2F, 1.2F, Armatures.BIPED.get().toolR, null)
                                      .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG))

                             .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.15F, 1.5F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.DEST_LOCATION_PROVIDER, MoveCoordFunctions.SYNCHED_TARGET_ENTITY_LOCATION_VARIABLE)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_UPDATE_TIME, TimePairList.create(0.0F, 0.25F))
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, null)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(AnimationProperty.ActionAnimationProperty.COORD_GET, MoveCoordFunctions.WORLD_COORD)

                             .addEvents(
                                     AnimationEvent.InPeriodEvent.create(0.0F, 1.2F, (entitypatch, self, params) -> {
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
                        new AttackAnimation.Phase(0.3F, 0.5F, 0.4F, 0.9F, 1F, 1F, Armatures.BIPED.get().toolR, null))
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


    }

}
