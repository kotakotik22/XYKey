package com.kotakotik.xykey.client;

import com.kotakotik.xykey.events;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class XykeyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        events.reg();
        Keybinds.createCategoryKey();
    }
}
