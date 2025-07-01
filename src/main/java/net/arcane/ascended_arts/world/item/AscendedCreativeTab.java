package net.arcane.ascended_arts.world.item;

import net.arcane.ascended_arts.Ascended_arts;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AscendedAddontems.IRON_JIAN.get()))
                    .title(Component.translatable("creativetab.ascended_arts_tab"))
                    .displayItems(((itemDisplayParameters, output) ->
                    {
                        output.accept(AscendedAddontems.WOODEN_JIAN.get());
                        output.accept(AscendedAddontems.GOLDEN_JIAN.get());
                        output.accept(AscendedAddontems.IRON_JIAN.get());
                        output.accept(AscendedAddontems.DIAMOND_JIAN.get());
                        output.accept(AscendedAddontems.NETHERITE_JIAN.get());

                        output.accept(AscendedAddontems.GREATSWORD.get());
                        output.accept(AscendedAddontems.ETHERVEIL_SCYTHE.get());
                        output.accept(AscendedAddontems.ASCENDED_JIAN.get());

                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
