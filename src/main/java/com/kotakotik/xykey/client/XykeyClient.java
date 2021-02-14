package com.kotakotik.xykey.client;

import com.kotakotik.xykey.Xykey;
import com.kotakotik.xykey.datagen.DataGen;
import com.kotakotik.xykey.datagen.LangGen;
import com.kotakotik.xykey.events;
import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class XykeyClient implements ClientModInitializer {
//    public static final ArtificeResourcePack RESOURCE_PACK = Artifice.registerAssets("xykey:main");

    @Override
    public void onInitializeClient() {
        events.reg();
        Keybinds.createCategoryKey();
        DataGen.gen();
        CrowdinTranslate.downloadTranslations(Xykey.MODID);
    }
}
