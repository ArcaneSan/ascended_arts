package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.Util.AscendedMaterials;
import net.arcane.ascended_arts.Util.IDyeable;
import net.arcane.ascended_arts.entity.client.ClientRegistry;
import net.arcane.ascended_arts.entity.client.model.ArmoredRobeModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.util.function.Consumer;

public class DiamondHanfuArmorItem extends ArmorItem implements IDyeable {

    public DiamondHanfuArmorItem(Type slot, Properties builderIn) {
        super(AscendedMaterials.DIAMOND_HANFU, slot, builderIn.stacksTo(1).durability(slot.getDurability(43))
                .component(DataComponents.BASE_COLOR, DyeColor.WHITE));
    }
    @Override
    public @NotNull Component getName(@NotNull ItemStack pStack) {
        var og = super.getName(pStack);
        if (getColor(pStack) == DyeColor.WHITE) return og;
        return Component.literal(og.getString() + " (" + Component.translatable(getColor(pStack).getName()).getString() + ")");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @NotNull ArmoredRobeModel getHumanoidArmorModel(@NotNull LivingEntity entity, @NotNull ItemStack itemStack, @NotNull EquipmentSlot armorSlot, @NotNull HumanoidModel _default) {
                float pticks = Minecraft.getInstance().getFrameTimeNs();
                float f = Mth.rotLerp(pticks, entity.yBodyRotO, entity.yBodyRot);
                float f1 = Mth.rotLerp(pticks, entity.yHeadRotO, entity.yHeadRot);
                float netHeadYaw = f1 - f;
                float netHeadPitch = Mth.lerp(pticks, entity.xRotO, entity.getXRot());
                ClientRegistry.ARMORED_ROBE_MODEL.slot = getEquipmentSlot();
                ClientRegistry.ARMORED_ROBE_MODEL.copyFromDefault(_default);
                ClientRegistry.ARMORED_ROBE_MODEL.setupAnim(entity, entity.walkAnimation.position(), entity.walkAnimation.speed(), entity.tickCount + pticks, netHeadYaw, netHeadPitch);
                return ClientRegistry.ARMORED_ROBE_MODEL;
            }
        });
    }

    private DyeColor getColor(ItemStack stack) {
        return stack.getOrDefault(DataComponents.BASE_COLOR,DyeColor.WHITE);
    }


    @Override
    public @Nullable ResourceLocation getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity,
                                                      @NotNull EquipmentSlot slot,
                                                      ArmorMaterial.@NotNull Layer layer, boolean innerModel) {
        DyeColor dyeColor = getColor(stack);
        return ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "textures/entity/armored_robes/diamond/" + dyeColor.getName() + ".png");
    }
}