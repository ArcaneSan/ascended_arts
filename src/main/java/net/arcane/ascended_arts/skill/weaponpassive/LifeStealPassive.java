package net.arcane.ascended_arts.skill.weaponpassive;

import net.minecraft.world.entity.player.Player;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.passive.PassiveSkill;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class LifeStealPassive extends PassiveSkill {
    private static final UUID EVENT_UUID = UUID.fromString("ee530121-b1df-4ba8-8a11-611808a9f8b6");

    public LifeStealPassive(SkillBuilder<? extends PassiveSkill> builder){
        super(builder);
    }
    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_DAMAGE, EVENT_UUID, (event) -> {
            ((Player) container.getExecutor().getOriginal()).heal(event.getAttackDamage() * 0.1F);
        });
    }
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_DAMAGE, EVENT_UUID);
    }

}
