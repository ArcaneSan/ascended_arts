package net.arcane.ascended_arts;

import com.mojang.logging.LogUtils;
import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.gameasset.AscendedSkills;
import net.arcane.ascended_arts.skill.AscendedSkillSlots;
import net.arcane.ascended_arts.skill.guard.AscendedCompatSkills;
import net.arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import net.arcane.ascended_arts.world.capabilities.item.WeaponCapabilityPresets;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.arcane.ascended_arts.world.item.AscendedCreativeTab;
import net.minecraft.client.Minecraft;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.slf4j.Logger;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Ascended_arts.MOD_ID)
public class Ascended_arts {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ascended_arts";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static AscendedAnimations.ClientProxy proxy;

    public static ResourceLocation identifier(String name) {

        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, name);
    }

    public Ascended_arts(IEventBus bus, ModContainer modContainer) {

        bus.addListener(this::commonSetup);

        AscendedAddonItems.register(bus);
        AscendedCreativeTab.register(bus);
        bus.addListener(AscendedAnimations::registerAnimations);

        AscendedSkills.REGISTRY.register(bus);


        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(AscendedCompatSkills::onGuardSkillCreation);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(AscendedCompatSkills::onParrySkillCreation);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(AscendedCompatSkills::onEFNParrySkillCreation);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(AscendedCompatSkills::onEmergencyEscapeSkillCreation);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(AscendedCompatSkills::onIdentitySkillCreate);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(AscendedCompatSkills::onSwordMasterSkillCreation);
        EpicFightClientEventHooks.Registry.WEAPON_CATEGORY_ICON.registerEvent(AscendedCompatSkills::onWeaponCategoryIconCreation);
        EpicFightEventHooks.Registry.WEAPON_CAPABILITY_PRESET.registerEvent(WeaponCapabilityPresets::registerMovesets);



        WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, AscendedWeaponCategories.class);
        AscendedSkillSlots.ENUM_MANAGER.registerEnumCls(MOD_ID, AscendedSkillSlots.class);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us

    }

    private void doCommonStuff(final FMLCommonSetupEvent event){

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
