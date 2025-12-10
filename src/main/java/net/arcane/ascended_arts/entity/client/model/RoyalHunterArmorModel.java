package net.arcane.ascended_arts.entity.client.model;

import net.arcane.ascended_arts.entity.client.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class RoyalHunterArmorModel extends ArmorModel {
    public RoyalHunterArmorModel(ModelPart root) {
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
        PartDefinition Mask = root.getChild("head");
        PartDefinition left_leg = root.getChild("left_legging");
        PartDefinition right_leg = root.getChild("right_legging");
        PartDefinition waists = root.getChild("leggings");

        PartDefinition Head = Mask.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition headleaf_r1 = Head.addOrReplaceChild("headleaf_r1", CubeListBuilder.create().texOffs(59, 89).mirror().addBox(-0.1F, -2.125F, -0.8F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.7233F, -3.4567F, -1.795F, 0.5303F, 0.151F, 0.0879F));

        PartDefinition mask_r1 = Head.addOrReplaceChild("mask_r1", CubeListBuilder.create().texOffs(23, 13).addBox(-4.5F, -4.0F, -0.25F, 5.0F, 10.0F, 0.501F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4454F, -4.6968F, -5.0195F, 0.0F, 0.1745F, 0.0F));

        PartDefinition mask_r2 = Head.addOrReplaceChild("mask_r2", CubeListBuilder.create().texOffs(106, 16).addBox(-1.5F, -0.5F, -0.3005F, 3.0F, 1.0F, 0.601F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5733F, -3.9633F, -4.6871F, 0.0986F, 0.1592F, 0.216F));

        PartDefinition mask_r3 = Head.addOrReplaceChild("mask_r3", CubeListBuilder.create().texOffs(113, 16).addBox(-1.5F, -0.5F, -0.3005F, 3.0F, 1.0F, 0.601F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5733F, -3.9633F, -4.6871F, 0.0986F, -0.1592F, -0.216F));

        PartDefinition mask_r4 = Head.addOrReplaceChild("mask_r4", CubeListBuilder.create().texOffs(5, 13).addBox(-0.5F, -4.0F, -0.25F, 5.0F, 10.0F, 0.501F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4454F, -4.6968F, -5.0195F, 0.0F, -0.1745F, 0.0F));

        PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(10, 109).addBox(-2.2F, 8.8F, -3.52F, 4.4F, 2.5F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(3, 40).addBox(-4.5F, 0.0F, -3.0F, 9.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition shirt_r1 = Body.addOrReplaceChild("shirt_r1", CubeListBuilder.create().texOffs(81, 76).addBox(-0.6971F, -3.3929F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1671F, 2.3329F, -2.1F, 0.0F, 0.0F, -0.7854F));

        PartDefinition shirt_r2 = Body.addOrReplaceChild("shirt_r2", CubeListBuilder.create().texOffs(81, 76).addBox(-0.5F, -1.25F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.65F, 1.0F, -2.1F, 0.0F, 0.0F, 0.7854F));

        PartDefinition coat_r1 = Body.addOrReplaceChild("coat_r1", CubeListBuilder.create().texOffs(40, 31).addBox(-4.7F, -4.55F, -0.5F, 9.0F, 4.7677F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 17.5677F, 3.2977F, 0.1745F, 0.0F, 0.0F));

        PartDefinition coat_r2 = Body.addOrReplaceChild("coat_r2", CubeListBuilder.create().texOffs(41, 23).addBox(-4.7F, 0.0177F, -0.5F, 9.0F, 4.5323F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 17.8287F, 3.3457F, 0.3054F, 0.0F, 0.0F));

        PartDefinition coat_r3 = Body.addOrReplaceChild("coat_r3", CubeListBuilder.create().texOffs(66, 33).addBox(-1.9F, -6.4F, -0.7F, 3.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4822F, 6.4F, -3.1686F, 0.0F, 0.4363F, 0.0F));

        PartDefinition coat_r4 = Body.addOrReplaceChild("coat_r4", CubeListBuilder.create().texOffs(80, 33).addBox(-1.6F, -6.4F, -0.7F, 3.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9353F, 6.4F, -2.9573F, 0.0F, -0.4363F, 0.0F));

        PartDefinition hood_r1 = Body.addOrReplaceChild("hood_r1", CubeListBuilder.create().texOffs(94, 3).addBox(-5.98F, -0.5028F, -2.1358F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 1.5F, 2.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition hood_r2 = Body.addOrReplaceChild("hood_r2", CubeListBuilder.create().texOffs(93, 2).addBox(-5.98F, -0.5028F, -2.1359F, 9.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -0.3F, 1.9F, -0.2182F, 0.0F, 0.0F));
        PartDefinition RightArm = right_arm.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(4, 66).addBox(-3.7F, -2.1F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(3, 92).mirror().addBox(-3.75F, 4.65F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition shoulder_r1 = RightArm.addOrReplaceChild("shoulder_r1", CubeListBuilder.create().texOffs(53, 62).addBox(-2.5F, -2.5F, -3.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -0.2F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition rightarmleaf_r1 = RightArm.addOrReplaceChild("rightarmleaf_r1", CubeListBuilder.create().texOffs(59, 89).mirror().addBox(0.1F, -2.125F, -0.8F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.9767F, 9.4433F, -0.795F, 0.7418F, 0.0F, 0.0F));

        PartDefinition LeftArm = left_arm.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(28, 92).addBox(-1.75F, 4.65F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F))
                .texOffs(51, 77).addBox(-1.8F, -3.0F, -2.9F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(41, 6).mirror().addBox(-1.3F, -2.1F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LeftBoot = left_foot.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(66, 22).addBox(-2.3F, 9.1F, -2.5F, 4.8F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(90, 47).addBox(-2.3F, 10.1F, -3.5F, 4.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.05F, 0.0F));

        PartDefinition leftbootleaf_r1 = LeftBoot.addOrReplaceChild("leftbootleaf_r1", CubeListBuilder.create().texOffs(65, 100).mirror().addBox(-0.1F, -1.625F, -1.55F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2115F, 9.3742F, 1.4902F, -1.0893F, 0.0774F, 0.0404F));

        PartDefinition LeftLeg = left_leg.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(29, 67).mirror().addBox(-2.4F, -0.1F, -2.4F, 5.0F, 4.7F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.05F, 0.0F));

        PartDefinition leftleg_r1 = LeftLeg.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(63, 5).addBox(-0.5F, -2.7F, -0.2F, 1.0F, 5.4F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, 1.9F, -2.9F, 0.0F, 0.0F, -0.48F));

        PartDefinition RightBoot = right_foot.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(65, 50).mirror().addBox(-2.5F, 9.1F, -2.5F, 4.8F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(94, 22).mirror().addBox(-2.5F, 10.1F, -3.5F, 4.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.05F, 0.0F));

        PartDefinition leftbootleaf_r2 = RightBoot.addOrReplaceChild("leftbootleaf_r2", CubeListBuilder.create().texOffs(65, 100).mirror().addBox(0.1F, -1.625F, -1.55F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9885F, 9.3742F, 1.4902F, -1.0904F, -0.0387F, -0.0202F));

        PartDefinition RightLeg = right_leg.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(29, 67).addBox(-2.6F, -0.1F, -2.4F, 5.0F, 4.7F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.05F, 0.0F));

        PartDefinition rightleg_r1 = RightLeg.addOrReplaceChild("rightleg_r1", CubeListBuilder.create().texOffs(63, 5).mirror().addBox(-0.5F, -2.7F, -0.2F, 1.0F, 5.4F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6F, 1.9F, -2.9F, 0.0F, 0.0F, 0.48F));

        PartDefinition waist = waists.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(87, 54).addBox(-4.35F, 8.0F, -2.25F, 8.7F, 4.25F, 4.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 128, 128);
    }
    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
