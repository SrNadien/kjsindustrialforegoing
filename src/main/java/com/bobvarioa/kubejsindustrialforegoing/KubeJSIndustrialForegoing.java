package com.bobvarioa.kubejsindustrialforegoing;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(KubeJSIndustrialForegoing.MOD_ID)
public class KubeJSIndustrialForegoing {
    public static final String MOD_ID = "kubejsindustrialforegoing";
    public static final String INDUSTRIAL_FOREGOING = "industrialforegoing";

    public KubeJSIndustrialForegoing(IEventBus modEventBus, ModContainer modContainer) {
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static ResourceLocation industrialForegoing(String path) {
        return ResourceLocation.fromNamespaceAndPath(INDUSTRIAL_FOREGOING, path);
    }
}
