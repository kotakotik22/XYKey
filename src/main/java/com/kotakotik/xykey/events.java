package com.kotakotik.xykey;

import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.client.Keybinds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.LiteralText;

import java.util.HashMap;

public class events {
    public static void reg() {
        HashMap<Keybind, Boolean> prevPress = new HashMap<>();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for(Keybind keybind : Keybinds.keybinds) {
                if(keybind.getKeyBinding().isPressed() && !prevPress.get(keybind)) {
                    keybind.onPressed(client);
                }
                prevPress.put(keybind, keybind.getKeyBinding().isPressed());
            }
        });
    }
}
