package com.bobvarioa.kubejsindustrialforegoing.integrations.kubejs;

import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.RecipeScriptContext;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.resources.ResourceLocation;

public record CodecComponent<T>(
        RecipeComponentType<?> type,
        Class<T> typeClass,
        Codec<T> codec,
        TypeInfo typeInfo
) implements RecipeComponent<T> {

    public static <T> RecipeComponentType<T> type(ResourceLocation id, Class<T> typeClass, Codec<T> codec) {
        return RecipeComponentType.unit(id, type -> new CodecComponent<>(type, typeClass, codec, TypeInfo.of(typeClass)));
    }

    @Override
    public T wrap(RecipeScriptContext cx, Object from) {
        if (typeClass.isInstance(from)) {
            return typeClass.cast(from);
        }

        return cx.ops().decode(cx.cx(), codec, from);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
