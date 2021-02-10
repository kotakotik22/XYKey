package com.kotakotik.xykey.screens;

import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.keybinds.SendWithName;
import com.kotakotik.xykey.utils.CoordinateUtils;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;

public class SendWithNameGUI extends LightweightGuiDescription {
    public SendWithNameGUI() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(150, 20);

        WLabel label = new WLabel(new LiteralText("Test"), 0xFFFFFF);
//        root.add(label, 0, 4, 2, 1);

        WTextField textField = new WTextField(new TranslatableText("xykey.gui.send_with_name.suggestion")) {
            @Override
            public void onKeyPressed(int ch, int key, int modifiers) {
                super.onKeyPressed(ch, key, modifiers);
                if(ch == GLFW.GLFW_KEY_ENTER) {
                    MinecraftClient client = MinecraftClient.getInstance();
                     client.player.sendChatMessage(getText() + ": " + CoordinateUtils.coordinateString(client.player));
                     client.openScreen(null); // close screen
                }
            }
        };
        root.add(textField, 0, 0, 20, 80);
        requestFocus(textField);


        root.validate(this);
    }

    static {
        Xykey.english.put("xykey.gui.send_with_name.suggestion", "What do you want to name the position to send in chat?");
    }
}
