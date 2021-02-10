package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.utils.CoordinateUtils;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;

public class SendPosition extends Keybind {
    @Override
    public String getName() {
        return "send_position";
    }

    @Override
    public int getDefaultKey() {
        return GLFW.GLFW_KEY_O;
    }

    @Override
    public void onPressed(MinecraftClient client) {
        client.player.sendChatMessage(CoordinateUtils.coordinateString(client.player));
    }

    @Override
    public HashMap<String, String> getLangNames() {
        HashMap<String, String> lang = new HashMap<>();
        lang.put("en_us", "Send position in chat");
        return lang;
    }
}
