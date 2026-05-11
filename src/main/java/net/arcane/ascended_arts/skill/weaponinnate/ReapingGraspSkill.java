package net.arcane.ascended_arts.skill.weaponinnate;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;


import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;


import java.util.List;
import java.util.Map;

public class ReapingGraspSkill extends WeaponInnateSkill {
private final Map<AnimationManager.AnimationAccessor<? extends StaticAnimation>, AnimationManager.AnimationAccessor<? extends AttackAnimation>> comboAnimation = Maps.newHashMap();

public ReapingGraspSkill(WeaponInnateSkill.Builder<?> builder) {
    super(builder);
}

@Override
public void executeOnServer (SkillContainer container, CompoundTag arguments) {
    AssetAccessor<? extends DynamicAnimation> animation = container.getExecutor().getAnimator().getPlayerFor(null).getAnimation();

    if (this.comboAnimation.containsKey(animation)) {
        container.getExecutor().playAnimationSynchronized(this.comboAnimation.get(animation), 0.0F);
        super.executeOnServer(container, arguments);
    }
}

@Override
public boolean checkExecuteCondition(SkillContainer container) {
    EntityState playerState = container.getExecutor().getEntityState();

    return this.comboAnimation.containsKey(container.getExecutor().getAnimator().getPlayerFor(null).getAnimation()) && playerState.canUseSkill() && playerState.inaction();
}

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = Lists.newArrayList();
        String traslatableText = this.getTranslationKey();

        list.add(Component.translatable(traslatableText).withStyle(ChatFormatting.WHITE).append(Component.literal(String.format("[%.0f]", this.consumption)).withStyle(ChatFormatting.AQUA)));
        list.add(Component.translatable(traslatableText + ".tooltip", this.maxStackSize).withStyle(ChatFormatting.DARK_GRAY));

        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(0), "Each Strike:");
        return list;
    }


    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
    this.comboAnimation.clear();
    this.comboAnimation.put(AscendedAnimations.SCYTHE_AUTO_1, AscendedAnimations.REAPING_GRASP_1);
    this.comboAnimation.put(AscendedAnimations.SCYTHE_AUTO_2, AscendedAnimations.REAPING_GRASP_2);
    this.comboAnimation.put(AscendedAnimations.SCYTHE_AUTO_3, AscendedAnimations.REAPING_GRASP_3);
    this.comboAnimation.put(AscendedAnimations.SCYTHE_AUTO_4, AscendedAnimations.REAPING_GRASP_4);

    this.comboAnimation.values().forEach((animation) -> {
        animation.get().phases[0].addProperties(this.properties.get(0).entrySet());
    });
    return this;
    }
}
