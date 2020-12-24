package com.kotakotik.xykey.keybinds;

import javafx.scene.input.KeyCode;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;

public abstract class Keybind {
    @Nonnull
    public abstract String getName();
    @Nonnull
    public abstract KeyCode getDefaultKey();
    public abstract void onPressed(TickEvent.ClientTickEvent event);
    public String getCategory() {
        return "xykey";
    }
    public int getDefaultKeyInt() {
        return getDefaultKey().ordinal();
    }
    private KeyBinding createKeyBinding() {
        return new KeyBinding("KEY."+ com.example.examplemod.XYKey.MODID + "." + getName(), getDefaultKeyInt(), "KEY."+ com.example.examplemod.XYKey.MODID+"."+getCategory());
    }
    private KeyBinding keyBinding = createKeyBinding();

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }
}
