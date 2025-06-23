package net.arcane.ascended_arts.skill.weaponinnate;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.effect.EpicFightMobEffects;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CelestialOnslaughtSkill extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("1d993f97-eb4c-4f38-bf31-3f48df103582");
    public final AssetAccessor<? extends AttackAnimation> first;
    public final AssetAccessor<? extends AttackAnimation> second;
    public final AssetAccessor<? extends AttackAnimation> third;
    public final AssetAccessor<? extends AttackAnimation> fourth;

    public CelestialOnslaughtSkill (SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
        this.first = AscendedAnimations.CELESTIAL_ONSLAUGHT_FIRST;
        this.second = AscendedAnimations.CELESTIAL_ONSLAUGHT_SECOND;
        this.third = AscendedAnimations.CELESTIAL_ONSLAUGHT_THIRD;
        this.fourth = AscendedAnimations.CELESTIAL_ONSLAUGHT_FOURTH;
    }

    @Override
    public void onInitiate(SkillContainer container) {
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID, (event) -> {
            if (AscendedAnimations.CELESTIAL_ONSLAUGHT_FIRST.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrenltyHurtEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.second);
                    event.getPlayerPatch().getCurrenltyHurtEntities().clear();

                }
            }
            if (AscendedAnimations.CELESTIAL_ONSLAUGHT_SECOND.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrenltyHurtEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.third);
                    event.getPlayerPatch().getCurrenltyHurtEntities().clear();

                }
            }
            if (AscendedAnimations.CELESTIAL_ONSLAUGHT_THIRD.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrenltyHurtEntities();


                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fourth);
                    event.getPlayerPatch().getCurrenltyHurtEntities().clear();

            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID);
    }

    @Override
    public boolean checkExecuteCondition(SkillContainer container) {
        Entity target = container.getExecutor().getTarget();
        if (target == null || !target.isAlive()) {
            return false;
        }
        Vec3 targetPos = target.position();
        Vec3 playerPos = container.getExecutor().getOriginal().position();
        Vec3 predictedTargetPos = targetPos.add(target.getDeltaMovement());

        double distance = playerPos.distanceTo(predictedTargetPos);
        double minDistance = 1.5;
        double maxDistance = 8.0;

        return distance >= minDistance && distance <= maxDistance;
    }

    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args) {
        container.getExecutor().playAnimationSynchronized(this.first, 0);
        LivingEntity target = (LivingEntity) container.getExecutor().getTarget();
        ((ServerPlayer)container.getExecutor().getOriginal()).addEffect(new MobEffectInstance((MobEffect) EpicFightMobEffects.STUN_IMMUNITY.get(), 38, 0, true, false, false));
        if (target != null && target.isAlive()) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 36, 50));
        }
        super.executeOnServer(container, args);
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(0), "Pin");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(1), "Bash");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(2), "Shred");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(3), "Crush");
        return list;
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.first.get().phases[0].addProperties(this.properties.get(0).entrySet());
        this.second.get().phases[0].addProperties(this.properties.get(1).entrySet());
        this.third.get().phases[0].addProperties(this.properties.get(2).entrySet());
        this.fourth.get().phases[0].addProperties(this.properties.get(3).entrySet());
        return this;
    }



}