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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AscendedAddonItems.IRON_JIAN.get()))
                    .title(Component.translatable("creativetab.ascended_arts_tab"))
                    .displayItems(((itemDisplayParameters, output) ->
                    {
                        output.accept(AscendedAddonItems.WOODEN_JIAN.get());
                        output.accept(AscendedAddonItems.GOLDEN_JIAN.get());
                        output.accept(AscendedAddonItems.IRON_JIAN.get());
                        output.accept(AscendedAddonItems.DIAMOND_JIAN.get());
                        output.accept(AscendedAddonItems.NETHERITE_JIAN.get());
                        output.accept(AscendedAddonItems.SMALL_WOODEN_SCYTHE.get());
                        output.accept(AscendedAddonItems.SMALL_IRON_SCYTHE.get());
                        output.accept(AscendedAddonItems.SMALL_GOLDEN_SCYTHE.get());
                        output.accept(AscendedAddonItems.SMALL_DIAMOND_SCYTHE.get());
                        output.accept(AscendedAddonItems.SMALL_NETHERITE_SCYTHE.get());

                        output.accept(AscendedAddonItems.GREATSWORD.get());
                        output.accept(AscendedAddonItems.ETHERVEIL_SCYTHE.get());
                        output.accept(AscendedAddonItems.SKYSPLITTER_JIAN.get());

                        output.accept(AscendedAddonItems.ROYAL_HUNTER_MASK.get());
                        output.accept(AscendedAddonItems.ROYAL_HUNTER_ROBE.get());
                        output.accept(AscendedAddonItems.ROYAL_HUNTER_LEGGINGS.get());
                        output.accept(AscendedAddonItems.ROYAL_HUNTER_BOOTS.get());

                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
