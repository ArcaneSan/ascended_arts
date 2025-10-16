package net.arcane.ascended_arts.entity.client.armor;

import net.arcane.ascended_arts.Ascended_arts;
import net.arcane.ascended_arts.Util.IDyeable;
import net.arcane.ascended_arts.entity.client.ClientRegistry;
import net.arcane.ascended_arts.entity.client.model.ArmoredRobeModel;
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

public class GoldHanfuArmorItem extends ArmorItem implements IDyeable {
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    public static class Material implements ArmorMaterial {

        @Override
        public int getDurabilityForType(Type slot) {
            return MAX_DAMAGE_ARRAY[slot.getSlot().getIndex()] * 15;
        }

        @Override
        public int getDefenseForType(Type slot) {
            return switch (slot) {
                case CHESTPLATE -> 5;
                case HELMET, BOOTS -> 2;
                case LEGGINGS -> 3;
            };
        }

        @Override
        public int getEnchantmentValue() {
            return 35;
        }

        @Override
        public @NotNull SoundEvent getEquipSound() {
            return ArmorMaterials.GOLD.getEquipSound();
        }

        @Override
        public @NotNull Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(Items.GOLD_INGOT));
        }

        @Override
        public @NotNull String getName() {
            return Ascended_arts.MOD_ID + ":armored_robes";
        }

        @Override
        public float getToughness() {
            return 1;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }

        public static final GoldHanfuArmorItem.Material INSTANCE = new GoldHanfuArmorItem.Material();
    }

    public GoldHanfuArmorItem(Type slot, Properties builderIn) {
        super(GoldHanfuArmorItem.Material.INSTANCE, slot, builderIn);
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
            public @NotNull ArmoredRobeModel getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel _default) {
                float pticks = Minecraft.getInstance().getFrameTime();
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
        var tag = stack.getOrCreateTag();
        return tag.contains("color") ? DyeColor.byId(tag.getInt("color")) : DyeColor.WHITE;
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        DyeColor dyeColor = getColor(stack);
        return Ascended_arts.MOD_ID + ":textures/entity/armored_robes/gold/" + dyeColor.getName() + ".png";
    }
}
