package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.Keybinds;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import net.minecraft.client.ClipboardHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;

public class CopyPosition extends Keybind {
    @Nonnull
    @Override
    public String getName() {
        return "copy_position";
    }

    @Override
    public int getDefaultKey() {
        return 74; // J
    }

    @Override
    public void onPressed(TickEvent.ClientTickEvent event) {
        assert Minecraft.getInstance().player != null;

        Minecraft minecraft = Minecraft.getInstance();
        new ClipboardHelper().setClipboardString(minecraft.getMainWindow().getHandle(), minecraft.player.getPosition().getCoordinatesAsString());

        minecraft.player.sendStatusMessage(new TranslationTextComponent(copiedKey), true);
    }

    @Override
    public HashMap<String, String> getLangNames() {
        HashMap<String, String> map = new HashMap<>();

        map.put("en_us", "Copy position to clipboard");
        map.put("ru_ru", "Скопировать позицию в буфер обмена");

        return map;
    }

    public static final String copiedKey = "message.xykey_position_copied";

    @Override
    public void createTranslations() {
        Keybinds.english.put(copiedKey, "Position successfully copied!");
        Keybinds.russian.put(copiedKey, "Позиция скопирована успешно");
    }
}
