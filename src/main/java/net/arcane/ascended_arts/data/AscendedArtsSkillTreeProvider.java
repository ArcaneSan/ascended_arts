package net.arcane.ascended_arts.data;

import com.yesman.epicskills.common.data.SkillTreeProvider;
import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedSkills;
import net.minecraft.data.PackOutput;

import java.util.function.Consumer;

public class AscendedArtsSkillTreeProvider extends SkillTreeProvider {
    public AscendedArtsSkillTreeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    protected void buildSkillTreePages(Consumer<SkillTreeProvider.SkillTreePageBuilder> writer) {
        writer.accept(
                newPage(Ascended_arts.MOD_ID, "path_to_ascension")
                        .menuBarColor(255, 215, 0)
                        .newNode(AscendedSkills.QI_BUILDING)
                        .position(20, 30)
                        .abilityPointsRequirement(5)
                        .done()
        );

    }


}
