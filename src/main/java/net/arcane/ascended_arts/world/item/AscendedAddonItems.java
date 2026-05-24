package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;

import net.arcane.ascended_arts.entity.client.armor.*;
import net.arcane.ascended_arts.entity.client.armor.VoidSlayerArmorItem;
import net.arcane.ascended_arts.item.AscendedToolTiers;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;



public class AscendedAddonItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Ascended_arts.MOD_ID);

//    public static final DeferredItem<Item> TESTER =
//            ITEMS.register("tester", () -> new AscendedItem(new Item.Properties(), Tiers.DIAMOND));

    public static final DeferredItem<Item> CLOTH =
             ITEMS.register("cloth", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> HANFU_UPGRADE =
             ITEMS.register("hanfu_upgrade", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).stacksTo(16)));
    public static final DeferredItem<AscendedItem> IRON_JIAN =
             ITEMS.register("iron_jian", () -> new AscendedItem(AscendedToolTiers.IRONPLUS, new Item.Properties().attributes(AscendedItem.createAscendedNormalAttributes(Tiers.IRON))));
    public static final DeferredItem<Item> GREATSWORD =
            ITEMS.register("greatsword", () -> new AscendLargeItem(AscendedToolTiers.MYTHOS, new Item.Properties().rarity(Rarity.RARE).fireResistant().attributes(AscendLargeItem.createAscendedLargeAttributes(Tiers.NETHERITE))));
    public static final DeferredItem<Item> ETHERVEIL_SCYTHE =
            ITEMS.register("etherveil_scythe", () -> new AscendLargeItem(AscendedToolTiers.MYTHOS, new Item.Properties().fireResistant().attributes(AscendLargeItem.createAscendedLargeAttributes(Tiers.NETHERITE))));
    public static final DeferredItem<Item> DIAMOND_JIAN =
            ITEMS.register("diamond_jian", () -> new AscendedItem(AscendedToolTiers.DIAMONDPLUS, new Item.Properties().attributes(AscendedItem.createAscendedNormalAttributes(Tiers.DIAMOND))));
    public static final DeferredItem<Item> NETHERITE_JIAN =
            ITEMS.register("netherite_jian", () -> new AscendedItem(AscendedToolTiers.NETHERITEPLUS, new Item.Properties().fireResistant().attributes(AscendedItem.createAscendedNormalAttributes(Tiers.NETHERITE))));
    public static final DeferredItem<Item> GOLDEN_JIAN =
            ITEMS.register("golden_jian", () -> new AscendedItem(AscendedToolTiers.GOLDPLUS, new Item.Properties().attributes(AscendedItem.createAscendedNormalAttributes(Tiers.GOLD))));
    public static final DeferredItem<Item> WOODEN_JIAN =
            ITEMS.register("wooden_jian", () -> new AscendedItem( AscendedToolTiers.WOODPLUS, new Item.Properties().attributes(AscendedItem.createAscendedNormalAttributes(Tiers.WOOD))));
    public static final DeferredItem<Item> SKYSPLITTER_JIAN =
            ITEMS.register("skysplitter_jian", () -> new AscendedItem(AscendedToolTiers.MYTHOS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(AscendedItem.createAscendedNormalAttributes(Tiers.NETHERITE))));
    public static final DeferredItem<Item> SMALL_WOODEN_SCYTHE =
            ITEMS.register("small_wooden_scythe", () -> new AscendedSmallScytheItem(AscendedToolTiers.WOODPLUS, new Item.Properties().attributes(AscendedSmallScytheItem.createAscendedSmallAttributes(Tiers.WOOD))));
    public static final DeferredItem<Item> SMALL_IRON_SCYTHE =
            ITEMS.register("small_iron_scythe", () -> new AscendedSmallScytheItem(AscendedToolTiers.IRONPLUS, new Item.Properties().attributes(AscendedSmallScytheItem.createAscendedSmallAttributes(Tiers.IRON))));
    public static final DeferredItem<Item> SMALL_GOLDEN_SCYTHE =
            ITEMS.register("small_golden_scythe", () -> new AscendedSmallScytheItem(AscendedToolTiers.GOLDPLUS, new Item.Properties().attributes(AscendedSmallScytheItem.createAscendedSmallAttributes(Tiers.GOLD))));
    public static final DeferredItem<Item> SMALL_DIAMOND_SCYTHE =
            ITEMS.register("small_diamond_scythe", () -> new AscendedSmallScytheItem(AscendedToolTiers.DIAMONDPLUS, new Item.Properties().attributes(AscendedSmallScytheItem.createAscendedSmallAttributes(Tiers.DIAMOND))));
    public static final DeferredItem<Item> SMALL_NETHERITE_SCYTHE =
            ITEMS.register("small_netherite_scythe", () -> new AscendedSmallScytheItem(AscendedToolTiers.NETHERITEPLUS, new Item.Properties().fireResistant().attributes(AscendedSmallScytheItem.createAscendedSmallAttributes(Tiers.NETHERITE))));

   public static final DeferredItem<RoyalHunterArmorItem> ROYAL_HUNTER_MASK =
            ITEMS.register("royal_hunter_mask", () -> new RoyalHunterArmorItem(ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<RoyalHunterArmorItem> ROYAL_HUNTER_ROBES =
            ITEMS.register("royal_hunter_robes", () -> new RoyalHunterArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<RoyalHunterArmorItem> ROYAL_HUNTER_LEGGINGS =
            ITEMS.register("royal_hunter_leggings", () -> new RoyalHunterArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<RoyalHunterArmorItem> ROYAL_HUNTER_BOOTS =
            ITEMS.register("royal_hunter_boots", () -> new RoyalHunterArmorItem(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<VoidSlayerArmorItem> VOID_SLAYER_HALO =
            ITEMS.register("void_slayer_halo", () -> new VoidSlayerArmorItem(ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<VoidSlayerArmorItem> VOID_SLAYER_ROBES =
            ITEMS.register("void_slayer_robes", () -> new VoidSlayerArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<VoidSlayerArmorItem> VOID_SLAYER_LEGGINGS =
            ITEMS.register("void_slayer_leggings", () -> new VoidSlayerArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<VoidSlayerArmorItem> VOID_SLAYER_BOOTS =
            ITEMS.register("void_slayer_boots", () -> new VoidSlayerArmorItem(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> HANFU_HOOD =
            ITEMS.register("hanfu_hood", () -> new HanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<HanfuArmorItem> HANFU_ROBE =
            ITEMS.register("hanfu_robe", () -> new HanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<HanfuArmorItem> HANFU_PANTS =
            ITEMS.register("hanfu_pants", () -> new HanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<HanfuArmorItem> HANFU_BOOTS =
            ITEMS.register("hanfu_boots", () -> new HanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<IronHanfuArmorItem> IRON_HANFU_HOOD =
            ITEMS.register("iron_hanfu_hood", () -> new IronHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<IronHanfuArmorItem> IRON_HANFU_ROBE =
            ITEMS.register("iron_hanfu_robe", () -> new IronHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<IronHanfuArmorItem> IRON_HANFU_PANTS =
            ITEMS.register("iron_hanfu_pants", () -> new IronHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<IronHanfuArmorItem> IRON_HANFU_BOOTS =
            ITEMS.register("iron_hanfu_boots", () -> new IronHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<GoldHanfuArmorItem> GOLD_HANFU_HOOD =
            ITEMS.register("gold_hanfu_hood", () -> new GoldHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<GoldHanfuArmorItem> GOLD_HANFU_ROBE =
            ITEMS.register("gold_hanfu_robe", () -> new GoldHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<GoldHanfuArmorItem> GOLD_HANFU_PANTS =
            ITEMS.register("gold_hanfu_pants", () -> new GoldHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<GoldHanfuArmorItem> GOLD_HANFU_BOOTS =
            ITEMS.register("gold_hanfu_boots", () -> new GoldHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<DiamondHanfuArmorItem> DIAMOND_HANFU_HOOD =
            ITEMS.register("diamond_hanfu_hood", () -> new DiamondHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<DiamondHanfuArmorItem> DIAMOND_HANFU_ROBE =
            ITEMS.register("diamond_hanfu_robe", () -> new DiamondHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<DiamondHanfuArmorItem> DIAMOND_HANFU_PANTS =
            ITEMS.register("diamond_hanfu_pants", () -> new DiamondHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<DiamondHanfuArmorItem> DIAMOND_HANFU_BOOTS =
            ITEMS.register("diamond_hanfu_boots", () -> new DiamondHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<NetheriteHanfuArmorItem> NETHERITE_HANFU_HOOD =
            ITEMS.register("netherite_hanfu_hood", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<NetheriteHanfuArmorItem> NETHERITE_HANFU_ROBE =
            ITEMS.register("netherite_hanfu_robe", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<NetheriteHanfuArmorItem> NETHERITE_HANFU_PANTS =
            ITEMS.register("netherite_hanfu_pants", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<NetheriteHanfuArmorItem> NETHERITE_HANFU_BOOTS =
            ITEMS.register("netherite_hanfu_boots", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));


    public static final DeferredItem<Item> SILENCE_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("silence_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "silence_hanfu")));
    public static final DeferredItem<Item> COAST_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("coast_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "coast_hanfu")));
    public static final DeferredItem<Item> DUNE_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("dune_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "dune_hanfu")));
    public static final DeferredItem<Item> EYE_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("eye_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "eye_hanfu")));
    public static final DeferredItem<Item> HOST_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("host_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "host_hanfu")));
    public static final DeferredItem<Item> WILD_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("wild_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "wild_hanfu")));
    public static final DeferredItem<Item> RAISER_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("raiser_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "raiser_hanfu")));
    public static final DeferredItem<Item> RIB_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("rib_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "rib_hanfu")));
    public static final DeferredItem<Item> SENTRY_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("sentry_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "sentry_hanfu")));
    public static final DeferredItem<Item> SNOUT_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("snout_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "snout_hanfu")));
    public static final DeferredItem<Item> SPIRE_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("spire_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "spire_hanfu")));
    public static final DeferredItem<Item> TIDE_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("tide_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "tide_hanfu")));
    public static final DeferredItem<Item> VEX_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("vex_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "vex_hanfu")));
    public static final DeferredItem<Item> WARD_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("ward_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "ward_hanfu")));
    public static final DeferredItem<Item> WAYFINDER_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("wayfinder_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "wayfinder_hanfu")));
    public static final DeferredItem<Item> SHAPER_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("shaper_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "shaper_hanfu")));
    public static final DeferredItem<Item> BOLT_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("bolt_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "bolt_hanfu")));
    public static final DeferredItem<Item> FLOW_HANFU_SMITHING_TEMPLATE =
            ITEMS.register("flow_hanfu_armor_trim_smithing_template", () ->
                    SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "flow_hanfu")));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
