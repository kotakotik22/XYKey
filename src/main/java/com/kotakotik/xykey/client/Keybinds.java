package com.kotakotik.xykey.client;

import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.keybinds.CopyPosition;
import com.kotakotik.xykey.keybinds.SendPosition;
import com.kotakotik.xykey.keybinds.SendPositionToSelf;
import com.kotakotik.xykey.keybinds.SendWithName;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final String category = "xykey";

    public static final Keybind copyPosition = new CopyPosition();
    public static final Keybind sendPosition = new SendPosition();
    public static final Keybind sendPositionToSelf = new SendPositionToSelf();
    public static final Keybind sendWithName = new SendWithName();

    public static final Keybind[] keybinds = new Keybind[]{
            copyPosition,
            sendPosition,
            sendPositionToSelf,
            sendWithName
    };

    static {
        for(Keybind keybind: keybinds) {
            KeyBindingHelper.registerKeyBinding(keybind.getKeyBinding());
        }
    }

    private static KeyBinding reg(String name, int key) {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "KEY.xykey."+name, // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                key, // The keycode of the key
                "CATEGORY.xykey.xykey" // The translation key of the keybinding's category.
        ));
    }

    public static String createCategoryKey() {
        return "CATEGORY."+ Xykey .MODID+"."+ category;
    }
}
