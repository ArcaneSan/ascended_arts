package net.arcane.ascended_arts.data;

import com.yesman.epicskills.common.data.SkillTreeProvider;
import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedSkills;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.PlayerPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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
                        .newNode(AscendedSkills.FOUNDATION_BUILDING)
                        .position(20, 130)
                        .abilityPointsRequirement(15)
                        .addParent(AscendedSkills.QI_BUILDING)
                        .unlockCondition(
                                EntityPredicate.Builder.entity()
                                        .subPredicate(
                                                PlayerPredicate.Builder.player()
                                                        .addStat(Stats.ENTITY_KILLED, EntityType.EVOKER.builtInRegistryHolder(), MinMaxBounds.Ints.atLeast(20))
                                                        .build()
                                        )
                                        .build()
                        )
                        .unlockTipTranslationKey("unlock_tip.ascended_arts.ascension_path.foundation_building")
                        .done()
                        .newNode(AscendedSkills.PLUM_BLOSSOM_SECT)
                        .position(160, 30)
                        .abilityPointsRequirement(10)
                        .unlockCondition(
                                EntityPredicate.Builder.entity()
                                        .subPredicate(
                                                PlayerPredicate.Builder.player()
                                                        .addStat(Stats.BLOCK_MINED, Blocks.CHERRY_LEAVES.builtInRegistryHolder(), MinMaxBounds.Ints.atLeast(2000))
                                                        .build()
                                        )
                                        .build()
                        )
                        .unlockTipTranslationKey("unlock_tip.ascended_arts.martial_sect.plum_blossom")
                        .done()
        );

    }


}
