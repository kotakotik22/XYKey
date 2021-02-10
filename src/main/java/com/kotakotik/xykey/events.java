package com.kotakotik.xykey;

import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.client.Keybinds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.LiteralText;

public class events {
    public static void reg() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for(Keybind keybind : Keybinds.keybinds) {
                if(keybind.getKeyBinding().isPressed()) {
                    keybind.onPressed(client);
                }
            }
        });
    }
}
