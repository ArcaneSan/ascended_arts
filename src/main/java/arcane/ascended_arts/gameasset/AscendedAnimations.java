package arcane.ascended_arts.gameasset;

import arcane.ascended_arts.Ascended_arts;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.DirectStaticAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

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
    public static AnimationManager.AnimationAccessor<StaticAnimation> BIPED_HOLD_FLOATING_SABER;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> FLOATING_AUTO_2;

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(Ascended_arts.MOD_ID, AscendedAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder) {
        //Every animation defined with his own hitbox timers and Properties
        BIPED_HOLD_FLOATING_SABER = builder.nextAccessor("biped/living/idle_floating", (accessor) -> new StaticAnimation(true, accessor,Armatures.BIPED));

        //change times once they work
        FLOATING_AUTO_1 = builder.nextAccessor("biped/combat/floating_auto_1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.3F, 0.5F, 0.72F, 0.52F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
        FLOATING_AUTO_2 = builder.nextAccessor("biped/combat/floating_auto_2", (accessor) ->
                new BasicAttackAnimation(0.12f, 0.3f, 0.5f, 0.72f, 0.52F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.8F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
    }

}
