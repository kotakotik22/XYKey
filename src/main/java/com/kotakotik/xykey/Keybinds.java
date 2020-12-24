package com.kotakotik.xykey;

import com.kotakotik.xykey.keybinds.Keybind;
import com.kotakotik.xykey.keybinds.SendPosition;
import com.kotakotik.xykey.keybinds.SendPositionToSelf;
import com.kotakotik.xykey.keybinds.SendWithName;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.HashMap;

public class Keybinds {
    public static final String category = "xykey";

    public static final SendPosition sendPosition = new SendPosition();
    public static final SendPositionToSelf sendPositionToSelf = new SendPositionToSelf();
    public static final SendWithName sendWithName = new SendWithName();

    public static final Keybind[] keybinds = new Keybind[]{
            sendPosition,
            sendPositionToSelf,
            sendWithName
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

    public static void langAddTranslations(LanguageProvider provider, String locale) {
        for(Keybind keybind : keybinds) {
            HashMap<String, String> translations = keybind.getLangNames();
            if(translations.containsKey(locale)) {
                provider.add(keybind.createKeyString(), translations.get(locale));
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
