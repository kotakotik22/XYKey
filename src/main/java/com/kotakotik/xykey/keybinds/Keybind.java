package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.Keybinds;
import com.kotakotik.xykey.XYKey;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;

public abstract class Keybind {
    @Nonnull
    public abstract String getName();
    @Nonnull
    public abstract int getDefaultKey(); // https://keycode.info/ to find keycodes
    public abstract void onPressed(TickEvent.ClientTickEvent event);
    public abstract HashMap<String, String> getLangNames();
    public String getCategory() {
        return Keybinds.createCategoryKey();
    }
    private KeyBinding createKeyBinding() {
        return new KeyBinding(createKeyString(), getDefaultKey(), getCategory());
    }
    public String createKeyString() {
        return "KEY."+ XYKey.MODID + "." + getName();
    }
    private KeyBinding keyBinding = createKeyBinding();

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }
}
