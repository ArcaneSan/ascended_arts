package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.skill.AscendedSkillDataKeys;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.arcane.ascended_arts.world.item.AscendedCreativeTab;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class AscendedRegisters {

    public static List<DeferredRegister<?>> REGISTERS =
            List.of(
                    AscendedAddonItems.ITEMS,
/*
                    AscendedCreativeTab.CREATIVE_MODE_TABS,
*/
                    AscendedSkillDataKeys.DATA_KEYS

            );
}
