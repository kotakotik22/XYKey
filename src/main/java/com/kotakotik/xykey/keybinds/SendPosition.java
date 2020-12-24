package com.kotakotik.xykey.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SendPosition extends Keybind {
    @Nonnull
    @Override
    public String getName() {
        return "send_position";
    }

    @Override
    public int getDefaultKey() {
        return 79; // O
    }

    @Override
    public void onPressed(TickEvent.ClientTickEvent event) {
        Minecraft.getInstance().player.sendChatMessage(Minecraft.getInstance().player.getPosition().getCoordinatesAsString());
    }

    @Override
    public HashMap<String, String> getLangNames() {
        HashMap<String, String> lang = new HashMap<>();
        lang.put("en_us", "Send position in chat");
        lang.put("ru_ru", "Отправить позицию в чат");
        return lang;
    }
}
