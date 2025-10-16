package net.arcane.ascended_arts.Util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryUtil {
    public static ResourceLocation getRegistryName(Item item) {
        return ForgeRegistries.ITEMS.getRegistryName();
    }
}
