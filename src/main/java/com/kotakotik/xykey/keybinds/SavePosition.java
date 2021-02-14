package com.kotakotik.xykey.keybinds;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.kotakotik.xykey.client.Keybind;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SavePosition extends Keybind {
    public static class SavedPosition {
        @SerializedName("x")
        public int x;
        @SerializedName("y")
        public int y;
        @SerializedName("z")
        public int z;

        @SerializedName("date")
        public String date;

        @SerializedName("dimension")
        public String dimension;

        @SerializedName("name")
        public String name;

        public SavedPosition(int x, int y, int z, String date, String dimension, String name) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.date = date;
            this.dimension = dimension;
            this.name = name;
        }

        public SavedPosition(int x, int y, int z, Date date, String dimension) {
            this(x, y, z, format.format(date), dimension, "Untitled");
        }

        public SavedPosition(Vec3d pos, String date, String dimension) {
            this((int)pos.getX(), (int)pos.getY(), (int)pos.getZ(), date, dimension, "Untitled");
        }

        public SavedPosition(Vec3d pos, Date date, String dimension) {
            this(pos, format.format(date), dimension);
        }
    }

    @Override
    public String getName() {
        return "save_position";
    }

    @Override
    public String getEnglish() {
        return "Save position";
    }

    @Override
    public int getDefaultKey() {
        return GLFW.GLFW_KEY_Y;
    }

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");

    @Override
    public void onPressed(MinecraftClient client) {
        File dir = new File("xykey/saved_pos");
        dir.mkdirs();
        Date date = new Date();
        File file = new File(dir.getAbsolutePath() + "/" + format.format(date) + ".json");
        try(FileWriter writer = new FileWriter(file)) {
//            System.out.println(new Gson().toJson(new SavedPosition(
//                    client.player.getPos(),
//                    date,
//                    client.player.world.getDimension().getSkyProperties().toString()
//            )));
            writer.write(new Gson().toJson(new SavedPosition(
                    client.player.getPos(),
                    date,
                    client.player.world.getDimension().getSkyProperties().toString()
            )));
        } catch (IOException e) {
            e.printStackTrace();
            client.player.sendMessage(new LiteralText("" + Formatting.RED + Formatting.BOLD + "Error while trying to save position file! Check logs"), false);
        }
    }

    @Override
    public void createTranslations(HashMap<String, String> map) {
        map.put("menu.xykey.saved_pos", "Saved XYK positions");
        map.put("xykey.dimension.overworld", "Overworld");
        map.put("xykey.dimension.nether", "Nether");
        map.put("xykey.dimension.end", "The end");
    }
}
