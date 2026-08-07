package net.arcane.ascended_arts.skill.martial_sect;

import com.mojang.blaze3d.vertex.PoseStack;
import net.arcane.ascended_arts.skill.AscendedSkillCategories;
import net.arcane.ascended_arts.skill.ascension_path.AscensionSkill;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

import java.util.function.Function;

public class MartialSectSkill extends Skill {
    public static SkillBuilder<?> createMartialSectBuilder(Function<SkillBuilder<?>, ? extends MartialSectSkill> constructor) {
        return (new SkillBuilder<MartialSectSkill>()).setCategory(AscendedSkillCategories.MARTIAL_SECT).setResource(Resource.NONE);
    }



    public MartialSectSkill(SkillBuilder<? extends Skill> builder) {
        super(builder);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void drawOnGui(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float partialTick) {
        guiGraphics.blit(this.getSkillTexture(), (int)x, (int)y, 24, 24, 0, 0, 1, 1, 1, 1);
        String remainTime = String.format("%.0f", container.getMaxResource() - container.getResource());
        guiGraphics.drawString(gui.getFont(), remainTime, x + 12 - 4 * remainTime.length(), (y+6), 16777215, true);
    }
}