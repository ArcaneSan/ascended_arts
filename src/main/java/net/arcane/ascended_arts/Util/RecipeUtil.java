package net.arcane.ascended_arts.Util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.core.NonNullList;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.crafting.CraftingHelper;

import java.util.List;
import java.util.stream.Collectors;


public class RecipeUtil {

    public static Ingredient ingredientFromObject(Object object) {
        return switch (object) {
            case Item item -> Ingredient.of(item);
            case Block block -> Ingredient.of(new ItemStack(block));
            case ItemStack stack -> Ingredient.of(stack);
            case TagKey<?> tagKey -> Ingredient.of((TagKey<Item>) tagKey);
            case null, default -> Ingredient.EMPTY;
        };
    }

    public static List<Ingredient> ingredientsFromObjects(List<Object> objects) {
        return objects.stream().map(RecipeUtil::ingredientFromObject).collect(Collectors.toList());
    }

    public static ItemStack stackFromObject(Object object) {
        if (object instanceof Item) return new ItemStack((Item) object);
        else if (object instanceof Block) return new ItemStack((Block) object);
        else if (object instanceof ItemStack) return ((ItemStack) object).copy();
        else return ItemStack.EMPTY;
    }

    public static List<ItemStack> stacksFromObjects(List<Object> objects) {
        return objects.stream().map(RecipeUtil::stackFromObject).collect(Collectors.toList());
    }

}
