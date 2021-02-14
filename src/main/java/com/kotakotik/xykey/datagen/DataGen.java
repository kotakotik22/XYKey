package com.kotakotik.xykey.datagen;

import com.kotakotik.xykey.client.XykeyClient;

import java.io.File;

public class DataGen {
    public static void gen() {
        File dir = new File("xykey");
        dir.mkdirs();
        LangGen.reg();

//        if(dump) {
//            XykeyClient.RESOURCE_PACK.dump();
//        }
//        RRPCallback.EVENT.register(a -> a.add(XykeyClient.RESOURCE_PACK));
    }
}
