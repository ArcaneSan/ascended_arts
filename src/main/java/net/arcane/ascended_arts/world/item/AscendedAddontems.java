package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AscendedAddontems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Ascended_arts.MOD_ID);

    public static final RegistryObject<Item> IRON_JIAN =
            ITEMS.register("iron_jian", () -> new AscendedItem(new Item.Properties(), Tiers.IRON));
    public static final RegistryObject<Item> GREATSWORD =
            ITEMS.register("greatsword", () -> new AscendLargeItem(new Item.Properties().rarity(Rarity.RARE), Tiers.NETHERITE));
    public static final RegistryObject<Item> SCYTHE =
            ITEMS.register("scythe", () -> new AscendLargeItem(new Item.Properties(), Tiers.NETHERITE));
    public static final RegistryObject<Item> DIAMOND_JIAN =
            ITEMS.register("diamond_jian", () -> new AscendedItem(new Item.Properties(), Tiers.DIAMOND));
    public static final RegistryObject<Item> NETHERITE_JIAN =
            ITEMS.register("netherite_jian", () -> new AscendedItem(new Item.Properties().fireResistant(), Tiers.NETHERITE));
    public static final RegistryObject<Item> GOLDEN_JIAN =
            ITEMS.register("golden_jian", () -> new AscendedItem(new Item.Properties(), Tiers.GOLD));
    public static final RegistryObject<Item> WOODEN_JIAN =
            ITEMS.register("wooden_jian", () -> new AscendedItem(new Item.Properties(), Tiers.WOOD));

    public  static  void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
