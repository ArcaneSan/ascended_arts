package net.arcane.ascended_arts.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;




import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;


import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import static net.arcane.ascended_arts.Util.RegistryUtil.getRegistryName;

public class DyeRecipe extends ShapelessRecipe {


    public DyeRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingInput inv, HolderLookup.@NotNull Provider provider) {
        ItemStack output = super.assemble(inv, provider);
        if (!output.isEmpty()) {
            for (int i = 0; i < inv.size(); i++) { // For each slot in the crafting inventory,
                final ItemStack ingredient = inv.getItem(i); // Get the ingredient in the slot
                if (!ingredient.isEmpty() && ingredient.is(output.getItem())) {
                    output.applyComponents(ingredient.getComponentsPatch()); // Carry over the components
                }
            }
            for (int i = 0; i < inv.size(); i++) { // For each slot in the crafting inventory,
                final ItemStack ingredient = inv.getItem(i); // Get the ingredient in the slot
                DyeColor color = DyeColor.getColor(ingredient);
                if (!ingredient.isEmpty() && color != null) {
                    output.set(DataComponents.BASE_COLOR, color); // Set the color component
                }
            }
        }
        return output;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return AARecipes.DYE_RECIPE.get();
    }


    public static JsonElement asRecipe(Item item) {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", "ascended_arts:dye");
        JsonArray ingredients = new JsonArray();
        JsonObject dyeObject = new JsonObject();
        dyeObject.addProperty("tag", Tags.Items.DYES.location().toString());
        ingredients.add(dyeObject);

        JsonObject input = new JsonObject();
        input.addProperty("item", getRegistryName(item).toString());
        ingredients.add(input);

        jsonobject.add("ingredients", ingredients);
        JsonObject itemObject = new JsonObject();
        itemObject.addProperty("item", getRegistryName(item).toString());
        jsonobject.add("result", itemObject);
        return jsonobject;
    }



}

