package net.arcane.ascended_arts.skill.weaponinnate;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.SynchedAnimationVariableKeys;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.client.input.InputManager;
import yesman.epicfight.api.client.input.PlayerInputState;
import yesman.epicfight.client.events.engine.ControlEngine;
import yesman.epicfight.client.input.EpicFightKeyMappings;
import yesman.epicfight.network.server.SPSkillExecutionFeedback;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.modules.ChargeableSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.List;
import java.util.UUID;

public class MountainSplitterSkill extends WeaponInnateSkill implements ChargeableSkill {
    private static final UUID EVENT_UUID = UUID.fromString("f69e3e40-f046-42a5-b22c-519287cff3b9");

    private AnimationManager.AnimationAccessor<? extends StaticAnimation> chargingAnimation;
    private AnimationManager.AnimationAccessor<? extends AttackAnimation> attackAnimation;

    public MountainSplitterSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);

        this.chargingAnimation = AscendedAnimations.MOUNTAIN_SPLITTER_CHARGING;
        this.attackAnimation = AscendedAnimations.MOUNTAIN_SPLITTER;
    }

    @Override
    public void onInitiate(SkillContainer container) {
        PlayerEventListener listener = container.getExecutor().getEventListener();

        listener.addEventListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID, (event) -> {
            if (event.getPlayerPatch().isHoldingSkill(this)) {
                LocalPlayer clientPlayer = event.getPlayerPatch().getOriginal();
                clientPlayer.setSprinting(false);
                ControlEngine.setSprintingKeyStateNotDown();

                final PlayerInputState current = event.getInputState();
                final PlayerInputState updated = current
                        .withForwardImpulse(current.forwardImpulse() * (1.0F - 0.9F * event.getPlayerPatch().getSkillChargingTicks() / 45.0F));
                InputManager.setInputState(updated);
            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);

        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID);
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        AttackAnimation anim = this.attackAnimation.get();

        for (AttackAnimation.Phase phase : anim.phases) {
            phase.addProperties(this.properties.get(0).entrySet());
        }

        return this;
    }

    @Override
    public int getAllowedMaxChargingTicks() {
        return 90;
    }

    @Override
    public int getMaxChargingTicks() {
        return 45;
    }

    @Override
    public int getMinChargingTicks() {
        return 12;
    }

    @Override
    public void startHolding(SkillContainer container) {
        AssetAccessor<? extends StaticAnimation> currentPlaying = container.getExecutor().getAnimator().getPlayerFor(null).getRealAnimation();

        if (currentPlaying.get().isMainFrameAnimation()) {
            container.getExecutor().stopPlaying(currentPlaying);
        }

        container.getExecutor().playAnimationSynchronized(this.chargingAnimation, 0.0F);
    }

    @Override
    public void resetHolding(SkillContainer container) {
        if (container.getExecutor().isLogicalClient()) {
            container.getExecutor().getAnimator().stopPlaying(this.chargingAnimation);
        } else {
            container.getExecutor().stopPlaying(this.chargingAnimation);
        }
    }

    @Override
    public void onStopHolding(SkillContainer container, SPSkillExecutionFeedback feedback) {
        container.getExecutor().getAnimator().getVariables().put(SynchedAnimationVariableKeys.CHARGING_TICKS.get(), this.attackAnimation, container.getExecutor().getAccumulatedChargeAmount());
        container.getExecutor().playAnimationSynchronized(this.attackAnimation, 0.0F);
        this.cancelOnServer(container, null);
    }

    @Override
    public void holdTick(SkillContainer container) {
        ChargeableSkill.super.holdTick(container);
    }

    @Override
    public KeyMapping getKeyMapping() {
        return EpicFightKeyMappings.WEAPON_INNATE_SKILL;
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(0), "Each Strike:");

        return list;
    }
}