package com.kotakotik.xykey;

import com.kotakotik.xykey.keybinds.Keybind;
import com.kotakotik.xykey.keybinds.SendPosition;
import com.kotakotik.xykey.keybinds.SendPositionToSelf;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static final SendPosition sendPosition = new SendPosition();
    public static final SendPositionToSelf sendPositionToSelf = new SendPositionToSelf();

    public static final Keybind[] keybinds = new Keybind[]{
            sendPosition,
            sendPositionToSelf
    };

    public static void register() {
        for(Keybind keybind : keybinds) {
            ClientRegistry.registerKeyBinding(keybind.getKeyBinding());
        }
    }

//    public static KeyBinding register(String name, int key) {
//        KeyBinding binding =
//        ClientRegistry.registerKeyBinding(binding);
//        return binding;
//    }
}
