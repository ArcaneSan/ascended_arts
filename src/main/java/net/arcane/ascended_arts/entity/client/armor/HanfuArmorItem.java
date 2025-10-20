package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.Util.IDyeable;
import net.arcane.ascended_arts.entity.client.ClientRegistry;
import net.arcane.ascended_arts.entity.client.model.RobeModel;
import net.arcane.ascended_arts.world.item.AscendedAddonItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class HanfuArmorItem extends ArmorItem implements IDyeable {
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{14, 16, 17, 12};

    public static class Material implements ArmorMaterial {

        @Override
        public int getDurabilityForType(Type slot) {
            return MAX_DAMAGE_ARRAY[slot.getSlot().getIndex()] * 21;
        }

        @Override
        public int getDefenseForType(Type slot) {
            return switch (slot) {
                case CHESTPLATE -> 3;
                case HELMET -> 1;
                case LEGGINGS -> 2;
                case BOOTS -> 1;
            };
        }

        @Override
        public int getEnchantmentValue() {
            return 20;
        }

        @Override
        public @NotNull SoundEvent getEquipSound() {
            return ArmorMaterials.LEATHER.getEquipSound();
        }

        @Override
        public @NotNull Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(AscendedAddonItems.CLOTH.get()));
        }

        @Override
        public @NotNull String getName() {
            return Ascended_arts.MOD_ID + ":unarmored_robes";
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }

        public static final HanfuArmorItem.Material INSTANCE = new HanfuArmorItem.Material();
    }

    public HanfuArmorItem(Type slot, Properties builderIn) {
        super(HanfuArmorItem.Material.INSTANCE, slot, builderIn);
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack pStack) {
        var og = super.getName(pStack);
        if (!(pStack.hasTag() && pStack.getTag().contains("color"))) return og;
        return Component.literal(og.getString() + " (" + Component.translatable(getColor(pStack).getName()).getString() + ")");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @NotNull RobeModel getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel _default) {
                float pticks = Minecraft.getInstance().getFrameTime();
                float f = Mth.rotLerp(pticks, entity.yBodyRotO, entity.yBodyRot);
                float f1 = Mth.rotLerp(pticks, entity.yHeadRotO, entity.yHeadRot);
                float netHeadYaw = f1 - f;
                float netHeadPitch = Mth.lerp(pticks, entity.xRotO, entity.getXRot());
                ClientRegistry.ROBE_MODEL.slot = getEquipmentSlot();
                ClientRegistry.ROBE_MODEL.copyFromDefault(_default);
                ClientRegistry.ROBE_MODEL.setupAnim(entity, entity.walkAnimation.position(), entity.walkAnimation.speed(), entity.tickCount + pticks, netHeadYaw, netHeadPitch);
                return ClientRegistry.ROBE_MODEL;

            }

        });
    }

    private DyeColor getColor(ItemStack stack) {
        var tag = stack.getOrCreateTag();
        return tag.contains("color") ? DyeColor.byId(tag.getInt("color")) : DyeColor.WHITE;
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        DyeColor dyeColor = getColor(stack);
        return Ascended_arts.MOD_ID + ":textures/entity/unarmored_robes/" + dyeColor.getName() + ".png";
    }




}