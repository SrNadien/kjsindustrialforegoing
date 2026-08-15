package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.BlockStateComponent;
import dev.latvian.mods.kubejs.recipe.component.BooleanComponent;
import dev.latvian.mods.kubejs.recipe.component.FluidStackComponent;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidStack;

public interface FluidExtractorRecipe {
    RecipeKey<Ingredient> INPUT = IngredientComponent.INGREDIENT.inputKey("input");
    RecipeKey<BlockState> RESULT = BlockStateComponent.OPTIONAL_BLOCK.otherKey("result");

    RecipeKey<Float> BREAK_CHANCE = NumberComponent.FLOAT.otherKey("breakChance");

    RecipeKey<FluidStack> OUTPUT = FluidStackComponent.FLUID_STACK.outputKey("output");

    RecipeKey<Boolean> DEFAULT_RECIPE = BooleanComponent.BOOLEAN.otherKey("defaultRecipe")
            .optional(false)
            .alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(INPUT, RESULT, BREAK_CHANCE, OUTPUT, DEFAULT_RECIPE).uniqueId(INPUT);
}
