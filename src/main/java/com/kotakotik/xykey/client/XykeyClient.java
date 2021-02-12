package com.kotakotik.xykey.client;

import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.datagen.DataGen;
import com.kotakotik.xykey.datagen.LangGen;
import com.kotakotik.xykey.events;
import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.impl.RuntimeResourcePackImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class XykeyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        events.reg();
        Keybinds.createCategoryKey();
        CrowdinTranslate.downloadTranslations(Xykey.MODID);
    }
}
