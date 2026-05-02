package net.arcane.ascended_arts.entity.type.dagger_control;

import com.google.common.collect.ImmutableList;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.model.Armature;

import java.util.List;
import java.util.Map;

public class DaggerControlArmature extends Armature {
    public final Joint D1, D2, D3;
    public final List<Joint> joints;

    public DaggerControlArmature(String name, int jointNumber, Joint rootJoint, Map<String, Joint> jointMap) {
        super(name, jointNumber, rootJoint, jointMap);
        D1 = getOrLogException(jointMap, "ToolRF1");
        D2 = getOrLogException(jointMap, "ToolRF2");
        D3 = getOrLogException(jointMap, "ToolRF3");
        joints = ImmutableList.of(D1, D2, D3);
    }


}
