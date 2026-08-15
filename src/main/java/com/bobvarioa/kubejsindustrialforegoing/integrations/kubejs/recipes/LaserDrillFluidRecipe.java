package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes;

import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.IndustrialForegoingComponents;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import com.buuz135.industrial.recipe.data.EntityData;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.SizedFluidIngredientComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.List;

public interface LaserDrillFluidRecipe {
    RecipeKey<SizedFluidIngredient> OUTPUT = SizedFluidIngredientComponent.FLAT.outputKey("output");
    RecipeKey<List<LaserDrillRarity>> RARITY = IndustrialForegoingComponents.LASER_DRILL_RARITY.instance()
            .asList()
            .otherKey("rarity");

    RecipeKey<Ingredient> CATALYST = IngredientComponent.INGREDIENT.inputKey("catalyst");

    RecipeKey<EntityData> ENTITY_DATA = IndustrialForegoingComponents.ENTITY_DATA.otherKey("entity_data")
            .defaultOptional();

    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, CATALYST, RARITY, ENTITY_DATA).uniqueId(OUTPUT);
}
