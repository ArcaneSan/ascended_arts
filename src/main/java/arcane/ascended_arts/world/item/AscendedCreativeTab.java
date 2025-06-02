package arcane.ascended_arts.world.item;

import arcane.ascended_arts.Ascended_arts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AscendedCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ascended_arts.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Ascended_Arts_Tab = CREATIVE_MODE_TABS.register("ascended_arts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AscendAddontems.Iron_Jian.get()))
                    .title(Component.translatable("creativetab.ascended_arts_tab"))
                    .displayItems(((itemDisplayParameters, output) ->
                    {
                        output.accept(AscendAddontems.Iron_Jian.get());
                        output.accept(AscendAddontems.Greatsword.get());
                        output.accept(AscendAddontems.Scythe.get());
                        output.accept(AscendAddontems.Diamond_Jian.get());
                        output.accept(AscendAddontems.Golden_Jian.get());
                        output.accept(AscendAddontems.Wooden_Jian.get());
                        output.accept(AscendAddontems.Netherite_Jian.get());

                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
