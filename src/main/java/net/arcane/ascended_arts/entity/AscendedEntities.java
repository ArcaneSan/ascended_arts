package net.arcane.ascended_arts.entity;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


import static net.arcane.ascended_arts.world.item.AscendedAddonItems.register;

public class AscendedEntities {
    public static final DeferredRegister<EntityDataSerializer<?>> ENTITIES = DeferredRegister.create(NeoForgeRegistries.ENTITY_DATA_SERIALIZERS, Ascended_arts.MOD_ID);


}
