package arcane.ascended_arts.skill;

import arcane.ascended_arts.Ascended_arts;
import arcane.ascended_arts.skill.guard.AscendedCompatSkills;
import arcane.ascended_arts.skill.weaponinnate.CelestialPunishmentSkill;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import yesman.epicfight.api.utils.PacketBufferCodec;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.skill.SkillDataKey;

public class AscendedSkillDataKeys {
    public static final DeferredRegister<SkillDataKey<?>> DATA_KEYS = DeferredRegister.create(ResourceLocation.fromNamespaceAndPath(EpicFightMod.MODID, "skill_data_keys"), Ascended_arts.MOD_ID);

    public static final RegistryObject<SkillDataKey<Integer>> COMBO_COUNTER;
    public static final RegistryObject<SkillDataKey<Integer>> LAST_HIT_COUNT;
    public static final RegistryObject<SkillDataKey<Integer>> PENALTY_RESTORE_COUNTER;
    public static final RegistryObject<SkillDataKey<Float>> PENALTY;


    public AscendedSkillDataKeys() {
    }
    static {
        COMBO_COUNTER = DATA_KEYS.register("combo_counter", () ->
                SkillDataKey.createSkillDataKey(PacketBufferCodec.INTEGER, 0, false, CelestialPunishmentSkill.class));
        LAST_HIT_COUNT = DATA_KEYS.register("last_hit_counter", () ->
                SkillDataKey.createSkillDataKey(PacketBufferCodec.INTEGER, 0, false, CelestialPunishmentSkill.class));
        PENALTY_RESTORE_COUNTER = DATA_KEYS.register("penalty_restore_counter", () ->
                SkillDataKey.createSkillDataKey(PacketBufferCodec.INTEGER, 0, false, AscendedCompatSkills.class));
        PENALTY = DATA_KEYS.register("penalty", () ->
                SkillDataKey.createSkillDataKey(PacketBufferCodec.FLOAT, 0.0F, false, AscendedCompatSkills.class));
    }

}
