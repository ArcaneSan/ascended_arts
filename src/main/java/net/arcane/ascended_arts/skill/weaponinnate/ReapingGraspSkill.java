package net.arcane.ascended_arts.skill.weaponinnate;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReapingGraspSkill extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("2eb10151-66a4-47e7-8e4b-25cb5cdd5670");
    public final AssetAccessor<? extends AttackAnimation> first;
    public final AssetAccessor<? extends AttackAnimation> second;
    public final AssetAccessor<? extends AttackAnimation> third;
    public final AssetAccessor<? extends AttackAnimation> fourth;
    public final AssetAccessor<? extends AttackAnimation> last;

    public ReapingGraspSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
        this.first = AscendedAnimations.REAPING_GRASP_1;
        this.second = AscendedAnimations.REAPING_GRASP_2;
        this.third = AscendedAnimations.REAPING_GRASP_3;
        this.fourth = AscendedAnimations.REAPING_GRASP_4;
        this.last = AscendedAnimations.REAPING_GRASP_FINAL;
    }

    @Override
    public void onInitiate(SkillContainer container) {
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID, (event) ->{
            if (AscendedAnimations.REAPING_GRASP_1.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()){
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.second);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                }
            }
            if (AscendedAnimations.REAPING_GRASP_2.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()){
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.third);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                }
            }
            if (AscendedAnimations.REAPING_GRASP_3.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()){
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fourth);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                }
            }
            if (AscendedAnimations.REAPING_GRASP_4.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();

                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()){
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.last);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities();
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
        super.executeOnServer(container, args);
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(0), "Cut");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(1), "Slash");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(2), "Shred");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(3), "Stab");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(4), "Reap");
        return list;
    }


    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.first.get().phases[0].addProperties(this.properties.get(0).entrySet());
        this.second.get().phases[0].addProperties(this.properties.get(1).entrySet());
        this.third.get().phases[0].addProperties(this.properties.get(2).entrySet());
        this.fourth.get().phases[0].addProperties(this.properties.get(3).entrySet());
        this.last.get().phases[0].addProperties(this.properties.get(4).entrySet());
        return this;
    }
}
