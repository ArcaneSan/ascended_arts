package net.arcane.ascended_arts.data.loot;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;

import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID)
public class AscendedArtsLootTables {

    @SubscribeEvent
    public static void modifyVanillaLootPools(final LootTableLoadEvent event) {
        if (event.getName().equals(BuiltInLootTables.ANCIENT_CITY)){
            event.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.15F))
                    .add(LootItem.lootTableItem(AscendedAddonItems.SKYSPLITTER_JIAN.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ETHERVEIL_SCYTHE.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_MASK.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_ROBES.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_LEGGINGS.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_BOOTS.get()))
                    .build());
        }
        if (event.getName().equals(BuiltInLootTables.ABANDONED_MINESHAFT)){
            event.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.05F))
                    .add(LootItem.lootTableItem(AscendedAddonItems.SKYSPLITTER_JIAN.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ETHERVEIL_SCYTHE.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_MASK.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_ROBES.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_LEGGINGS.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_BOOTS.get()))
                    .build());
        }
        if (event.getName().equals(BuiltInLootTables.END_CITY_TREASURE)){
            event.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.30F))
                    .add(LootItem.lootTableItem(AscendedAddonItems.SKYSPLITTER_JIAN.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ETHERVEIL_SCYTHE.get()))
                    .build());
        }
        if (event.getName().equals(BuiltInLootTables.END_CITY_TREASURE)) {
            event.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.20F))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_MASK.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_ROBES.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_LEGGINGS.get()))
                    .add(LootItem.lootTableItem(AscendedAddonItems.ROYAL_HUNTER_BOOTS.get()))
                    .build());
        }
    }


}
