package com.kotakotik.xykey.screens;

import com.kotakotik.xykey.Keybinds;
import com.kotakotik.xykey.keybinds.Keybind;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class SendWithNameScreen extends Screen {
    public SendWithNameScreen() {
        super(new StringTextComponent("send with name screen"));
    }

    TextFieldWidget nameField;

    @Override
    protected void init() {
        super.init();
        int relX = this.width /2;
        int relY = this.height /2;
        nameField = new TextFieldWidget(font, relX + 10, relY + 40, 160, 20, new StringTextComponent("message.xykey_send_with_name_input"));
        nameField.setText("");
        nameField.setFocused2(true);
        nameField.setVisible(true);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        nameField.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x,  y, btn);
        nameField.mouseClicked(x, y, btn);
    }

    public void updateScreen() {
        nameField.moveCursorBy(nameField.getText().length());
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        super.charTyped(codePoint, modifiers);
        if(nameField.isFocused()) {
            nameField.charTyped(codePoint, modifiers);
        }


        return true;
    }

    @Override
    public boolean changeFocus(boolean focus) {
        if(nameField.isFocused()) nameField.setFocused2(false);
        else nameField.setFocused2(true);
        return super.changeFocus(focus);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (nameField.isFocused()) {
            System.out.println(keyCode);
            if(keyCode == 257 /* ENTER */) {
                closeScreen();
                sendToChat();
            } else {
                nameField.keyPressed(keyCode, scanCode, modifiers);
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public void sendToChat() {
        assert minecraft.player != null; // blah blah blah player might not exist blah blah blah
        minecraft.player.sendChatMessage(nameField.getText() + " - " + minecraft.player.getPosition().getCoordinatesAsString());
    }
}
