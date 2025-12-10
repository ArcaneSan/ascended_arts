package net.arcane.ascended_arts.entity.client;


import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.entity.client.model.ArmoredRobeModel;
import net.arcane.ascended_arts.entity.client.model.RobeModel;
import net.arcane.ascended_arts.entity.client.model.RoyalHunterArmorModel;
import net.arcane.ascended_arts.entity.client.model.VoidSlayerArmorModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ascended_arts.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ClientRegistry {
    public static final ModelLayerLocation ROBE_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ascended_arts", "unarmored_robes"), "main");
    public static final ModelLayerLocation ARMORED_ROBE_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ascended_arts", "armored_robes"), "main");
    public static final ModelLayerLocation VOID_SLAYER_ARMOR_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ascended_arts", "void_slayer_armor"), "main");
    public static final ModelLayerLocation ROYAL_HUNTER_ARMOR_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ascended_arts", "royal_hunter_armor"), "main");

    public static RobeModel ROBE_MODEL = null;
    public static ArmoredRobeModel ARMORED_ROBE_MODEL = null;
    public static VoidSlayerArmorModel VOID_SLAYER_ARMOR_MODEL = null;
    public static RoyalHunterArmorModel ROYAL_HUNTER_ARMOR_MODEL = null;

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ARMORED_ROBE_LAYER, ArmoredRobeModel::createBodyLayer);
        event.registerLayerDefinition(ROBE_LAYER, RobeModel::createBodyLayer);
        event.registerLayerDefinition(VOID_SLAYER_ARMOR_LAYER, VoidSlayerArmorModel::createBodyLayer);
        event.registerLayerDefinition(ROYAL_HUNTER_ARMOR_LAYER, RoyalHunterArmorModel::createBodyLayer);


    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.AddLayers event) {
        ARMORED_ROBE_MODEL = new ArmoredRobeModel(event.getEntityModels().bakeLayer(ARMORED_ROBE_LAYER));
        ROBE_MODEL = new RobeModel(event.getEntityModels().bakeLayer(ROBE_LAYER));
        VOID_SLAYER_ARMOR_MODEL = new VoidSlayerArmorModel(event.getEntityModels().bakeLayer(VOID_SLAYER_ARMOR_LAYER));
        ROYAL_HUNTER_ARMOR_MODEL = new RoyalHunterArmorModel(event.getEntityModels().bakeLayer(ROYAL_HUNTER_ARMOR_LAYER));


    }
}
