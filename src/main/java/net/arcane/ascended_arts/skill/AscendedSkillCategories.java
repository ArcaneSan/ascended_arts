package net.arcane.ascended_arts.skill;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.skill.SkillCategory;

public enum AscendedSkillCategories implements SkillCategory {
    ASCENSION_PATH(true, true, true, ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "skillbook_ascension"));


    final boolean shouldSave;
    final boolean shouldSync;
    final boolean modifiable;
    final int id;
    final ResourceLocation bookIcon;

    AscendedSkillCategories(boolean shouldSave, boolean shouldSyncronizedAllPlayers, boolean modifiable) {
        this.shouldSave = shouldSave;
        this.shouldSync = shouldSyncronizedAllPlayers;
        this.modifiable = modifiable;
        this.id = SkillCategory.ENUM_MANAGER.assign(this);
        this.bookIcon = bookIcon();
    }

    AscendedSkillCategories(boolean shouldSave, boolean shouldSyncronizedAllPlayers, boolean modifiable, ResourceLocation bookIcon) {
        this.shouldSave = shouldSave;
        this.shouldSync = shouldSyncronizedAllPlayers;
        this.modifiable = modifiable;
        this.id = SkillCategory.ENUM_MANAGER.assign(this);
        this.bookIcon = bookIcon;
    }

    @Override
    public boolean shouldSave() {
        return this.shouldSave;
    }

    @Override
    public boolean shouldSynchronize() {
        return this.shouldSync;
    }

    @Override
    public boolean learnable() {
        return this.modifiable;
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }


    public ResourceLocation bookIcon() {
        return this.bookIcon;
    }
}