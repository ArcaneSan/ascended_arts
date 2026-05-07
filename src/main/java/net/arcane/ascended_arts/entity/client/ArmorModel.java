package net.arcane.ascended_arts.entity.client;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.world.entity.EquipmentSlot.*;
import static net.minecraft.world.entity.EquipmentSlot.FEET;

public abstract class ArmorModel extends HumanoidModel<LivingEntity> {

    public EquipmentSlot slot;
    final ModelPart root;
    final ModelPart head;
    final ModelPart body;
    final ModelPart leftArm;
    final ModelPart rightArm;
    final ModelPart leggings;
    final ModelPart leftLegging;
    final ModelPart rightLegging;
    final ModelPart leftFoot;
    final ModelPart rightFoot;

    public ArmorModel(ModelPart root) {
        super(root);
        this.root = root;
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leggings = root.getChild("leggings");
        this.leftArm = root.getChild("left_arm");
        this.rightArm = root.getChild("right_arm");
        this.leftLegging = root.getChild("left_legging");
        this.rightLegging = root.getChild("right_legging");
        this.leftFoot = root.getChild("left_foot");
        this.rightFoot = root.getChild("right_foot");
    }

    public static PartDefinition createHumanoidAlias(MeshDefinition mesh) {
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("body", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("leggings", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("head", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("left_legging", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("left_foot", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("right_legging", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("right_foot", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("left_arm", new CubeListBuilder(), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", new CubeListBuilder(), PartPose.ZERO);

        return root;
    }

    @Override
    protected @NotNull Iterable<ModelPart> headParts() {
        return slot == HEAD ? ImmutableList.of(head) : ImmutableList.of();
    }

    @Override
    protected @NotNull Iterable<ModelPart> bodyParts() {
        if (slot == CHEST) {
            return ImmutableList.of(body, leftArm, rightArm);
        } else if (slot == LEGS) {
            return ImmutableList.of(leftLegging, rightLegging, leggings);
        } else if (slot == FEET) {
            return ImmutableList.of(leftFoot, rightFoot);
        } else return ImmutableList.of();
    }



    public void copyFromDefault(HumanoidModel<?> model) {
        body.copyFrom(model.body);
        leggings.copyFrom(model.body);
        leftLegging.copyFrom(model.leftLeg);
        rightLegging.copyFrom(model.rightLeg);
        leftFoot.copyFrom(model.leftLeg);
        rightFoot.copyFrom(model.rightLeg);
    }

    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}