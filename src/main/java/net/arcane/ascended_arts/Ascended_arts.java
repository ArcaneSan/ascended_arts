package net.arcane.ascended_arts;

import net.arcane.ascended_arts.gameasset.AscendedAnimations;
import net.arcane.ascended_arts.gameasset.AscendedSkills;
import net.arcane.ascended_arts.skill.AscendedSkillDataKeys;
import net.arcane.ascended_arts.skill.guard.AscendedCompatSkills;
import net.arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.arcane.ascended_arts.world.item.AscendedCreativeTab;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import org.slf4j.Logger;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ascended_arts.MOD_ID)
public class Ascended_arts {
    public static AscendedAnimations.IProxy proxy;
    public static final String MOD_ID = "ascended_arts";
    private static final Logger LOGGER = LogUtils.getLogger();



    public Ascended_arts(FMLJavaModLoadingContext eventBus) {
        IEventBus modEventBus = eventBus.getModEventBus();

        AscendedAddonItems.register(modEventBus);
        AscendedCreativeTab.register(modEventBus);

        WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, AscendedWeaponCategories.class);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(AscendedCompatSkills::onIconCreate));

        modEventBus.addListener(AscendedAnimations::registerAnimations);
        modEventBus.addListener(AscendedCompatSkills::forceGuard);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(AscendedSkills::registerAscendedSkills);
        AscendedSkillDataKeys.DATA_KEYS.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            proxy = new AscendedAnimations.ClientProxy();
        } else {
            proxy = new AscendedAnimations.ServerProxy();
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // Add the example block item to the building blocks tab


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
