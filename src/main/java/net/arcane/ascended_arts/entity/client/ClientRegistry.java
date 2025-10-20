package net.arcane.ascended_arts.entity.client;


import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.entity.client.model.ArmoredRobeModel;
import net.arcane.ascended_arts.entity.client.model.RobeModel;
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

    public static RobeModel ROBE_MODEL = null;
    public static ArmoredRobeModel ARMORED_ROBE_MODEL = null;

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ARMORED_ROBE_LAYER, ArmoredRobeModel::createBodyLayer);
        event.registerLayerDefinition(ROBE_LAYER, RobeModel::createBodyLayer);


    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.AddLayers event) {
        ARMORED_ROBE_MODEL = new ArmoredRobeModel(event.getEntityModels().bakeLayer(ARMORED_ROBE_LAYER));
        ROBE_MODEL = new RobeModel(event.getEntityModels().bakeLayer(ROBE_LAYER));


    }
}
