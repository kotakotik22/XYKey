package com.kotakotik.xykey.keybinds;

import com.kotakotik.xykey.screens.SendWithNameScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SendWithName extends Keybind {
    @Nonnull
    @Override
    public String getName() {
        return "send_position_with_name";
    }

    @Override
    public int getDefaultKey() {
        return 85; // U
    }

    @Override
    public void onPressed(TickEvent.ClientTickEvent event) {
        Minecraft.getInstance().displayGuiScreen(new SendWithNameScreen());
    }

    @Override
    public HashMap<String, String> getLangNames() {
        HashMap<String, String> lang = new HashMap<>();
        lang.put("en_us", "Send current position with name");
        return lang;
    }
}
