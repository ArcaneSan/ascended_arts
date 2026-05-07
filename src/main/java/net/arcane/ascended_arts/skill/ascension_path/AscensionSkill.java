package net.arcane.ascended_arts.skill.ascension_path;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arcane.ascended_arts.skill.AscendedSkillCategories;
import net.minecraft.client.gui.GuiGraphics;

import net.neoforged.api.distmarker.OnlyIn;
import yesman.epicfight.api.utils.side.ClientOnly;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.passive.PassiveSkill;

import java.util.function.Function;

public abstract class AscensionSkill extends Skill {
    public static SkillBuilder<?> createAscensionBuilder(Function<SkillBuilder<?>, ? extends PassiveSkill> constructor) {
        return new SkillBuilder<>(constructor).setCategory(AscendedSkillCategories.ASCENSION_PATH).setResource(Resource.NONE);
    }


    @SuppressWarnings("rawtypes")
    public AscensionSkill(SkillBuilder<? extends SkillBuilder> builder) {
        super(builder);
    }
    @Override @ClientOnly
    public void drawOnGui(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float partialTick) {
        guiGraphics.blit(this.getSkillTexture(), (int)x, (int)y, 24, 24, 0, 0, 1, 1, 1, 1);
        String remainTime = String.format("%.0f", container.getMaxResource() - container.getResource());
        guiGraphics.drawString(gui.getFont(), remainTime, x + 12 - 4 * remainTime.length(), (y+6), 16777215, true);
    }
}