package net.arcane.ascended_arts.gameasset;

import net.arcane.ascended_arts.Ascended_arts;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class AscendedColliderPreset {

    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation r1, Collider collider) {
        if(PRESETS.containsKey(r1)) {
            throw new IllegalStateException("Collider named " + r1 + " already registered.");
        }
        PRESETS.put(r1, collider);

        return collider;

    }

    public static final Collider JIAN = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "jian"),
            new MultiOBBCollider(3, 0.4D, 0.4D, 0.9D, 0D, 0D, -0.8D));
    public static final Collider KICK = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "kick"),
            new MultiOBBCollider(3, 0.6D, 0.6D, 0.6D, 0D, 0.7D, -0.3D));
    public static final Collider GREATSWORD = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "greatsword"),
            new MultiOBBCollider(3, 0.5D, 0.7D, 1.7D, 0D, 0.1D, -0.8D));
    public static final Collider SCYTHE = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "scythe"),
            new MultiOBBCollider(3, 0.4D, 1.3D, 0.9D, 0D, -0.3D, -0.9D));
    public static final Collider SCYTHE_BOTTOM = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "scythe_bottom"),
            new MultiOBBCollider(3, 0.4D, 0.4D, 0.8D, 0.0D, 0.0D, 0.6D));
    public static final Collider SWEEPING_SCYTHE = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "sweeping_scythe"),
            new MultiOBBCollider(3, 0.2D, 0.65D, 0.5D, 0.0D, -0.15D, -0.7D));
    public static final Collider DASH = registerCollider(ResourceLocation.fromNamespaceAndPath(Ascended_arts.MOD_ID, "dash"),
            new MultiOBBCollider(3, 1.0D, 1.0D, 1.0D, 0.5D, 0.0D, 0D));
}
