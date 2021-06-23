package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.client.Keybinds;
import com.kotakotik.xykey.utils.CoordinateUtils;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.image.DataBufferByte;
import java.nio.Buffer;
import java.util.HashMap;

public class CopyPosition extends Keybind {
    @Override
    public String getName() {
        return "copy_position";
    }

    @Override
    public String getEnglish() {
        return "Copy position to clipboard";
    }

    @Override
    public int getDefaultKey() {
        return GLFW.GLFW_KEY_J;
    }

    @Override
    public void onPressed(MinecraftClient client) {
        client.keyboard.setClipboard(CoordinateUtils.coordinateString(client.player));

        client.player.sendMessage(new TranslatableText(copiedKey), true);
    }

//    @Override
//    public void onPressed(TickEvent.ClientTickEvent event) {
//        assert Minecraft.getInstance().player != null;
//
//        Minecraft minecraft = Minecraft.getInstance();
//        new ClipboardHelper().setClipboardString(minecraft.getMainWindow().getHandle(), minecraft.player.getPosition().getCoordinatesAsString());
//
//        minecraft.player.sendStatusMessage(new TranslationTextComponent(copiedKey), true);
//    }

    public static final String copiedKey = "message.xykey_position_copied";

    @Override
    public void createTranslations(HashMap<String, String> map) {
        map.put(copiedKey, "Position successfully copied!");
    }
}