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
    public String getEnglish() {
        return "Show current position";
    }

    @Override
    public int getDefaultKey() {
        return GLFW.GLFW_KEY_I;
    }

    @Override
    public void onPressed(MinecraftClient client) {
        client.player.sendMessage(new LiteralText(CoordinateUtils.coordinateString(client.player)), true);
    }
}
