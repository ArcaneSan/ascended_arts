package arcane.ascended_arts.world.capabilities.item;

import arcane.ascended_arts.Ascended_arts;
import arcane.ascended_arts.gameasset.AscendedAnimations;
import arcane.ascended_arts.gameasset.AscendedColliderPresent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)

public class WeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> JIAN = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(AscendedWeaponCategories.JIAN) // Updated to use custom category
                .styleProvider((playerpatch) -> CapabilityItem.Styles.OCHS)

                .collider(AscendedColliderPresent.JIAN)
                .canBePlacedOffhand(true)
                .newStyleCombo(Styles.OCHS, AscendedAnimations.JIAN_AUTO_1, AscendedAnimations.JIAN_AUTO_2, AscendedAnimations.JIAN_AUTO_3, AscendedAnimations.JIAN_AUTO_4, AscendedAnimations.JIAN_DASH, AscendedAnimations.JIAN_AIRSLASH)
                .livingMotionModifier(Styles.OCHS, LivingMotions.IDLE, AscendedAnimations.BIPED_HOLD_Jian)
                .livingMotionModifier(Styles.OCHS, LivingMotions.WALK, AscendedAnimations.BIPED_WALK_JIAN)
                .livingMotionModifier(Styles.OCHS, LivingMotions.RUN, AscendedAnimations.BIPED_RUN_JIAN)
                .livingMotionModifier(Styles.OCHS, LivingMotions.BLOCK, AscendedAnimations.JIAN_GUARD);


        return builder;
    };

    @SubscribeEvent
    public static void registerMovesets(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID,"jian"), JIAN);
    }
}
