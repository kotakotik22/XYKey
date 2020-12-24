package com.kotakotik.xykey.keybinds;

import com.example.examplemod.XYKey;
import javafx.scene.input.KeyCode;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;

public abstract class Keybind {
    @Nonnull
    public abstract String getName();
    @Nonnull
    public abstract int getDefaultKey(); // https://keycode.info/ to find keycodes
    public abstract void onPressed(TickEvent.ClientTickEvent event);
    public String getCategory() {
        return "xykey";
    }
    private KeyBinding createKeyBinding() {
        return new KeyBinding("KEY."+ XYKey.MODID + "." + getName(), getDefaultKey(), "KEY."+ com.example.examplemod.XYKey.MODID+"."+getCategory());
    }
    private KeyBinding keyBinding = createKeyBinding();

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }
}
