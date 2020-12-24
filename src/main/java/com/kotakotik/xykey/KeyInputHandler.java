package com.kotakotik.xykey;

import com.kotakotik.xykey.keybinds.Keybind;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class KeyInputHandler {
    @SubscribeEvent
    public static void onClientTickEvent(final TickEvent.ClientTickEvent event) {
        for(Keybind keybind : Keybinds.keybinds) {
            if(keybind.getKeyBinding().isPressed()) {
                keybind.onPressed(event);
            }
        }
    }
}
