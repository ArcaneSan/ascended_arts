package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.entity.client.armor.*;
import net.arcane.ascended_arts.item.AscendedArmorMaterials;
import net.arcane.ascended_arts.item.AscendedToolTiers;
import net.arcane.ascended_arts.item.custom.RoyalHunterArmorItem;
import net.arcane.ascended_arts.item.custom.SkySplitterItem;
import net.arcane.ascended_arts.item.custom.VoidSlayerArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AscendedAddonItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Ascended_arts.MOD_ID);

    public static final RegistryObject<Item> CLOTH =
            ITEMS.register("cloth", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> HANFU_UPGRADE =
            ITEMS.register("hanfu_upgrade", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).stacksTo(16)));

    public static final RegistryObject<Item> IRON_JIAN =
            ITEMS.register("iron_jian", () -> new AscendedItem(new Item.Properties(), Tiers.IRON));
    public static final RegistryObject<Item> GREATSWORD =
            ITEMS.register("greatsword", () -> new AscendLargeItem(new Item.Properties().rarity(Rarity.RARE), Tiers.NETHERITE));
    public static final RegistryObject<Item> ETHERVEIL_SCYTHE =
            ITEMS.register("etherveil_scythe", () -> new AscendLargeItem(new Item.Properties(), Tiers.NETHERITE));
    public static final RegistryObject<Item> DIAMOND_JIAN =
            ITEMS.register("diamond_jian", () -> new AscendedItem(new Item.Properties(), Tiers.DIAMOND));
    public static final RegistryObject<Item> NETHERITE_JIAN =
            ITEMS.register("netherite_jian", () -> new AscendedItem(new Item.Properties().fireResistant(), Tiers.NETHERITE));
    public static final RegistryObject<Item> GOLDEN_JIAN =
            ITEMS.register("golden_jian", () -> new AscendedItem(new Item.Properties(), Tiers.GOLD));
    public static final RegistryObject<Item> WOODEN_JIAN =
            ITEMS.register("wooden_jian", () -> new AscendedItem(new Item.Properties(), Tiers.WOOD));
    public static final RegistryObject<Item> SKYSPLITTER_JIAN =
            ITEMS.register("skysplitter_jian", () -> new SkySplitterItem(new Item.Properties().fireResistant(), AscendedToolTiers.Mythos));
    public static final RegistryObject<Item> SMALL_WOODEN_SCYTHE =
            ITEMS.register("small_wooden_scythe", () -> new AscendedSmallScytheItem(new Item.Properties(), Tiers.WOOD));
    public static final RegistryObject<Item> SMALL_IRON_SCYTHE =
            ITEMS.register("small_iron_scythe", () -> new AscendedSmallScytheItem(new Item.Properties(), Tiers.IRON));
    public static final RegistryObject<Item>  SMALL_GOLDEN_SCYTHE =
            ITEMS.register("small_golden_scythe", () -> new AscendedSmallScytheItem(new Item.Properties(), Tiers.GOLD));
    public static final RegistryObject<Item> SMALL_DIAMOND_SCYTHE =
            ITEMS.register("small_diamond_scythe", () -> new AscendedSmallScytheItem(new Item.Properties(), Tiers.DIAMOND));
    public static final RegistryObject<Item> SMALL_NETHERITE_SCYTHE =
            ITEMS.register("small_netherite_scythe", () -> new AscendedSmallScytheItem(new Item.Properties().fireResistant(), Tiers.NETHERITE));

    public static final RegistryObject<Item> ROYAL_HUNTER_MASK =
            ITEMS.register("royal_hunter_mask", () -> new RoyalHunterArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ROYAL_HUNTER_ROBES =
            ITEMS.register("royal_hunter_robes", () -> new RoyalHunterArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ROYAL_HUNTER_LEGGINGS =
            ITEMS.register("royal_hunter_leggings", () -> new RoyalHunterArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ROYAL_HUNTER_BOOTS =
            ITEMS.register("royal_hunter_boots", () -> new RoyalHunterArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VOID_SLAYER_HALO =
            ITEMS.register("void_slayer_halo", () -> new VoidSlayerArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VOID_SLAYER_ROBES =
            ITEMS.register("void_slayer_robes", () -> new VoidSlayerArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VOID_SLAYER_LEGGINGS =
            ITEMS.register("void_slayer_leggings", () -> new VoidSlayerArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VOID_SLAYER_BOOTS =
            ITEMS.register("void_slayer_boots", () -> new VoidSlayerArmorItem(AscendedArmorMaterials.Mythos, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> HANFU_HOOD =
            ITEMS.register("hanfu_hood", () -> new HanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HANFU_ROBE =
            ITEMS.register("hanfu_robe", () -> new HanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HANFU_PANTS =
            ITEMS.register("hanfu_pants", () -> new HanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HANFU_BOOTS =
            ITEMS.register("hanfu_boots", () -> new HanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_HOOD =
            ITEMS.register("iron_hanfu_hood", () -> new IronHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_ROBE =
            ITEMS.register("iron_hanfu_robe", () -> new IronHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_PANTS =
            ITEMS.register("iron_hanfu_pants", () -> new IronHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_BOOTS =
            ITEMS.register("iron_hanfu_boots", () -> new IronHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_HANFU_HOOD =
            ITEMS.register("gold_hanfu_hood", () -> new GoldHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_HANFU_ROBE =
            ITEMS.register("gold_hanfu_robe", () -> new GoldHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_HANFU_PANTS =
            ITEMS.register("gold_hanfu_pants", () -> new GoldHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_HANFU_BOOTS =
            ITEMS.register("gold_hanfu_boots", () -> new GoldHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HANFU_HOOD =
            ITEMS.register("diamond_hanfu_hood", () -> new DiamondHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HANFU_ROBE =
            ITEMS.register("diamond_hanfu_robe", () -> new DiamondHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HANFU_PANTS =
            ITEMS.register("diamond_hanfu_pants", () -> new DiamondHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HANFU_BOOTS =
            ITEMS.register("diamond_hanfu_boots", () -> new DiamondHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_HANFU_HOOD =
            ITEMS.register("netherite_hanfu_hood", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_HANFU_ROBE =
            ITEMS.register("netherite_hanfu_robe", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_HANFU_PANTS =
            ITEMS.register("netherite_hanfu_pants", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_HANFU_BOOTS =
            ITEMS.register("netherite_hanfu_boots", () -> new NetheriteHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));


    public  static  void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
