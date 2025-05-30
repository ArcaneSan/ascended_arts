package arcane.ascended_arts.world.item;

import arcane.ascended_arts.Ascended_arts;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AscendAddontems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Ascended_arts.MOD_ID);

    public static final RegistryObject<Item> Iron_Saber =
            ITEMS.register("iron_saber", () -> new AscendItem(new Item.Properties(), Tiers.IRON));
    public static final RegistryObject<Item> Greatsword =
            ITEMS.register("greatsword", () -> new AscendLargeItem(new Item.Properties(), Tiers.NETHERITE));
    public static final RegistryObject<Item> Scythe =
            ITEMS.register("scythe", () -> new AscendLargeItem(new Item.Properties(), Tiers.NETHERITE));

    public  static  void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
