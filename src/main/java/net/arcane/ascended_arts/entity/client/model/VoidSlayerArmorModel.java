package net.arcane.ascended_arts.entity.client.model;


import net.arcane.ascended_arts.entity.client.ArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class VoidSlayerArmorModel extends ArmorModel {


    public VoidSlayerArmorModel(ModelPart root) {
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
        PartDefinition Halo = root.getChild("head");
        PartDefinition left_leg = root.getChild("left_legging");
        PartDefinition right_leg = root.getChild("right_legging");
        PartDefinition waists = root.getChild("leggings");




        PartDefinition armorHead = Halo.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(4, 5).addBox(-4.5F, -8.75F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head_r1 = armorHead.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(67, 100).mirror().addBox(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -3.0F, 0.0F, 0.3079F, -0.1248F, -0.0396F));

        PartDefinition head_r2 = armorHead.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(67, 100).addBox(1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.0F, 0.0F, 0.3079F, 0.1248F, 0.0396F));

        PartDefinition halo_r1 = armorHead.addOrReplaceChild("halo_r1", CubeListBuilder.create().texOffs(103, 11).addBox(6.4761F, -2.9991F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(102, 5).mirror().addBox(-7.5004F, 1.9749F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 0.8375F, -0.639F, 0.493F));

        PartDefinition halo_r2 = armorHead.addOrReplaceChild("halo_r2", CubeListBuilder.create().texOffs(102, 9).mirror().addBox(6.1887F, -2.9891F, -2.2738F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(99, 3).addBox(-7.2298F, 1.9849F, 0.2429F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 1.1955F, -0.875F, -0.0189F));

        PartDefinition halo_r3 = armorHead.addOrReplaceChild("halo_r3", CubeListBuilder.create().texOffs(106, 9).mirror().addBox(6.2078F, -2.9891F, 0.2327F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(99, 5).addBox(-7.2107F, 1.9849F, -2.284F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 0.679F, -0.3188F, 0.83F));

        PartDefinition halo_r4 = armorHead.addOrReplaceChild("halo_r4", CubeListBuilder.create().texOffs(103, 9).addBox(6.5004F, 1.9749F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(109, 5).addBox(-7.4761F, -2.9991F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 0.8375F, 0.639F, -0.493F));

        PartDefinition halo_r5 = armorHead.addOrReplaceChild("halo_r5", CubeListBuilder.create().texOffs(99, 7).addBox(6.2107F, 1.9849F, -2.284F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(104, 11).addBox(-7.2078F, -2.9891F, 0.2327F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 0.679F, 0.3188F, -0.83F));

        PartDefinition halo_r6 = armorHead.addOrReplaceChild("halo_r6", CubeListBuilder.create().texOffs(111, 5).addBox(6.2298F, 1.9849F, 0.2429F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 3).addBox(-7.1887F, -2.9891F, -2.2738F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 1.1955F, 0.875F, 0.0189F));

        PartDefinition halo_r7 = armorHead.addOrReplaceChild("halo_r7", CubeListBuilder.create().texOffs(102, 3).addBox(7.455F, -0.5671F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(109, 7).mirror().addBox(-8.455F, -0.5671F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 1.0036F, 0.0F, 0.0F));

        PartDefinition halo_r8 = armorHead.addOrReplaceChild("halo_r8", CubeListBuilder.create().texOffs(102, 10).addBox(7.095F, -0.5571F, 0.1464F, 1.0F, 0.98F, 2.5F, new CubeDeformation(0.0F))
                .texOffs(99, 9).addBox(-8.0759F, -0.5571F, -2.6875F, 1.0F, 0.98F, 2.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 1.0472F, 0.2291F, 0.3747F));

        PartDefinition halo_r9 = armorHead.addOrReplaceChild("halo_r9", CubeListBuilder.create().texOffs(102, 5).mirror().addBox(7.5F, -0.4773F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(106, 3).addBox(-8.5F, -0.4773F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition halo_r10 = armorHead.addOrReplaceChild("halo_r10", CubeListBuilder.create().texOffs(101, 5).addBox(5.3563F, -0.4673F, 2.2083F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(109, 7).mirror().addBox(-6.3563F, -0.4573F, -4.2083F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -1.0299F, 0.8934F, -0.914F));

        PartDefinition halo_r11 = armorHead.addOrReplaceChild("halo_r11", CubeListBuilder.create().texOffs(109, 11).addBox(6.4829F, -0.4773F, 1.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 7).addBox(-7.4829F, -0.4773F, -3.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -0.7333F, 0.639F, -0.493F));

        PartDefinition halo_r12 = armorHead.addOrReplaceChild("halo_r12", CubeListBuilder.create().texOffs(108, 7).addBox(7.2356F, -0.4673F, 0.3289F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(107, 5).addBox(-8.2357F, -0.4573F, -2.3289F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -0.6037F, 0.3286F, -0.219F));

        PartDefinition halo_r13 = armorHead.addOrReplaceChild("halo_r13", CubeListBuilder.create().texOffs(99, 10).addBox(7.0759F, -0.5571F, -2.6875F, 1.0F, 0.98F, 2.6F, new CubeDeformation(0.0F))
                .texOffs(105, 9).mirror().addBox(-8.0951F, -0.5571F, 0.1464F, 1.0F, 0.98F, 2.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, 1.0472F, -0.2291F, -0.3747F));

        PartDefinition halo_r14 = armorHead.addOrReplaceChild("halo_r14", CubeListBuilder.create().texOffs(102, 3).mirror().addBox(6.4829F, -0.4773F, -3.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(100, 3).mirror().addBox(-7.4829F, -0.4773F, 1.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -0.7333F, -0.639F, 0.493F));

        PartDefinition halo_r15 = armorHead.addOrReplaceChild("halo_r15", CubeListBuilder.create().texOffs(101, 9).addBox(7.2356F, -0.4673F, -2.3289F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(103, 3).addBox(-8.2357F, -0.4573F, 0.3289F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -0.6037F, -0.3286F, 0.219F));

        PartDefinition halo_r16 = armorHead.addOrReplaceChild("halo_r16", CubeListBuilder.create().texOffs(105, 11).addBox(5.3563F, -0.4673F, -4.2083F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(105, 7).addBox(-6.3563F, -0.4673F, 2.2083F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5227F, 2.0F, -1.0299F, -0.8934F, 0.914F));

        PartDefinition waist = waists.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(87, 54).addBox(-4.35F, 8.0F, -2.25F, 8.7F, 4.25F, 4.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition armorBody = Chest.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(4, 42).addBox(-4.75F, -0.5F, -2.3F, 9.5F, 13.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(5, 85).addBox(-3.9F, 8.85F, -2.55F, 7.9F, 2.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_r1 = armorBody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(33, 105).addBox(-0.6971F, -3.5929F, -1.0F, 1.0F, 3.2F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2329F, 2.8329F, -1.9F, 0.0F, 0.0F, -0.7854F));

        PartDefinition body_r2 = armorBody.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(41, 101).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 7.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 1.0F, -1.9F, 0.0F, 0.0F, 0.7854F));

        PartDefinition robe_r1 = armorBody.addOrReplaceChild("robe_r1", CubeListBuilder.create().texOffs(66, 31).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 1.0F, -2.3F, 0.0F, -1.2654F, 0.0F));

        PartDefinition robe_r2 = armorBody.addOrReplaceChild("robe_r2", CubeListBuilder.create().texOffs(77, 31).addBox(-0.5F, -1.5F, -2.0F, 1.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 1.0F, -2.3F, 0.0F, 1.2654F, 0.0F));

        PartDefinition robe_r3 = armorBody.addOrReplaceChild("robe_r3", CubeListBuilder.create().texOffs(41, 23).addBox(-4.75F, -2.5F, -0.5F, 9.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.4457F, 4.9251F, 0.5672F, 0.0F, 0.0F));

        PartDefinition robe_r4 = armorBody.addOrReplaceChild("robe_r4", CubeListBuilder.create().texOffs(40, 31).addBox(-4.75F, 0.0F, 1.5F, 9.5F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.4518F, 0.3157F, 0.3054F, 0.0F, 0.0F));

        PartDefinition armorRightArm = right_arm.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(4, 64).addBox(-3.5F, -2.25F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(51, 77).mirror().addBox(-3.75F, 4.65F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightshoulder_r1 = armorRightArm.addOrReplaceChild("rightshoulder_r1", CubeListBuilder.create().texOffs(52, 63).mirror().addBox(-4.0F, -1.5F, -1.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3F, -0.85F, -1.45F, 0.0F, 0.0F, -1.5708F));

        PartDefinition rightshoulder_r2 = armorRightArm.addOrReplaceChild("rightshoulder_r2", CubeListBuilder.create().texOffs(17, 100).addBox(-0.3F, -0.3F, -1.0F, 1.0F, 1.3F, 1.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4324F, -1.4975F, 0.0F, 0.7854F, 0.0F, 1.6581F));

        PartDefinition rightshoulder_r3 = armorRightArm.addOrReplaceChild("rightshoulder_r3", CubeListBuilder.create().texOffs(21, 101).addBox(-0.49F, -0.8F, -0.8F, 0.99F, 1.4F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8844F, -3.112F, 2.8F, -2.3562F, 0.0F, 0.5672F));

        PartDefinition rightshoulder_r4 = armorRightArm.addOrReplaceChild("rightshoulder_r4", CubeListBuilder.create().texOffs(104, 103).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0215F, -0.4578F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition rightshoulder_r5 = armorRightArm.addOrReplaceChild("rightshoulder_r5", CubeListBuilder.create().texOffs(21, 97).addBox(-0.49F, -0.8F, -0.8F, 0.99F, 1.4F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8844F, -3.112F, -2.8F, 0.7854F, 0.0F, 0.5672F));

        PartDefinition rightshoulder_r6 = armorRightArm.addOrReplaceChild("rightshoulder_r6", CubeListBuilder.create().texOffs(92, 97).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

        PartDefinition rightshoulder_r7 = armorRightArm.addOrReplaceChild("rightshoulder_r7", CubeListBuilder.create().texOffs(81, 91).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2688F, -3.3581F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition rightshoulder_r8 = armorRightArm.addOrReplaceChild("rightshoulder_r8", CubeListBuilder.create().texOffs(17, 103).addBox(-0.3F, -1.0F, -1.0F, 1.0F, 1.3F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6528F, -4.2911F, 0.0F, -0.7854F, 0.0F, -0.5236F));

        PartDefinition armorLeftLeg = left_leg.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(29, 65).addBox(-2.25F, -0.1F, -2.5F, 4.75F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.05F, 0.0F));

        PartDefinition leftleg_r1 = armorLeftLeg.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(48, 104).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.5F, new CubeDeformation(0.0F))
                .texOffs(49, 102).addBox(-0.65F, -1.65F, -1.0F, 1.3F, 1.3F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(49, 99).addBox(-0.75F, -1.75F, -2.0F, 1.5F, 1.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 98).addBox(-0.25F, -1.25F, -2.45F, 0.5F, 0.5F, 0.45F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.0F, -1.0F, -0.6545F, 0.0F, 0.0F));

        PartDefinition armorLeftArm = left_arm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(41, 5).addBox(-1.5F, -2.25F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(51, 77).addBox(-1.75F, 4.65F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftshoulder_r1 = armorLeftArm.addOrReplaceChild("leftshoulder_r1", CubeListBuilder.create().texOffs(52, 63).addBox(-2.0F, -1.5F, -1.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, -1.1F, -1.45F, 0.0F, 0.0F, 1.2654F));

        PartDefinition armorLeftBoot = left_foot.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(64, 49).addBox(-2.35F, 9.15F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(94, 22).addBox(-2.35F, 10.15F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.05F, 0.0F));

        PartDefinition leftboot_r1 = armorLeftBoot.addOrReplaceChild("leftboot_r1", CubeListBuilder.create().texOffs(67, 105).addBox(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, 12.0F, 0.0F, 0.4422F, 0.158F, 0.0744F));

        PartDefinition armorRightLeg = right_leg.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(62, 5).addBox(-2.5F, -0.1F, -2.5F, 4.75F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.05F, 0.0F));

        PartDefinition armorRightBoot = right_foot.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(90, 47).addBox(-2.7F, 10.15F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 21).addBox(-2.7F, 9.15F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.05F, 0.0F));

        PartDefinition rightboot_r1 = armorRightBoot.addOrReplaceChild("rightboot_r1", CubeListBuilder.create().texOffs(59, 105).addBox(1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 12.0F, 0.0F, 0.4422F, -0.158F, -0.0744F));

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {





    }
}
