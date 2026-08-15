package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs;

import com.bobvarioa.kubejsindustrialforegoing.KubeJSIndustrialForegoing;
import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes.CrusherRecipe;
import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes.DissolutionChamberRecipe;
import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes.FluidExtractorRecipe;
import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes.LaserDrillFluidRecipe;
import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes.LaserDrillOreRecipe;
import com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs.recipes.StoneWorkRecipe;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentTypeRegistry;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;

public class KubeJSIndustrialForegoingPlugin implements KubeJSPlugin {

    @Override
    public void registerRecipeComponents(RecipeComponentTypeRegistry registry) {
        registry.register(IndustrialForegoingComponents.LASER_DRILL_RARITY);
        registry.register(IndustrialForegoingComponents.ENTITY_DATA);
    }

    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry registry) {
        registry.register(KubeJSIndustrialForegoing.industrialForegoing("laser_drill_ore"), LaserDrillOreRecipe.SCHEMA);
        registry.register(KubeJSIndustrialForegoing.industrialForegoing("laser_drill_fluid"), LaserDrillFluidRecipe.SCHEMA);
        registry.register(KubeJSIndustrialForegoing.industrialForegoing("fluid_extractor"), FluidExtractorRecipe.SCHEMA);
        registry.register(KubeJSIndustrialForegoing.industrialForegoing("dissolution_chamber"), DissolutionChamberRecipe.SCHEMA);
        registry.register(KubeJSIndustrialForegoing.industrialForegoing("crusher"), CrusherRecipe.SCHEMA);
        registry.register(KubeJSIndustrialForegoing.industrialForegoing("stonework_generate"), StoneWorkRecipe.SCHEMA);
    }
}
