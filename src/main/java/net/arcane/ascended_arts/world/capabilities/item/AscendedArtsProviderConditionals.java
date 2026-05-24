package net.arcane.ascended_arts.world.capabilities.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.ex_cap.provider.ProviderConditional;
import yesman.epicfight.registry.deferred.ProviderConditionalRegister;
import yesman.epicfight.registry.deferred.holders.DeferredConditional;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class AscendedArtsProviderConditionals {
    private AscendedArtsProviderConditionals() {}

    public static final ProviderConditionalRegister REGISTRY = ProviderConditionalRegister.create(Ascended_arts.MOD_ID);

    public static final DeferredConditional DUAL_JIAN = REGISTRY.registerConditional(
            "dual_jian",
            () -> ProviderConditional.createWeaponCategory(CapabilityItem.Styles.TWO_HAND, AscendedWeaponCategories.JIAN, InteractionHand.OFF_HAND, true)
    );
}
