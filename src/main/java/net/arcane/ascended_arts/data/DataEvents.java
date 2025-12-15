package net.arcane.ascended_arts.data;

import com.yesman.epicskills.common.data.SkillTreeProvider;
import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.data.DataProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataEvents {

    @SubscribeEvent
    public static void ascended_arts$gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(true, (DataProvider.Factory<SkillTreeProvider>)AscendedArtsSkillTreeProvider::new);
    }
}
