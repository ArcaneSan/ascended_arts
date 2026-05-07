package net.arcane.ascended_arts.recipes;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class AARecipes {

    static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Ascended_arts.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<DyeRecipe>> DYE_RECIPE = RECIPE_SERIALIZERS.register("dye",
            () -> ExtendableShapelessSerializer.create(DyeRecipe::new));


    static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Ascended_arts.MOD_ID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<DyeRecipe>> DYE_TYPE = RECIPE_TYPES.register("dye", () -> new RecipeType<>() {
        @Override
        public String toString() {
            return "ascended_arts:dye";
        }
    });
}

