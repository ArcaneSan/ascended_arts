package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.entity.client.armor.IronHanfuArmorItem;
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
    public static final RegistryObject<Item> IRON_HANFU_HOOD =
            ITEMS.register("iron_hanfu_hood", () -> new IronHanfuArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_ROBE =
            ITEMS.register("iron_hanfu_robe", () -> new IronHanfuArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_PANTS =
            ITEMS.register("iron_hanfu_pants", () -> new IronHanfuArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANFU_BOOTS =
            ITEMS.register("iron_hanfu_boots", () -> new IronHanfuArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));


    public  static  void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
