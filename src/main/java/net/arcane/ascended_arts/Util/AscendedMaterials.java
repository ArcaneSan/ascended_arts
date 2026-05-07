package net.arcane.ascended_arts.Util;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class AscendedMaterials {
    public static final DeferredRegister<ArmorMaterial> MATERIALS =
            DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, Ascended_arts.MOD_ID);

    public static final Holder<ArmorMaterial> VOID_SLAYER = MATERIALS.register("void_slayer_armor", () -> register(
            "void_slayer_armor",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.BOOTS, 4);
            }),
            40,
            SoundEvents.ARMOR_EQUIP_ELYTRA,
            5.0f,
            0.3f,
            () -> Ingredient.of(new ItemStack(Items.PHANTOM_MEMBRANE))
    ));

    public static final Holder<ArmorMaterial> ROYAL_HUNTER = MATERIALS.register("royal_hunter_armor", () -> register(
            "royal_hunter_armor",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.BOOTS, 4);
            }),
            40,
            SoundEvents.ARMOR_EQUIP_ELYTRA,
            5.0f,
            0.3f,
            () -> Ingredient.of(new ItemStack(Items.PHANTOM_MEMBRANE))
    ));

    public static final Holder<ArmorMaterial> NETHERITE_HANFU = MATERIALS.register("netherite", () -> register(
            "armored_robes",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            30,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f,
            0.2f,
            () -> Ingredient.of(new ItemStack(Items.NETHERITE_INGOT))
    ));
    public static final Holder<ArmorMaterial> DIAMOND_HANFU = MATERIALS.register("diamond", () -> register(
            "armored_robes",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.BOOTS, 3);
            }),
            32,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.0f,
            0.1f,
            () -> Ingredient.of(new ItemStack(Items.DIAMOND))
    ));
    public static final Holder<ArmorMaterial> GOLD_HANFU = MATERIALS.register("gold", () -> register(
            "armored_robes",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.BOOTS, 1);
            }),
            35,
            SoundEvents.ARMOR_EQUIP_GOLD,
            1.0f,
            0.0f,
            () -> Ingredient.of(new ItemStack(Items.GOLD_INGOT))
    ));
    public static final Holder<ArmorMaterial> IRON_HANFU = MATERIALS.register("iron", () -> register(
            "armored_robes",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.BOOTS, 2);
            }),
            19,
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f,
            0.0f,
            () -> Ingredient.of(new ItemStack(Items.IRON_INGOT))
    ));
    public static final Holder<ArmorMaterial> HANFU_ROBES = MATERIALS.register("unarmored_robes", () -> register(
            "unarmored_robes",
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.BOOTS, 1);
            }),
            20,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0f,
            0.0f,
            () -> Ingredient.of(new ItemStack(AscendedAddonItems.CLOTH.get()))
    ));


    private static ArmorMaterial register(
            String pName,
            EnumMap<ArmorItem.Type, Integer> pDefense,
            int pEnchantmentValue,
            Holder<SoundEvent> pEquipSound,
            float pToughness,
            float pKnockbackResistance,
            Supplier<Ingredient> pRepairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Ascended_arts.identifier(pName)));
        return register(pDefense, pEnchantmentValue, pEquipSound, pToughness, pKnockbackResistance, pRepairIngredient, list);
    }
    private static ArmorMaterial register(
            EnumMap<ArmorItem.Type, Integer> pDefense,
            int pEnchantmentValue,
            Holder<SoundEvent> pEquipSound,
            float pToughness,
            float pKnockbackResistance,
            Supplier<Ingredient> pRepairIngredient,
            List<ArmorMaterial.Layer> pLayers
    ) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, pDefense.get(armoritem$type));
        }

        return new ArmorMaterial(enummap, pEnchantmentValue, pEquipSound, pRepairIngredient, pLayers, pToughness, pKnockbackResistance);
    }

}
