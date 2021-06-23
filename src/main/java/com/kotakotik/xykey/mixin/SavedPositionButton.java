package com.kotakotik.xykey.mixin;

import com.kotakotik.xykey.screens.SavedPositionScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GameMenuScreen.class)
public abstract class SavedPositionButton extends Screen {
    protected SavedPositionButton(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgets")
    private void addCustomButton(CallbackInfo ci) {
        addDrawableChild(new ButtonWidget(0, this.height - 20, 120, 20, new TranslatableText("menu.xykey.saved_pos"), (buttonWidgetx) -> {
            try {
                MinecraftClient.getInstance().openScreen(new SavedPositionScreen());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
