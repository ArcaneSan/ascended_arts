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

        PartDefinition armorHead = Mask.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(4, 5).addBox(-4.5F, -8.75F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition mask_r1 = armorHead.addOrReplaceChild("mask_r1", CubeListBuilder.create().texOffs(113, 16).addBox(-1.5F, -0.5F, -0.3005F, 3.0F, 1.0F, 0.601F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5733F, -3.9633F, -4.6871F, 0.0986F, -0.1592F, -0.216F));

        PartDefinition mask_r2 = armorHead.addOrReplaceChild("mask_r2", CubeListBuilder.create().texOffs(106, 16).addBox(-1.5F, -0.5F, -0.3005F, 3.0F, 1.0F, 0.601F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5733F, -3.9633F, -4.6871F, 0.0986F, 0.1592F, 0.216F));

        PartDefinition mask_r3 = armorHead.addOrReplaceChild("mask_r3", CubeListBuilder.create().texOffs(114, 30).addBox(-4.5F, -4.0F, -0.25F, 5.0F, 10.0F, 0.501F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4454F, -4.6968F, -5.0195F, 0.0F, 0.1745F, 0.0F));

        PartDefinition mask_r4 = armorHead.addOrReplaceChild("mask_r4", CubeListBuilder.create().texOffs(96, 30).addBox(-0.5F, -4.0F, -0.25F, 5.0F, 10.0F, 0.501F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4454F, -4.6968F, -5.0195F, 0.0F, -0.1745F, 0.0F));

        PartDefinition headleaf_r1 = armorHead.addOrReplaceChild("headleaf_r1", CubeListBuilder.create().texOffs(59, 89).mirror().addBox(-0.1F, -2.125F, -0.8F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.7233F, -3.4567F, -1.795F, 0.5303F, 0.151F, 0.0879F));

        PartDefinition waist = waists.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(87, 54).addBox(-4.35F, 8.0F, -2.25F, 8.7F, 4.25F, 4.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition armorBody = Chest.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(4, 42).addBox(-4.75F, -0.5F, -2.3F, 9.5F, 13.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(11, 110).addBox(-2.2F, 8.8F, -2.92F, 4.4F, 2.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hood_r1 = armorBody.addOrReplaceChild("hood_r1", CubeListBuilder.create().texOffs(93, 2).addBox(-5.98F, -0.5028F, -2.1359F, 9.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -0.3F, 1.9F, -0.2182F, 0.0F, 0.0F));

        PartDefinition hood_r2 = armorBody.addOrReplaceChild("hood_r2", CubeListBuilder.create().texOffs(94, 3).addBox(-5.98F, -0.5028F, -2.1359F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 1.5F, 2.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition shirt_r1 = armorBody.addOrReplaceChild("shirt_r1", CubeListBuilder.create().texOffs(81, 76).addBox(-0.6971F, -3.3929F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1671F, 2.3329F, -1.7F, 0.0F, 0.0F, -0.7854F));

        PartDefinition shirt_r2 = armorBody.addOrReplaceChild("shirt_r2", CubeListBuilder.create().texOffs(81, 76).addBox(-0.5F, -1.25F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.65F, 1.0F, -1.7F, 0.0F, 0.0F, 0.7854F));

        PartDefinition robe_r1 = armorBody.addOrReplaceChild("robe_r1", CubeListBuilder.create().texOffs(66, 31).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 1.0F, -2.3F, 0.0F, -1.2654F, 0.0F));

        PartDefinition robe_r2 = armorBody.addOrReplaceChild("robe_r2", CubeListBuilder.create().texOffs(77, 31).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 1.0F, -2.3F, 0.0F, 1.2654F, 0.0F));

        PartDefinition robe_r3 = armorBody.addOrReplaceChild("robe_r3", CubeListBuilder.create().texOffs(41, 23).addBox(-4.75F, -2.5F, -0.5F, 9.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.4457F, 4.9251F, 0.5672F, 0.0F, 0.0F));

        PartDefinition robe_r4 = armorBody.addOrReplaceChild("robe_r4", CubeListBuilder.create().texOffs(40, 31).addBox(-4.75F, 0.0F, 1.5F, 9.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.4518F, 0.3157F, 0.3054F, 0.0F, 0.0F));

        PartDefinition armorRightArm = right_arm.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(4, 64).addBox(-3.5F, -2.25F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(3, 92).mirror().addBox(-3.75F, 4.65F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.25F, 0.0F, 0.0F));

        PartDefinition rightarmleaf_r1 = armorRightArm.addOrReplaceChild("rightarmleaf_r1", CubeListBuilder.create().texOffs(59, 89).mirror().addBox(0.0553F, -1.4182F, 0.2057F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.9385F, -1.017F, -0.4266F, 0.413F, -0.0517F, 0.2761F));

        PartDefinition rightarmleaf_r2 = armorRightArm.addOrReplaceChild("rightarmleaf_r2", CubeListBuilder.create().texOffs(59, 89).mirror().addBox(0.0545F, -1.4598F, 0.0368F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.9385F, -1.017F, -0.4266F, 1.067F, -0.0197F, 0.2901F));

        PartDefinition rightarmleaf_r3 = armorRightArm.addOrReplaceChild("rightarmleaf_r3", CubeListBuilder.create().texOffs(59, 89).mirror().addBox(0.0596F, -1.5528F, -0.0518F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.9385F, -1.017F, -0.4266F, 1.5466F, -0.0028F, 0.3207F));

        PartDefinition shoulder_r1 = armorRightArm.addOrReplaceChild("shoulder_r1", CubeListBuilder.create().texOffs(54, 63).addBox(-2.5F, -2.5F, -3.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -0.2F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition armorLeftLeg = left_leg.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(29, 65).addBox(-2.25F, -0.1F, -2.5F, 4.75F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftleg_r1 = armorLeftLeg.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(109, 67).addBox(-0.5F, -2.7F, -0.2F, 1.0F, 5.4F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, 1.9F, -3.15F, 0.0F, 0.0F, -0.48F));

        PartDefinition armorLeftArm = left_arm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(41, 5).addBox(-1.5F, -2.25F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(28, 92).addBox(-1.75F, 4.65F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F))
                .texOffs(51, 77).addBox(-1.8F, -3.0F, -2.9F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 0.0F, 0.0F));

        PartDefinition armorLeftBoot = left_foot.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(64, 49).addBox(-2.35F, 9.15F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(94, 22).addBox(-2.35F, 10.15F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftbootleaf_r1 = armorLeftBoot.addOrReplaceChild("leftbootleaf_r1", CubeListBuilder.create().texOffs(65, 100).mirror().addBox(-0.1F, -1.625F, -1.55F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2115F, 9.3742F, 1.4902F, -1.0893F, 0.0774F, 0.0404F));

        PartDefinition armorRightLeg = right_leg.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(62, 5).addBox(-2.5F, -0.1F, -2.5F, 4.75F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightleg_r1 = armorRightLeg.addOrReplaceChild("rightleg_r1", CubeListBuilder.create().texOffs(109, 67).mirror().addBox(-0.5F, -2.7F, -0.2F, 1.0F, 5.4F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6F, 1.9F, -3.15F, 0.0F, 0.0F, 0.48F));

        PartDefinition armorRightBoot = right_foot.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(90, 47).addBox(-2.7F, 10.15F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 21).addBox(-2.7F, 9.15F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightbootleaf_r1 = armorRightBoot.addOrReplaceChild("rightbootleaf_r1", CubeListBuilder.create().texOffs(65, 100).mirror().addBox(0.1F, -1.625F, -1.55F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9885F, 9.3742F, 1.4902F, -1.0904F, -0.0387F, -0.0202F));


        return LayerDefinition.create(mesh, 128, 128);
    }
    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
