package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.screens.SendWithNameScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;

public class SendWithName extends Keybind {
    @Nonnull
    @Override
    public String getName() {
        return "send_position_witn_name";
    }

    @Nonnull
    @Override
    public int getDefaultKey() {
        return 85; // U
    }

    @Override
    public void onPressed(TickEvent.ClientTickEvent event) {
        Minecraft.getInstance().displayGuiScreen(new SendWithNameScreen());
    }
}
