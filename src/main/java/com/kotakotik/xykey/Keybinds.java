package com.kotakotik.xykey;

import com.kotakotik.xykey.keybinds.Keybind;
import com.kotakotik.xykey.keybinds.SendPosition;
import javafx.scene.input.KeyCode;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static final SendPosition sendPosition = new SendPosition();

    public static final Keybind[] keybinds = new Keybind[]{
            sendPosition
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
