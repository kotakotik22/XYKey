package com.kotakotik.xykey.screens;

import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.utils.CoordinateUtils;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

public class SendWithNameGUI extends LightweightGuiDescription {
    public static int maxChatLength = 256;

    public static String addPosTo(String to, BlockPos pos) {
        return to + ": " + CoordinateUtils.coordinateString(pos);
    }

    public SendWithNameGUI() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(150, 20);

        WLabel label = new WLabel(new LiteralText("Test"), 0xFFFFFF);
//        root.add(label, 0, 4, 2, 1);

        WTextField textField = new WTextField(new TranslatableText("xykey.gui.send_with_name.suggestion")) {
            BlockPos pos;

            {
                pos = MinecraftClient.getInstance().player.getBlockPos();
                setMaxLength(maxChatLength - addPosTo("", pos).length());
            }

            @Override
            public void onKeyPressed(int ch, int key, int modifiers) {
                super.onKeyPressed(ch, key, modifiers);
                if (ch == GLFW.GLFW_KEY_ENTER) {
                    MinecraftClient client = MinecraftClient.getInstance();
                    client.player.sendChatMessage(addPosTo(getText(), pos));
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
