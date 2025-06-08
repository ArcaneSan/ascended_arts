package arcane.ascended_arts.skill.guard;

import arcane.ascended_arts.Ascended_arts;
import arcane.ascended_arts.gameasset.AscendedAnimations;
import arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import arcane.ascended_arts.world.item.AscendedAddontems;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent.ModRegistryWorker.SkillCreateEvent;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.skill.passive.EmergencyEscapeSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;


@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AscendedCompatSkills {
    public static void forceGuard(SkillBuildEvent bus) {
    }
    @SubscribeEvent
    public static void onGuardSkillCreate(SkillCreateEvent<GuardSkill.Builder> event) {
        System.out.println("[AscendedCompatSkills] Skill being built: " + event.getRegistryName());
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "guard"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder.addGuardMotion(AscendedWeaponCategories.JIAN, (Item, player) -> {
              return AscendedAnimations.JIAN_GUARD_HIT;
            });


            System.out.println("[AscendedCompatSkills] Guard animations have been actualized");

        }
    }
    @SubscribeEvent
    public static void onParrySkillCreate(SkillCreateEvent<ParryingSkill.Builder> event) {
        if(event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "parrying"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder.addGuardMotion(AscendedWeaponCategories.JIAN, (item, player) ->{
                return AscendedAnimations.JIAN_GUARD_HIT;
            });
            System.out.println("[AscendedCompatSkills] Parrying animations have been actualized");
        }
    }

    @SubscribeEvent
    public static void onScapeSkillCreate(SkillCreateEvent<EmergencyEscapeSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "emergency_escape"))) {
            EmergencyEscapeSkill.Builder builder = event.getSkillBuilder();
            builder.addAvailableWeaponCategory(AscendedWeaponCategories.JIAN);
        }
        System.out.println("[AscenededCompatSkills] You may now take emergency escape");
    }

    @SubscribeEvent
    public static void onSwordSkillCreate(SkillCreateEvent<SwordmasterSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "swordmaster"))) {
            SwordmasterSkill.Builder builder = event.getSkillBuilder();
            builder.addAvailableWeaponCategory(AscendedWeaponCategories.JIAN);
        }
        System.out.println("[AscenededCompatSkills] You are now a Swordmaster");
    }





    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onIconCreate(WeaponCategoryIconRegisterEvent icon){
        icon.registerCategory(AscendedWeaponCategories.JIAN, new ItemStack(AscendedAddontems.IRON_JIAN.get()));

        System.out.println("[AscendedCompatSkills] Skill icons have been actualized");
    }
}
