package net.arcane.ascended_arts.skill.guard;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent.ModRegistryWorker.SkillCreateEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class AscendedCompatEFN implements ICompatModule {
    public static void forceGuard(SkillBuildEvent bus) {
    }

    @SubscribeEvent
    public static void onEnhancedParrySkillCreate(SkillCreateEvent<ParryingSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("efn", "efn_parry"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder.addGuardMotion(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                            AscendedAnimations.JIAN_GUARD_HIT : AscendedAnimations.JIAN_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(AscendedWeaponCategories.JIAN, (item, player) -> {
                        return AscendedAnimations.JIAN_GUARD_BREAK;
                    }).addAdvancedGuardMotion(AscendedWeaponCategories.JIAN, (itemCap, playerPatch) -> itemCap.getStyle(playerPatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(AscendedAnimations.JIAN_GUARD_PARRY_1, AscendedAnimations.JIAN_GUARD_PARRY_2)
                            : List.of(AscendedAnimations.JIAN_DUAL_GUARD_PARRY_1, AscendedAnimations.JIAN_DUAL_GUARD_PARRY_2)
                    );
        }
                    System.out.println("[AscendedCompatENF] Ascended Arts Parry animations have be actualized");
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onIconCreate(WeaponCategoryIconRegisterEvent icon){
        icon.registerCategory(AscendedWeaponCategories.JIAN, new ItemStack(AscendedAddonItems.IRON_JIAN.get()));
    }
    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }
    @Override
    public void onForgeEventBus(IEventBus iEventBus) {
    }
    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
    }
    @Override
    public void onForgeEventBusClient(IEventBus iEventBus) {
    }


}
