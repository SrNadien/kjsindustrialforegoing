package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs;

import com.bobvarioa.kubejsindustrialforegoing.KubeJSIndustrialForegoing;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import com.buuz135.industrial.recipe.data.EntityData;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;

public interface IndustrialForegoingComponents {
    RecipeComponentType<LaserDrillRarity> LASER_DRILL_RARITY = CodecComponent.type(
            KubeJSIndustrialForegoing.id("laser_drill_rarity"),
            LaserDrillRarity.class,
            LaserDrillRarity.CODEC
    );

    RecipeComponentType<EntityData> ENTITY_DATA = CodecComponent.type(
            KubeJSIndustrialForegoing.id("entity_data"),
            EntityData.class,
            EntityData.CODEC
    );
}
