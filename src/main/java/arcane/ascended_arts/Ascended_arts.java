package arcane.ascended_arts;

import arcane.ascended_arts.gameasset.AscendedAnimations;
import arcane.ascended_arts.skill.AscendedSkillDataKeys;
import arcane.ascended_arts.skill.guard.AscendedCompatSkills;
import arcane.ascended_arts.world.capabilities.item.AscendedWeaponCategories;
import arcane.ascended_arts.world.item.AscendedAddontems;
import arcane.ascended_arts.world.item.AscendedCreativeTab;

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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import org.slf4j.Logger;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ascended_arts.MOD_ID)
public class Ascended_arts {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ascended_arts";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "ascended_arts" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "ascended_arts" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);



    public Ascended_arts(FMLJavaModLoadingContext eventBus) {
        IEventBus modEventBus = eventBus.getModEventBus();

        AscendedAddontems.register(modEventBus);
        AscendedCreativeTab.register(modEventBus);

        WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, AscendedWeaponCategories.class);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(AscendedCompatSkills::onIconCreate));

        modEventBus.addListener(AscendedAnimations::registerAnimations);
        modEventBus.addListener(AscendedCompatSkills::forceGuard);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(arcane.ascended_arts.gameasset.AscendedSkills::registerAscendedSkills);
        AscendedSkillDataKeys.DATA_KEYS.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);



        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        eventBus.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);//i readed all ways wrong the documentation LMAO
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
