package net.arcane.ascended_arts.entity;

import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReplaceabeArmature extends Armature {
    public final ArrayList<Joint> joints = new ArrayList<>();

    public ReplaceabeArmature(String name, int jointNumber, Joint rootJoint, Map<String, Joint> jointMap) {
        super(name, jointNumber, rootJoint, jointMap);
    }
    public List<Joint> getJoints(LivingEntityPatch<?> livingEntityPatch){
        return joints;
    }
}
