package net.arcane.ascended_arts.skill;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.skill.SkillCategory;

public enum AscendedSkillCategories implements SkillCategory {
    ASCENSION_PATH(true, true, true, Ascended_arts.identifier("skillbook_ascension"));


    final boolean Save;
    final boolean Sync;
    final boolean Modifiable;
    final int ID;
    ResourceLocation bookIcon = null;

    AscendedSkillCategories(boolean ShouldSave, boolean ShouldSync, boolean Modifiable)
    {
        this.Modifiable = Modifiable;
        this.Save = ShouldSave;
        this.Sync = ShouldSync;
        this.ID = SkillCategory.ENUM_MANAGER.assign(this);
    }

    AscendedSkillCategories(boolean ShouldSave, boolean ShouldSync, boolean Modifiable, ResourceLocation bookIcon)
    {
        this.Modifiable = Modifiable;
        this.Save = ShouldSave;
        this.Sync = ShouldSync;
        this.ID = SkillCategory.ENUM_MANAGER.assign(this);
        this.bookIcon = bookIcon;
    }

    @Override
    public boolean shouldSave()
    {
        return this.Save;
    }

    @Override
    public boolean shouldSynchronize()
    {
        return this.Sync;
    }

    @Override
    public boolean learnable()
    {
        return this.Modifiable;
    }
    @Override
    public int universalOrdinal()
    {
        return this.ID;
    }

    @Override
    public ResourceLocation bookIcon() {
        if (bookIcon != null)
        {
            return bookIcon;
        }
        return SkillCategory.super.bookIcon();
    }
}