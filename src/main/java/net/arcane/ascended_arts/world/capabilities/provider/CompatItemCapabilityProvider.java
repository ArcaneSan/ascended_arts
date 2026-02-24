package net.arcane.ascended_arts.world.capabilities.provider;

import com.google.common.collect.Maps;
import net.arcane.ascended_arts.world.capabilities.item.FluteCapability;
import net.mehvahdjukaar.supplementaries.common.items.FluteItem;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.ItemKeywordReloadListener;
import yesman.epicfight.world.capabilities.item.TagBasedSeparativeCapability;
import yesman.epicfight.world.capabilities.item.WeaponTypeReloadListener;

import java.util.Map;
import java.util.function.Function;

public class CompatItemCapabilityProvider implements ICapabilityProvider, NonNullSupplier<CapabilityItem> {
    private static final Map<Class<? extends Item>, Function<Item, CapabilityItem.Builder>> CAPABILITY_BY_CLASS = Maps.newHashMap();
    private static final Map<Item, CapabilityItem> CAPABILITIES = Maps.newHashMap();

    public static void registerWeaponTypesByClass() {

        if (ModList.get().isLoaded("supplementaries")){
            CAPABILITY_BY_CLASS.put(FluteItem.class, (item) -> FluteCapability.builder());
            }
    }
    public static void put(Item item, CapabilityItem cap) {
        CAPABILITIES.put(item, cap);
    }

    public static CapabilityItem get(Item item) {
        return CAPABILITIES.getOrDefault(item, CAPABILITY_BY_CLASS.containsKey(item.getClass()) ? CAPABILITY_BY_CLASS.get(item.getClass()).apply(item).build() : null);
    }

    public static void clear() {
        CAPABILITIES.clear();
    }

    public static void addDefaultItems() {
        ForgeRegistries.ITEMS.getEntries().stream().filter(entry -> !CAPABILITIES.containsKey(entry.getValue())).forEach(entry -> {
            Function<Item, CapabilityItem.Builder> type = null;
            Item item = entry.getValue();

            if (item instanceof BlockItem) {
                return;
            }

            for (Map.Entry<ResourceLocation, ItemKeywordReloadListener.ItemRegex> regexEntry : ItemKeywordReloadListener.getRegexes().entrySet()) {
                if (regexEntry.getValue().matchesAny(entry.getKey().location().toString())) {
                    type = WeaponTypeReloadListener.get(regexEntry.getKey());

                    if (type != null) {
                        CAPABILITIES.put(item, type.apply(item).build());
                        break;
                    }
                }
            }

            if (type == null) {
                Class<?> clazz = item.getClass();
                CapabilityItem capability = null;

                for (; clazz != null && capability == null; clazz = clazz.getSuperclass()) {
                    if (CAPABILITY_BY_CLASS.containsKey(clazz)) {
                        capability = CAPABILITY_BY_CLASS.get(clazz).apply(item).build();
                    }
                }

                if (capability != null) {
                    CAPABILITIES.put(item, capability);
                }
            }
        });
    }

    private CapabilityItem capability;
    private final LazyOptional<CapabilityItem> optional = LazyOptional.of(this);

    public CompatItemCapabilityProvider(ItemStack itemstack) {
        this.capability = CAPABILITIES.get(itemstack.getItem());

        if (this.capability instanceof TagBasedSeparativeCapability) {
            this.capability = this.capability.getResult(itemstack);
        }
    }

    public boolean hasCapability() {
        return this.capability != null;
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
        return cap == EpicFightCapabilities.CAPABILITY_ITEM ? this.optional.cast() : LazyOptional.empty();
    }

    @Override
    public CapabilityItem get() {
        return this.capability;
    }
}
