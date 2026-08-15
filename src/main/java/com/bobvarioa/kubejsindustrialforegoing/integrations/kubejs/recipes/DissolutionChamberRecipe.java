package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.FluidStackComponent;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.SizedFluidIngredientComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.IntBounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.List;

public interface DissolutionChamberRecipe {
    RecipeKey<List<Ingredient>> INPUT = IngredientComponent.INGREDIENT.instance()
            .asList()
            .withBounds(IntBounds.OPTIONAL)
            .inputKey("input");
    RecipeKey<SizedFluidIngredient> INPUT_FLUID = SizedFluidIngredientComponent.FLAT.inputKey("inputFluid");

    RecipeKey<ItemStack> OUTPUT = ItemStackComponent.ITEM_STACK.outputKey("output");
    RecipeKey<FluidStack> OUTPUT_FLUID = FluidStackComponent.OPTIONAL_FLUID_STACK.outputKey("outputFluid")
            .optional(FluidStack.EMPTY)
            .exclude();
    RecipeKey<Integer> TIME = NumberComponent.INT.otherKey("processingTime");

    RecipeSchema SCHEMA = new RecipeSchema(INPUT, INPUT_FLUID, OUTPUT, TIME, OUTPUT_FLUID).uniqueId(OUTPUT);
}
