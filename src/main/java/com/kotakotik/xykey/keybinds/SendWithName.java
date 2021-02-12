package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.screens.SendWithNameScreen;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;

public class SendWithName extends Keybind {
    @Override
    public String getName() {
        return "send_position_with_name";
    }

    @Override
    public String getEnglish() {
        return "Send current position with name";
    }

    @Override
    public int getDefaultKey() {
        return GLFW.GLFW_KEY_U;
    }

    @Override
    public void onPressed(MinecraftClient client) {
        client.openScreen(new SendWithNameScreen());
    }

    @Override
    public void createTranslations(HashMap<String, String> map) {
        map.put("xykey.gui.send_with_name.suggestion", "What would you call these coordinates?");
    }
}
