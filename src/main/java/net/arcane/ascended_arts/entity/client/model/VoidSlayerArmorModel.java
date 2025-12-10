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




        PartDefinition Head = Halo.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition halo_r1 = Head.addOrReplaceChild("halo_r1", CubeListBuilder.create().texOffs(15, 21).addBox(6.4761F, -2.9991F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(14, 15).mirror().addBox(-7.5004F, 1.9749F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 0.8375F, -0.639F, 0.493F));

        PartDefinition halo_r2 = Head.addOrReplaceChild("halo_r2", CubeListBuilder.create().texOffs(14, 19).mirror().addBox(6.1887F, -2.9891F, -2.2738F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 13).addBox(-7.2298F, 1.9849F, 0.2429F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 1.1955F, -0.875F, -0.0189F));

        PartDefinition halo_r3 = Head.addOrReplaceChild("halo_r3", CubeListBuilder.create().texOffs(18, 19).mirror().addBox(6.2078F, -2.9891F, 0.2327F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 15).addBox(-7.2107F, 1.9849F, -2.284F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 0.679F, -0.3188F, 0.83F));

        PartDefinition halo_r4 = Head.addOrReplaceChild("halo_r4", CubeListBuilder.create().texOffs(15, 19).addBox(6.5004F, 1.9749F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(21, 15).addBox(-7.4761F, -2.9991F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 0.8375F, 0.639F, -0.493F));

        PartDefinition halo_r5 = Head.addOrReplaceChild("halo_r5", CubeListBuilder.create().texOffs(11, 17).addBox(6.2107F, 1.9849F, -2.284F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 21).addBox(-7.2078F, -2.9891F, 0.2327F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 0.679F, 0.3188F, -0.83F));

        PartDefinition halo_r6 = Head.addOrReplaceChild("halo_r6", CubeListBuilder.create().texOffs(23, 15).addBox(6.2298F, 1.9849F, 0.2429F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 13).addBox(-7.1887F, -2.9891F, -2.2738F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 1.1955F, 0.875F, 0.0189F));

        PartDefinition halo_r7 = Head.addOrReplaceChild("halo_r7", CubeListBuilder.create().texOffs(14, 13).addBox(7.455F, -0.5671F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(21, 17).mirror().addBox(-8.455F, -0.5671F, -1.0227F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 1.0036F, 0.0F, 0.0F));

        PartDefinition halo_r8 = Head.addOrReplaceChild("halo_r8", CubeListBuilder.create().texOffs(14, 20).addBox(7.095F, -0.5571F, 0.1464F, 1.0F, 0.98F, 2.5F, new CubeDeformation(0.0F))
                .texOffs(11, 19).addBox(-8.0759F, -0.5571F, -2.6875F, 1.0F, 0.98F, 2.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 1.0472F, 0.2291F, 0.3747F));

        PartDefinition halo_r9 = Head.addOrReplaceChild("halo_r9", CubeListBuilder.create().texOffs(14, 15).mirror().addBox(7.5F, -0.4773F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(18, 13).addBox(-8.5F, -0.4773F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition halo_r10 = Head.addOrReplaceChild("halo_r10", CubeListBuilder.create().texOffs(13, 15).addBox(5.3563F, -0.4673F, 2.2083F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(21, 17).mirror().addBox(-6.3563F, -0.4573F, -4.2083F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -1.0299F, 0.8934F, -0.914F));

        PartDefinition halo_r11 = Head.addOrReplaceChild("halo_r11", CubeListBuilder.create().texOffs(21, 21).addBox(6.4829F, -0.4773F, 1.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 17).addBox(-7.4829F, -0.4773F, -3.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -0.7333F, 0.639F, -0.493F));

        PartDefinition halo_r12 = Head.addOrReplaceChild("halo_r12", CubeListBuilder.create().texOffs(20, 17).addBox(7.2356F, -0.4673F, 0.3289F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(19, 15).addBox(-8.2357F, -0.4573F, -2.3289F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -0.6037F, 0.3286F, -0.219F));

        PartDefinition halo_r13 = Head.addOrReplaceChild("halo_r13", CubeListBuilder.create().texOffs(11, 20).addBox(7.0759F, -0.5571F, -2.6875F, 1.0F, 0.98F, 2.6F, new CubeDeformation(0.0F))
                .texOffs(17, 19).mirror().addBox(-8.0951F, -0.5571F, 0.1464F, 1.0F, 0.98F, 2.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, 1.0472F, -0.2291F, -0.3747F));

        PartDefinition halo_r14 = Head.addOrReplaceChild("halo_r14", CubeListBuilder.create().texOffs(14, 13).mirror().addBox(6.4829F, -0.4773F, -3.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 13).mirror().addBox(-7.4829F, -0.4773F, 1.4555F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -0.7333F, -0.639F, 0.493F));

        PartDefinition halo_r15 = Head.addOrReplaceChild("halo_r15", CubeListBuilder.create().texOffs(13, 19).addBox(7.2356F, -0.4673F, -2.3289F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(15, 13).addBox(-8.2357F, -0.4573F, 0.3289F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -0.6037F, -0.3286F, 0.219F));

        PartDefinition halo_r16 = Head.addOrReplaceChild("halo_r16", CubeListBuilder.create().texOffs(17, 21).addBox(5.3563F, -0.4673F, -4.2083F, 1.0F, 0.98F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(17, 17).addBox(-6.3563F, -0.4673F, 2.2083F, 1.0F, 0.97F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.5227F, 2.0F, -1.0299F, -0.8934F, 0.914F));

        PartDefinition rightfeather = Head.addOrReplaceChild("rightfeather", CubeListBuilder.create(), PartPose.offset(-4.5F, -28.0F, -1.0F));

        PartDefinition head_r1 = rightfeather.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(67, 100).mirror().addBox(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 1.0F, 1.0F, 0.3079F, -0.1248F, -0.0396F));

        PartDefinition leftfeather = Head.addOrReplaceChild("leftfeather", CubeListBuilder.create(), PartPose.offset(4.6872F, -27.8385F, -1.1572F));

        PartDefinition head_r2 = leftfeather.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(67, 100).addBox(1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1872F, 0.8385F, 1.1572F, 0.3079F, 0.1248F, 0.0396F));

        PartDefinition Body = Chest.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(3, 40).addBox(-4.5F, -24.1F, -3.0F, 9.0F, 13.1F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(4, 84).addBox(-3.9F, -15.15F, -3.25F, 7.9F, 2.5F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body_r1 = Body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(33, 105).addBox(-0.6971F, -3.5929F, -1.0F, 1.0F, 3.2F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2329F, -21.1671F, -2.1F, 0.0F, 0.0F, -0.7854F));

        PartDefinition body_r2 = Body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(41, 101).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 7.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -23.0F, -2.1F, 0.0F, 0.0F, 0.7854F));

        PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(66, 31).addBox(-0.75F, -6.35F, -2.0F, 1.0F, 13.1F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2667F, -17.75F, -2.7965F, 0.0F, -1.0908F, 0.0F));

        PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(77, 31).addBox(-0.25F, -6.35F, -2.0F, 1.0F, 13.1F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2667F, -17.75F, -2.7965F, 0.0F, 1.0908F, 0.0F));

        PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(83, 78).addBox(-4.5F, -5.5F, -0.5F, 9.0F, 6.0033F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9967F, 3.4627F, 0.1745F, 0.0F, 0.0F));

        PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(83, 69).addBox(-4.5F, -2.4984F, -0.5F, 9.0F, 4.9967F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0548F, 4.3169F, 0.3054F, 0.0F, 0.0F));

        PartDefinition RightArm = right_arm.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(4, 63).addBox(-8.5F, -24.25F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(51, 77).mirror().addBox(-8.75F, -17.35F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 22.0F, 0.0F));

        PartDefinition rightshoulder_r1 = RightArm.addOrReplaceChild("rightshoulder_r1", CubeListBuilder.create().texOffs(17, 103).addBox(-0.3F, -1.0F, -1.0F, 1.0F, 1.3F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6528F, -26.2911F, 0.0F, -0.7854F, 0.0F, -0.5236F));

        PartDefinition rightshoulder_r2 = RightArm.addOrReplaceChild("rightshoulder_r2", CubeListBuilder.create().texOffs(81, 91).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.2688F, -25.3581F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition rightshoulder_r3 = RightArm.addOrReplaceChild("rightshoulder_r3", CubeListBuilder.create().texOffs(17, 100).addBox(-0.3F, -0.3F, -1.0F, 1.0F, 1.3F, 1.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.4324F, -23.4975F, 0.0F, 0.7854F, 0.0F, 1.6581F));

        PartDefinition rightshoulder_r4 = RightArm.addOrReplaceChild("rightshoulder_r4", CubeListBuilder.create().texOffs(104, 103).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0215F, -22.4578F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition rightshoulder_r5 = RightArm.addOrReplaceChild("rightshoulder_r5", CubeListBuilder.create().texOffs(21, 101).addBox(-0.49F, -0.8F, -0.8F, 0.99F, 1.4F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8844F, -25.112F, 2.8F, -2.3562F, 0.0F, 0.5672F));

        PartDefinition rightshoulder_r6 = RightArm.addOrReplaceChild("rightshoulder_r6", CubeListBuilder.create().texOffs(21, 97).addBox(-0.49F, -0.8F, -0.8F, 0.99F, 1.4F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8844F, -25.112F, -2.8F, 0.7854F, 0.0F, 0.5672F));

        PartDefinition rightshoulder_r7 = RightArm.addOrReplaceChild("rightshoulder_r7", CubeListBuilder.create().texOffs(92, 97).addBox(-1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -24.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

        PartDefinition rightshoulder_r8 = RightArm.addOrReplaceChild("rightshoulder_r8", CubeListBuilder.create().texOffs(52, 63).mirror().addBox(-4.0F, -1.5F, -1.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.3F, -22.85F, -1.45F, 0.0F, 0.0F, -1.5708F));

        PartDefinition LeftArm = left_arm.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(41, 3).addBox(3.5F, -24.25F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(51, 77).addBox(3.25F, -17.35F, -2.75F, 5.5F, 6.0F, 5.5F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 22.0F, 0.0F));

        PartDefinition leftshoulder_r1 = LeftArm.addOrReplaceChild("leftshoulder_r1", CubeListBuilder.create().texOffs(52, 63).addBox(-2.0F, -1.5F, -1.5F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.3F, -23.1F, -1.45F, 0.0F, 0.0F, 1.2654F));

        PartDefinition LeftBoot = left_foot.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(65, 50).addBox(-2.3F, 9.4F, -2.4F, 4.6F, 3.0F, 4.7F, new CubeDeformation(0.0F))
                .texOffs(90, 47).addBox(-2.3F, 10.4F, -3.4F, 4.6F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, 0.0F));

        PartDefinition leftbootbone = LeftBoot.addOrReplaceChild("leftbootbone", CubeListBuilder.create(), PartPose.offset(2.8757F, 10.9429F, -1.1377F));

        PartDefinition leftboot_r1 = leftbootbone.addOrReplaceChild("leftboot_r1", CubeListBuilder.create().texOffs(67, 105).addBox(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7243F, 1.0572F, 1.1377F, 0.4422F, 0.158F, 0.0744F));

        PartDefinition LeftLeg = left_leg.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(30, 64).addBox(-0.1F, -12.1F, -2.2F, 4.25F, 12.0F, 4.3F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.6F, 0.0F));

        PartDefinition leftleg_r1 = LeftLeg.addOrReplaceChild("leftleg_r1", CubeListBuilder.create().texOffs(49, 102).addBox(-0.65F, -1.65F, -1.0F, 1.3F, 1.3F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(50, 98).addBox(-0.25F, -1.25F, -2.45F, 0.5F, 0.5F, 0.45F, new CubeDeformation(0.0F))
                .texOffs(49, 99).addBox(-0.75F, -1.75F, -2.0F, 1.5F, 1.5F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 104).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.0F, -1.0F, -0.6545F, 0.0F, 0.0F));

        PartDefinition bipedRightLeg = right_leg.addOrReplaceChild("bipedRightLeg", CubeListBuilder.create().texOffs(62, 4).addBox(-4.15F, -12.1F, -2.2F, 4.25F, 12.0F, 4.3F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.6F, 0.0F));

        PartDefinition RightBoot = right_foot.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(68, 22).addBox(-2.3F, 9.4F, -2.4F, 4.6F, 3.0F, 4.7F, new CubeDeformation(0.0F))
                .texOffs(94, 22).addBox(-2.3F, 10.4F, -3.4F, 4.6F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, 0.0F));

        PartDefinition rightbootbone = RightBoot.addOrReplaceChild("rightbootbone", CubeListBuilder.create(), PartPose.offset(-2.8757F, 10.9429F, -1.0F));

        PartDefinition rightboot_r1 = rightbootbone.addOrReplaceChild("rightboot_r1", CubeListBuilder.create().texOffs(59, 105).addBox(1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7243F, 1.0572F, 1.0F, 0.4422F, -0.158F, -0.0744F));

        PartDefinition waist = waists.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(87, 54).addBox(-4.35F, 8.0F, -2.25F, 8.7F, 4.25F, 4.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {





    }
}
