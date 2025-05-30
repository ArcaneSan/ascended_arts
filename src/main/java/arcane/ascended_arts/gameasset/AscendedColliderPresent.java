package arcane.ascended_arts.gameasset;

import arcane.ascended_arts.Ascended_arts;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class AscendedColliderPresent {

    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation r1, Collider collider) {
        if(PRESETS.containsKey(r1)) {
            throw new IllegalStateException("Collider named " + r1 + " already registered.");
        }
        PRESETS.put(r1, collider);

        return collider;

    }

    public static final Collider SABER = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "saber"),
            new MultiOBBCollider(3, 0.4D, 0.4D, 0.9D, 0D, 0D, -0.35D));
}
