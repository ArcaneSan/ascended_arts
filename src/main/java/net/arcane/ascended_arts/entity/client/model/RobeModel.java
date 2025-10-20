package net.arcane.ascended_arts.entity.client.model;

import net.arcane.ascended_arts.entity.client.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;


public class RobeModel extends ArmorModel {
    public RobeModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(new CubeDeformation(0), 0);
        PartDefinition root = createHumanoidAlias(mesh);

        PartDefinition Chest = root.getChild("body");
        PartDefinition right_foot = root.getChild("right_foot");
        PartDefinition left_foot = root.getChild("left_foot");
        PartDefinition left_arm = root.getChild("left_arm");
        PartDefinition right_arm = root.getChild("right_arm");
        PartDefinition Hood = root.getChild("head");
        PartDefinition left_leg = root.getChild("left_legging");
        PartDefinition right_leg = root.getChild("right_legging");

        PartDefinition Head = Hood.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(4, 5).addBox(-4.5F, -8.75F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(4, 42).addBox(-4.75F, -0.5F, -2.3F, 9.5F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition robe_r1 = Body.addOrReplaceChild("robe_r1", CubeListBuilder.create().texOffs(66, 31).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 1.0F, -2.3F, 0.0F, -1.2654F, 0.0F));

        PartDefinition robe_r2 = Body.addOrReplaceChild("robe_r2", CubeListBuilder.create().texOffs(77, 31).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 1.0F, -2.3F, 0.0F, 1.2654F, 0.0F));

        PartDefinition robe_r3 = Body.addOrReplaceChild("robe_r3", CubeListBuilder.create().texOffs(41, 23).addBox(-4.75F, -2.5F, -0.5F, 9.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.4457F, 4.9251F, 0.5672F, 0.0F, 0.0F));

        PartDefinition robe_r4 = Body.addOrReplaceChild("robe_r4", CubeListBuilder.create().texOffs(40, 31).addBox(-4.75F, 0.0F, 1.5F, 9.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.4518F, 0.3157F, 0.3054F, 0.0F, 0.0F));

        PartDefinition RightArm = right_arm.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(4, 64).addBox(1.5F, -2.25F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.75F, -0.75F, 0.0F));

        PartDefinition LeftLeg = left_leg.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(29, 65).addBox(-2.25F, -0.1F, -2.5F, 4.75F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(90, 27).addBox(1.884F, 0.7321F, -2.05F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(98, 25).addBox(2.134F, 0.7321F, -2.05F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LeftArm = left_arm.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(41, 5).addBox(-6.5F, -2.25F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -0.75F, 0.0F));

        PartDefinition LeftBoot = left_foot.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(64, 49).addBox(-2.35F, 9.15F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(94, 22).addBox(-2.35F, 10.15F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition RightLeg = right_leg.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(62, 5).addBox(-2.5F, -0.1F, -2.5F, 4.75F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(90, 35).mirror().addBox(-2.884F, 0.7321F, -2.05F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(99, 32).mirror().addBox(-3.134F, 0.7321F, -2.05F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition RightBoot = right_foot.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(90, 47).addBox(-2.7F, 10.15F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 21).addBox(-2.7F, 9.15F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 128, 128);
    }

}
