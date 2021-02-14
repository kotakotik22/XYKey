package com.kotakotik.xykey.datagen;

import com.google.gson.Gson;
import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.client.Keybind;
import com.kotakotik.xykey.client.Keybinds;
import com.kotakotik.xykey.client.XykeyClient;
import com.swordglowsblue.artifice.api.Artifice;
//import net.devtech.arrp.json.lang.JLang;
import net.minecraft.client.resource.language.LanguageDefinition;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class LangGen {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void reg() {
        Artifice.registerAssetPack("xykey:lang", pack -> {
            pack.addTranslations(new Identifier("xykey", "en_us"), lang -> {
                for(Keybind keybind : Keybinds.keybinds) {
                    for(String key : keybind.createTranslations().keySet()) {
                        lang.entry(key, keybind.createTranslations().get(key));
                    }
//            lang.entry()keybind.createTranslations();
                    lang.entry(keybind.createKeyString(), keybind.getEnglish());
                };
                lang.entry(Keybinds.createCategoryKey(), "XYKey");
                File file = new File("xykey/en_us.json");
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(lang.build().toOutputString());
                    LOGGER.info("wrote xykey english localization to xykey/en_us.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

//        JLang lang = JLang.lang();


        // ignored because i started using lang dump instead


//        XykeyClient.RESOURCE_PACK.addLang(new Identifier(Xykey.MODID, "en_us"), lang);
    }
}
