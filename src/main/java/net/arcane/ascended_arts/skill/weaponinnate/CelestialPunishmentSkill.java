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


import java.util.Map;
import java.util.List;
import java.util.UUID;

public class CelestialPunishmentSkill extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("0a57fd2c-ef86-4bc3-84fe-01094f188ee7");
    public final AssetAccessor<? extends AttackAnimation> first;
    public final AssetAccessor<? extends AttackAnimation> second;
    public final AssetAccessor<? extends AttackAnimation> fail;


    public CelestialPunishmentSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
        this.first = AscendedAnimations.CELESTIAL_PUNISHMENT_FIRST;
        this.second = AscendedAnimations.CELESTIAL_PUNISHMENT_SECOND;
        this.fail = AscendedAnimations.CELESTIAL_PUNISHMENT_FAIL;

    }

    @Override
    public void onInitiate(SkillContainer container) {
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID, (event) -> {
            if (AscendedAnimations.CELESTIAL_PUNISHMENT_FIRST.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.second);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities();

                } else {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fail);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                }
            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID);
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
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(1), "Slash");


        return list;
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.first.get().phases[0].addProperties(this.properties.get(0).entrySet());
        this.second.get().phases[0].addProperties(this.properties.get(1).entrySet());

        return this;
    }



}
