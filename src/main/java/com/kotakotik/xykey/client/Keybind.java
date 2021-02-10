package com.kotakotik.xykey.client;

import com.kotakotik.xykey.Xykey;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;

import java.util.HashMap;

public abstract class Keybind {
    public abstract String getName();
    public abstract int getDefaultKey(); // https://keycode.info/ and https://www.glfw.org/docs/3.3/group__keys.html to find keycodes
    public abstract void onPressed(MinecraftClient client);
    public abstract HashMap<String, String> getLangNames();
    public String getCategory() {
        return Keybinds.createCategoryKey();
    }
    private KeyBinding createKeyBinding() {
        return new KeyBinding(createKeyString(), getDefaultKey(), getCategory());
    }
    public String createKeyString() {
        return "KEY."+ Xykey.MODID + "." + getName();
    }
    private KeyBinding keyBinding = createKeyBinding();
    public void createTranslations() {}

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }
}