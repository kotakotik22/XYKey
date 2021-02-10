package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.utils.CoordinateUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.*;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.List;

public class SendPositionToSelf extends Keybind {
    @Override
    public String getName() {
        return "send_position_to_self";
    }

    @Override
    public int getDefaultKey() {
        return GLFW.GLFW_KEY_I;
    }

    @Override
    public void onPressed(MinecraftClient client) {
        client.player.sendMessage(new LiteralText(CoordinateUtils.coordinateString(client.player)), true);
    }

    @Override
    public HashMap<String, String> getLangNames() {
        HashMap<String, String> lang = new HashMap<>();
        lang.put("en_us", "Show current position");
        return lang;
    }
}
