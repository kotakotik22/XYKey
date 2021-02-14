package com.kotakotik.xykey.keybinds;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.kotakotik.xykey.client.Keybind;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.dimension.DimensionType;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

        public SavedPosition(int x, int y, int z, String date, String dimension) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.date = date;
            this.dimension = dimension;
        }

        public SavedPosition(int x, int y, int z, Date date, String dimension) {
            this(x, y, z, format.format(date), dimension);
        }

        public SavedPosition(Vec3d pos, String date, String dimension) {
            this((int)pos.getX(), (int)pos.getY(), (int)pos.getZ(), date, dimension);
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
}
