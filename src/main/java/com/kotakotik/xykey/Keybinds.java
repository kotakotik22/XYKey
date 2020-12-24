package com.kotakotik.xykey;

import com.kotakotik.xykey.keybinds.*;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.HashMap;

public class Keybinds {
    public static final String category = "xykey";

    public static final SendPosition sendPosition = new SendPosition();
    public static final SendPositionToSelf sendPositionToSelf = new SendPositionToSelf();
    public static final SendWithName sendWithName = new SendWithName();
    public static final CopyPosition copyPosition = new CopyPosition();

    public static final HashMap<String, HashMap<String, String>> keybindTranslations = new HashMap<>();
    public static final HashMap<String, String> russian = new HashMap<>();
    public static final HashMap<String, String> english = new HashMap<>();

    public static final Keybind[] keybinds = new Keybind[]{
            sendPosition,
            sendPositionToSelf,
            sendWithName,
            copyPosition
    };

    public static void register() {
        for(Keybind keybind : keybinds) {
            try {
                ClientRegistry.registerKeyBinding(keybind.getKeyBinding());
            } catch (NullPointerException ignored) {
            }
        }
    }

//    public static KeyBinding register(String name, int key) {
//        KeyBinding binding =
//        ClientRegistry.registerKeyBinding(binding);
//        return binding;
//    }

    /**
     * Add all translations related to keybinds
     */
    public static void langAddTranslations(LanguageProvider provider, String locale) {
        for(Keybind keybind : keybinds) {
            keybind.createTranslations();
            HashMap<String, String> translations = keybind.getLangNames();
            if(translations.containsKey(locale)) {
                provider.add(keybind.createKeyString(), translations.get(locale));
            }
        }

        keybindTranslations.put("en_us", english);
        keybindTranslations.put("ru_ru", russian);
//        if(SendWithNameScreen.getTitleTranslation().containsKey(locale)) {
//            provider.add(SendWithNameScreen.titleKey, SendWithNameScreen.getTitleTranslation().get(locale));
//        }
        for(String langTranslationKey : keybindTranslations.keySet()) {
            HashMap<String, String> langTranslationHashMap = keybindTranslations.get(langTranslationKey);
            if(locale.equals(langTranslationKey)) {
                for(String transKey : langTranslationHashMap.keySet()) {
                    String transValue = langTranslationHashMap.get(transKey);
                    provider.add(transKey, transValue);
                }
            }
        }
        provider.add(createCategoryKey(), getCategoryKey());
    }

    public static String createCategoryKey() {
        return "CATEGORY."+ XYKey.MODID+"."+ category;
    }

    public static String getCategoryKey() {
        return "XYKey";
    }
}
