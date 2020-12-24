package com.kotakotik.xykey.keybinds;

import javafx.scene.input.KeyCode;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;

public class SendPosition extends Keybind {
    @Nonnull
    @Override
    public String getName() {
        return "send_position";
    }

    @Nonnull
    @Override
    public int getDefaultKey() {
        return 79; // O
    }

    @Override
    public void onPressed(TickEvent.ClientTickEvent event) {
        Minecraft.getInstance().player.sendChatMessage(Minecraft.getInstance().player.getPosition().getCoordinatesAsString());
    }
}
