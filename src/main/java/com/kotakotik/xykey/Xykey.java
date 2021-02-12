package com.kotakotik.xykey;

import com.kotakotik.xykey.client.Keybinds;
import com.kotakotik.xykey.datagen.DataGen;
import net.devtech.arrp.ARRP;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.impl.RuntimeResourcePackImpl;
import net.fabricmc.api.ModInitializer;

import java.util.HashMap;

public class Xykey implements ModInitializer {
    public static final HashMap<String, String> english = new HashMap<>();

    public static String MODID = "xykey";

    public static final RuntimeResourcePackImpl RESOURCE_PACK = (RuntimeResourcePackImpl) RuntimeResourcePack.create("xykey:main");

    @Override
    public void onInitialize() {
        DataGen.gen();
    }
}
