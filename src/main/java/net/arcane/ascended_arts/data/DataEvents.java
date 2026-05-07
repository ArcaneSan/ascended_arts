package net.arcane.ascended_arts.data;

import com.yesman.epicskills.common.data.SkillTreeProvider;
import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@EventBusSubscriber(modid = Ascended_arts.MOD_ID)
public final class DataEvents {

    @SubscribeEvent
    public static void ascended_arts$gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(true, (DataProvider.Factory<SkillTreeProvider>)AscendedArtsSkillTreeProvider::new);
    }
}
