package com.kotakotik.xykey.screens;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

public class SendWithNameScreen extends CottonClientScreen {
    public SendWithNameScreen(GuiDescription description) {
        super(description);
    }

    public SendWithNameScreen() {
        super(new SendWithNameGUI());
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        super.onClose();
    }
}
