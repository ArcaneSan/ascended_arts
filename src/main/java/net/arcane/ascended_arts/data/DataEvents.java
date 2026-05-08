package net.arcane.ascended_arts.data;


import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.data.tags.AscendedItemTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import yesman.epicfight.data.tags.EpicFightBlockTagsProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Ascended_arts.MOD_ID)
public final class DataEvents {
        private DataEvents() {}

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataGenerator gen = event.getGenerator();
            PackOutput packOutput = gen.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
            EpicFightBlockTagsProvider blockTagsProvider = new EpicFightBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);;

            gen.addProvider(event.includeServer(), new AscendedItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        }
    }
