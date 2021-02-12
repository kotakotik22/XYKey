package com.kotakotik.xykey.datagen;

import com.kotakotik.xykey.Xykey;
import net.devtech.arrp.api.RRPCallback;

import java.io.File;
import java.nio.file.Paths;

public class DataGen {
    public static void gen() {
        File dir = new File("xykey");
        dir.mkdirs();
        LangGen.reg();
        Xykey.RESOURCE_PACK.dump();
        RRPCallback.EVENT.register(a -> a.add(Xykey.RESOURCE_PACK));
    }
}
