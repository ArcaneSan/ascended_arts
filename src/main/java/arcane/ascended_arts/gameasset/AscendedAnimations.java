package arcane.ascended_arts.gameasset;

import arcane.ascended_arts.Ascended_arts;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.checkerframework.checker.units.qual.A;
import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.damagesource.EpicFightDamageType;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Set;

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


    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> Jian_Auto_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> Jian_Auto_2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> Jian_Auto_3;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> Jian_Auto_4;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> Jian_Airslash;

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {
        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_Jian = builder.nextAccessor("biped/living/jian_idle", (accessor) -> new StaticAnimation(true, accessor,Armatures.BIPED));

        //change times once they work
        Jian_Auto_1 = builder.nextAccessor("biped/combat/jian_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.5F, 0.3F, 0.5F, 0.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        Jian_Auto_2 = builder.nextAccessor("biped/combat/jian_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.3F, 0.4F, 0.6F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE),
                        new AttackAnimation.Phase(0.5F, 0.4F, 0.3F, 0.75F, 0.3F, 1.1F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
        Jian_Auto_3 = builder.nextAccessor("biped/combat/jian_auto_3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.2F, 0.4F, 0.3F, 0.3F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.1F, 0.3F, 0.4F, 0.6F, 0.3F, 0.5F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F));
        Jian_Auto_4 = builder.nextAccessor("biped/combat/jian_auto_4", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.5F, 0.45F, 0.8F, 0.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, true));

        Jian_Airslash = builder.nextAccessor("biped/combat/jian_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.2F, 0.1F, 0.4F, 0.3F, 0.3F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT),
                        new AttackAnimation.Phase(0.3F, 0.5F, 0.4F, 0.9F, 0.3F, 0.3F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG),
                        new AttackAnimation.Phase(0.5F, 0.8F, 0.7F, 1.2F, 0.5F, 0.5F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.FINISHER)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.3F, 2.3F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, false));

    }

}
