package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.Util.AscendedMaterials;
import net.arcane.ascended_arts.Util.IDyeable;
import net.arcane.ascended_arts.entity.client.ClientRegistry;
import net.arcane.ascended_arts.entity.client.model.ArmoredRobeModel;
import net.arcane.ascended_arts.entity.client.model.RoyalHunterArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class RoyalHunterArmorItem extends ArmorItem implements IDyeable {
    public RoyalHunterArmorItem(Type slot, Properties builderIn) {
        super(AscendedMaterials.ROYAL_HUNTER, slot, builderIn.stacksTo(1).durability(slot.getDurability(45))
                .component(DataComponents.BASE_COLOR, DyeColor.GREEN));
    }
    @Override
    public @NotNull Component getName(@NotNull ItemStack pStack) {
        var og = super.getName(pStack);
        if (getColor(pStack) == DyeColor.GREEN) return og;
        return Component.literal(og.getString() + " (" + Component.translatable(getColor(pStack).getName()).getString() + ")");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            public @NotNull RoyalHunterArmorModel getHumanoidedArmorModel(@NotNull LivingEntity entity,
                                                                     @NotNull ItemStack itemStack,
                                                                     @NotNull EquipmentSlot armorSlot,
                                                                     @NotNull HumanoidModel _default){
                float pticks = Minecraft.getInstance().getFrameTimeNs();
                float f = Mth.rotLerp(pticks, entity.yBodyRotO, entity.yBodyRot);
                float f1 = Mth.rotLerp(pticks, entity.yHeadRotO, entity.yHeadRot);
                float netHeadYaw = f1 - f;
                float netHeadPitch = Mth.lerp(pticks, entity.xRotO, entity.getXRot());
                ClientRegistry.ROYAL_HUNTER_ARMOR_MODEL.slot = getEquipmentSlot();
                ClientRegistry.ROYAL_HUNTER_ARMOR_MODEL.copyFromDefault(_default);
                ClientRegistry.ROYAL_HUNTER_ARMOR_MODEL.setupAnim(entity, entity.walkAnimation.position(), entity.walkAnimation.speed(), entity.tickCount + pticks, netHeadYaw, netHeadPitch);
                return ClientRegistry.ROYAL_HUNTER_ARMOR_MODEL;

            }
        });
    }


    private DyeColor getColor(ItemStack stack) {
        return stack.getOrDefault(DataComponents.BASE_COLOR,DyeColor.GREEN);
    }


    @Override
    public @Nullable ResourceLocation getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity,
                                                      @NotNull EquipmentSlot slot,
                                                      ArmorMaterial.@NotNull Layer layer, boolean innerModel) {
        DyeColor dyeColor = getColor(stack);
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "textures/entity/royal_hunter_armor/" + dyeColor.getName() + ".png");
    }
}
