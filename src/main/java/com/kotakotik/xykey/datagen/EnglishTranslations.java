package com.kotakotik.xykey.datagen;

import com.kotakotik.xykey.Keybinds;
import com.kotakotik.xykey.keybinds.Keybind;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.HashMap;

public class EnglishTranslations extends LanguageProvider {
    public EnglishTranslations(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        Keybinds.langAddTranslations(this, "en_us");
    }
//    public static final HashMap<String, HashMap<String, String>> langs = new HashMap<>();
//
//    public static final HashMap<String, String> english = langs.put("en_us", new HashMap<>());
//    public static final HashMap<String, String> russian = langs.put("ru_ru", new HashMap<>());
//
//    public static void register() {
//        System.out.println("Creating lang files");
//
//        System.out.println("Creating keybind lang");
//        for(Keybind keybind : Keybinds.keybinds) {
//
//        }
//        System.out.println("Created keybind lang");
//    }
//
//    public static void saveLang(String name, HashMap<String, String> map) {
//        System.out.println("Saving lang "+name);
//    }


}
