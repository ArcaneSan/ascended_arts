package net.arcane.ascended_arts.skill.martial_sect;

import net.arcane.ascended_arts.skill.AscendedSkillCategories;
import net.arcane.ascended_arts.skill.ascension_path.QiBuildingSkill;
import net.arcane.ascended_arts.world.item.AscendedCreativeTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static net.arcane.ascended_arts.api.animation.JointTrack.getJointWithTranslation;

public class PlumBlossomSect extends MartialSectSkill{

    private static final UUID EVENT_UUID = UUID.fromString("60e72fb0-649a-443f-8bc7-b90bae3f12d7");

    public PlumBlossomSect(Builder builder) {
        super(builder);
    }

    public static PlumBlossomSect.Builder createPlumBlossomBuilder() {
        return (new Builder())
                .setCategory(AscendedSkillCategories.MARTIAL_SECT)
/*
                .setCreativeTab(AscendedCreativeTab.Ascended_Arts_Tab.get())
*/
                .setResource(Resource.NONE);
    }

    public static class Builder extends SkillBuilder<PlumBlossomSect> {

    }


    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);


        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID, (event) -> {
            LivingEntity player = event.getPlayerPatch().getOriginal();
            RandomSource random = RandomSource.create();
            if (player == null) return;
            if (!player.isInWater() && !player.isCrouching() && !player.isFallFlying() && player.isSprinting()) {
                int numParticles = 3;
                for (int i = 0; i < numParticles; i++) {
                    float L = -0.1F;
                    float R = 0.1F;
                    double xOffset = (random.nextDouble() - 0.3) * 0.3;
                    double yOffset = (random.nextDouble() - random.nextDouble()) * 0.3D;
                    double zOffset = (random.nextDouble() - 0.3) * 0.3;
                    Vec3 basePos = getJointWithTranslation(Minecraft.getInstance().player, player, new Vec3f(0F, -1F, -0.3F), Armatures.BIPED.get().rootJoint);
                    List<Vec3> positions = new ArrayList<>();
                    positions.add(getJointWithTranslation(Minecraft.getInstance().player, player, new Vec3f(0F, 0.2F, 0.2F), Armatures.BIPED.get().legL));
                    positions.add(getJointWithTranslation(Minecraft.getInstance().player, player, new Vec3f(0F, 0.2F, 0.2F), Armatures.BIPED.get().legR));
                    for (Vec3 pos : positions) {
                        if (pos != null) {
                            Vec3 ovalPos = pos.add(xOffset, yOffset, zOffset);
                            Particle particle = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.CHERRY_LEAVES, ovalPos.x, ovalPos.y, ovalPos.z, player.getDeltaMovement().x, 0.052F, player.getDeltaMovement().z);
                            if (particle != null) {
                                particle.setLifetime(6);
                            }
                        }
                    }
                }
                MobEffectInstance slowfallEffect = new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, true, false);
                player.addEffect(slowfallEffect);
            } else {
                if (player.hasEffect(MobEffects.SLOW_FALLING)) {
                    MobEffectInstance effect = player.getEffect(MobEffects.SLOW_FALLING);
                    if (effect != null && effect.getDuration() < 10) {
                        player.removeEffect(MobEffects.SLOW_FALLING);
                    }
                }
            }
        });
    }
}
