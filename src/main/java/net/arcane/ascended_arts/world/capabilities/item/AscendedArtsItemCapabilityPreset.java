package net.arcane.ascended_arts.world.capabilities.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.gameasset.AscendedColliderPreset;
import yesman.epicfight.registry.deferred.ItemPresetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredWeapon;
import yesman.epicfight.registry.entries.EpicFightMovesets;
import yesman.epicfight.registry.entries.EpicFightProviderConditionals;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public final class AscendedArtsItemCapabilityPreset {

    private AscendedArtsItemCapabilityPreset() {}
    public static final ItemPresetRegister REGISTRY = ItemPresetRegister.create(Ascended_arts.MOD_ID);


    public static final DeferredWeapon JIAN = REGISTRY.registerWeapon("jian",
            () ->  WeaponCapability.builder()
                    .category(AscendedWeaponCategories.JIAN)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .collider(AscendedColliderPreset.JIAN)
                    .setTierValues(0, 0, 0.0, 0.0)
                    .addMoveset(CapabilityItem.Styles.ONE_HAND, AscendedArtsMovesets.JIAN_1H)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, AscendedArtsMovesets.JIAN_DUAL)
                    .addConditionals(AscendedArtsProviderConditionals.DUAL_JIAN, EpicFightProviderConditionals.DEFAULT_1H_WIELD_STYLE)
                    .addTag(Ascended_arts.identifier("jian"))
    );
    public static final DeferredWeapon SCYTHE = REGISTRY.registerWeapon("scythe",
            () -> WeaponCapability.builder()
                    .category(CapabilityItem.WeaponCategories.GREATSWORD)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .collider(AscendedColliderPreset.SCYTHE)
                    .setTierValues(0, 0, 0.0, 0.0)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, AscendedArtsMovesets.SCYTHE_2H)
                    .addConditionals(EpicFightProviderConditionals.DEFAULT_2H_WIELD_STYLE)
                    .addTag(Ascended_arts.identifier("scythe"))
    );
    public static final DeferredWeapon SWEEPING_SCYTHE = REGISTRY.registerWeapon("sweeping_scythe",
            () -> WeaponCapability.builder()
                    .category(CapabilityItem.WeaponCategories.SWORD)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .collider(AscendedColliderPreset.SWEEPING_SCYTHE)
                    .setTierValues(0, 0, 0.0, 0.0)
                    .addMoveset(CapabilityItem.Styles.ONE_HAND, AscendedArtsMovesets.S_SCYTHE)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, AscendedArtsMovesets.S_SCYTHE_2)
                    .addConditionals(EpicFightProviderConditionals.DUAL_SWORDS, EpicFightProviderConditionals.DEFAULT_1H_WIELD_STYLE)
                    .addTag(Ascended_arts.identifier("sweeping_scythe"))
    );
    public static final DeferredWeapon FLUTE = REGISTRY.registerWeapon("flute",
            () -> WeaponCapability.builder()
                    .category(CapabilityItem.WeaponCategories.NOT_WEAPON)
                    .hitSound(EpicFightSounds.BLUNT_HIT)
                    .addMoveset(CapabilityItem.Styles.OCHS, AscendedArtsMovesets.SUP_FLUTE)
                    .addTag(Ascended_arts.identifier("flute"))
    );
    public static final DeferredWeapon COMPAT_PRAY = REGISTRY.registerWeapon("pray",
            () -> WeaponCapability.builder()
                    .category(CapabilityItem.WeaponCategories.NOT_WEAPON)
                    .hitSound(EpicFightSounds.BLUNT_HIT)
                    .addMoveset(CapabilityItem.Styles.OCHS, AscendedArtsMovesets.PRAY)
                    .addTag(Ascended_arts.identifier("compat_pray"))
    );

}
