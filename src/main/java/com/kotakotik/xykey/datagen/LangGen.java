package com.kotakotik.xykey.datagen;

import com.google.gson.Gson;
import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.client.Keybinds;
import com.kotakotik.xykey.client.XykeyClient;
import net.devtech.arrp.json.lang.JLang;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LangGen {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void reg() {
        JLang lang = JLang.lang();
        for(Keybind keybind : Keybinds.keybinds) {
            for(String key : keybind.createTranslations().keySet()) {
                lang.entry(key, keybind.createTranslations().get(key));
            }
//            lang.entry()keybind.createTranslations();
            lang.entry(keybind.createKeyString(), keybind.getEnglish());
        };
        lang.entry(Keybinds.createCategoryKey(), "XYKey");

        // ignored because i started using lang dump instead
//        File file = new File("xykey/en_us.json");
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(new Gson().toJson(lang.getLang()));
//            LOGGER.info("wrote xykey english localization to xykey/en_us.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Xykey.RESOURCE_PACK.addLang(new Identifier(Xykey.MODID, "en_us"), lang);
    }
}
