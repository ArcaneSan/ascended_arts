package net.arcane.ascended_arts.recipes;

import net.arcane.ascended_arts.Ascended_arts;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AARecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Ascended_arts.MOD_ID);

    public static final RegistryObject<RecipeSerializer<DyeRecipe>> DYE_RECIPE = RECIPE_SERIALIZERS.register("dye", DyeRecipe.Serializer::new);


    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Ascended_arts.MOD_ID);


    public static final RegistryObject<RecipeType<DyeRecipe>> DYE_TYPE = RECIPE_TYPES.register("dye", () -> new RecipeType<>() {
        @Override
        public String toString() {
            return "ascended_arts:dye";
        }
    });
}

