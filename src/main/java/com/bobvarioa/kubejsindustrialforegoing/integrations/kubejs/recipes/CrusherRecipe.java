package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;

public interface CrusherRecipe {
    RecipeKey<Ingredient> INPUT = IngredientComponent.INGREDIENT.inputKey("input");
    RecipeKey<Ingredient> OUTPUT = IngredientComponent.INGREDIENT.outputKey("output");

    RecipeSchema SCHEMA = new RecipeSchema(INPUT, OUTPUT).uniqueId(INPUT);
}
