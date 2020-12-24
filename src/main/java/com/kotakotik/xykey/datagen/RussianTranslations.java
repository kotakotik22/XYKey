package com.kotakotik.xykey.datagen;

import com.kotakotik.xykey.Keybinds;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class RussianTranslations extends LanguageProvider {
    public RussianTranslations(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        Keybinds.langAddTranslations(this, "ru_ru");
    }
}
