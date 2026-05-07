package net.arcane.ascended_arts.skill;

import yesman.epicfight.skill.SkillCategory;
import yesman.epicfight.skill.SkillSlot;

public enum AscendedSkillSlots implements SkillSlot {

    ASCENSION_PATH(AscendedSkillCategories.ASCENSION_PATH);

    final SkillCategory category;
    final int id;

    AscendedSkillSlots(SkillCategory category){
        this.category = category;
        this.id = SkillSlot.ENUM_MANAGER.assign(this);
    }


    @Override
    public SkillCategory category() {
        return category;
    }

    @Override
    public int universalOrdinal() {
        return id;
    }
}
