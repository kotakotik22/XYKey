package com.kotakotik.xykey.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SendPositionToSelf extends Keybind {
    @Nonnull
    @Override
    public String getName() {
        return "send_position_to_self";
    }

    @Override
    public int getDefaultKey() {
        return 73; // I
    }

    @Override
    public void onPressed(TickEvent.ClientTickEvent event) {
        ClientPlayerEntity playerEntity = Minecraft.getInstance().player;
        assert playerEntity != null;
        playerEntity.sendStatusMessage(new StringTextComponent(playerEntity.getPosition().getCoordinatesAsString()), true);
    }

    @Override
    public HashMap<String, String> getLangNames() {
        HashMap<String, String> lang = new HashMap<>();
        lang.put("en_us", "Show current position");
        lang.put("ru_ru", "Показать текущую позицию");
        return lang;
    }
}
