package net.arcane.ascended_arts.skill.weaponinnate;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;


import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReapingGraspSkill extends WeaponInnateSkill {
    public final AssetAccessor<? extends AttackAnimation> first;
    public final AssetAccessor<? extends AttackAnimation> second;
    public final AssetAccessor<? extends AttackAnimation> end1;
    public final AssetAccessor<? extends AttackAnimation> end2;


    public ReapingGraspSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
        this.first = AscendedAnimations.REAPING_GRASP_1;
        this.second = AscendedAnimations.REAPING_GRASP_2;
        this.end1 = AscendedAnimations.REAPING_GRASP_1_END;
        this.end2 = AscendedAnimations.REAPING_GRASP_2_END;

    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container, eventListener);
        List<LivingEntity> hurtEntities = container.getExecutor().getCurrentlyActuallyHitEntities();
        SkillContainer innateSkill = container.getExecutor().getSkill(SkillSlots.WEAPON_INNATE);
        eventListener.registerEvent(EpicFightEventHooks.Animation.END, (event) -> {
            if (this.first.equals(event.getAnimation())) {
                if (!hurtEntities.isEmpty() && hurtEntities.getFirst().isAlive()) {
                    container.getExecutor().reserveAnimation(this.second);
                    container.getExecutor().getServerAnimator().getPlayerFor(null).reset();
                }

                if (!container.getExecutor().isLogicalClient()) {
                    if (innateSkill != null && innateSkill.getSkill() != null && eventListener.getEntityPatch().isLastAttackSuccess() && hurtEntities.getFirst().isDeadOrDying()) {
                        innateSkill.getSkill().setConsumptionSynchronize(innateSkill, this.consumption * 0.75F);
                    }
                }
            }
            if (this.second.equals(event.getAnimation())){
                if (!hurtEntities.isEmpty() && hurtEntities.getFirst().isAlive()) {
                    container.getExecutor().reserveAnimation(this.end2);
                    container.getExecutor().getServerAnimator().getPlayerFor(null).reset();
                }
            }
            if (this.second.equals(event.getAnimation()) || this.end2.equals(event.getAnimation())) {
                container.getExecutor().getCurrentlyActuallyHitEntities().clear();}
        }, this);
    }



    @Override
    public void executeOnServer(SkillContainer container, CompoundTag arguments) {
        container.getExecutor().playAnimationSynchronized(this.first, 0);
        super.executeOnServer(container, arguments);
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(0), "Cut");
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
