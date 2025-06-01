package arcane.ascended_arts.gameasset;

import arcane.ascended_arts.Ascended_arts;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.DirectStaticAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
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
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> FLOATING_AUTO_1;
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_SABER;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SABER_AUTO_2;

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {
        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_SABER = builder.nextAccessor("biped/living/saber_idle", (accessor) -> new StaticAnimation(true, accessor,Armatures.BIPED));

        //change times once they work
        FLOATING_AUTO_1 = builder.nextAccessor("biped/combat/saber_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.5F, 0.3F, 0.5F, 0.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        SABER_AUTO_2 = builder.nextAccessor("biped/combat/saber_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0F, 0.0F, 0.1F, 0.3F, 0.4F, 0.6F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE),
                        new AttackAnimation.Phase(0.5F, 0.4F, 0.3F, 0.75F, 0.3F, 1.1F, Armatures.BIPED.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F)))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F));
    }

}
