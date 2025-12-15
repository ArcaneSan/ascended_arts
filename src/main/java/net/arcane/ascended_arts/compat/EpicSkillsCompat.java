package net.arcane.ascended_arts.compat;

import com.yesman.epicskills.client.gui.screen.CategorySlotTexture;
import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.client.AscendedArtsCategorySlotTextures;

public class EpicSkillsCompat {

    public static void registerCategorySlotTexture() {
        CategorySlotTexture.ENUM_MANAGER.registerEnumCls(Ascended_arts.MOD_ID, AscendedArtsCategorySlotTextures.class);
    }
}
