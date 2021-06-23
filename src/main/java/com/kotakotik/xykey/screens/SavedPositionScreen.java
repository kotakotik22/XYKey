package com.kotakotik.xykey.screens;

import com.google.gson.Gson;
import com.kotakotik.xykey.client.Keybinds;
import com.kotakotik.xykey.keybinds.SavePosition;
import com.kotakotik.xykey.utils.CoordinateUtils;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class SavedPositionScreen extends CottonClientScreen {
    public static String readFile(Path target) throws IOException {
        try (BufferedReader bufferedreader = Files.newBufferedReader(target)) {
            return bufferedreader.lines().collect(Collectors.joining("\n"));
        }
    }

    public static String  readFile(String target) throws IOException {
        return readFile(Paths.get(target));
    }

    public SavedPositionScreen() throws IOException {
//        try(FileReader writer = new FileReader(file)) {
//            writer.write(new Gson().toJson(new SavedPosition(
//                    client.player.getPos(),
//                    date,
//                    client.player.world.getDimension().getSkyProperties().toString()
//            )));

        super(new LightweightGuiDescription() {
            class ListItem extends WPlainPanel {
                WButton name;
                WButton dimension;
                WButton coords;
                WButton date;
                WButton delete;
                String dateStr;

                public ListItem() {
                    MinecraftClient client = MinecraftClient.getInstance();
                    name = new WButton(new LiteralText("svelte > react")) {
                        @Override
                        public InputResult onClick(int x, int y, int button) {
                            super.onClick(x, y, button);
                            client.keyboard.setClipboard(getLabel().getString());
                            return InputResult.PROCESSED;
                        }
                    };
                    add(name, 0, 0, 200, 18);
                    dimension = new WButton(new LiteralText("overworld")) {
                        @Override
                        public InputResult onClick(int x, int y, int button) {
                            super.onClick(x, y, button);
                            client.keyboard.setClipboard(getLabel().getString());
                            return InputResult.PROCESSED;
                        }
                    };
                    add(dimension, 0, 20, 200, 18);
                    coords = new WButton(new LiteralText("0, 0, 0")) {
                        @Override
                        public InputResult onClick(int x, int y, int button) {
                            super.onClick(x, y, button);
                            client.keyboard.setClipboard(getLabel().getString());
                            return InputResult.PROCESSED;
                        }
                    };
                    add(coords, 0, 40, 200, 18);
                    date = new WButton(new LiteralText("November 26, 2016")) {
                        @Override
                        public InputResult onClick(int x, int y, int button) {
                            super.onClick(x, y, button);
                            client.keyboard.setClipboard(getLabel().getString());
                            return InputResult.PROCESSED;
                        }
                    };
                    add(date, 0, 60, 200, 18);
                    delete = new WButton(new TranslatableText("menu.xykey.delete")) {
                        @Override
                        public InputResult onClick(int x, int y, int button) {
                            super.onClick(x, y, button);
                            File file = null;
                            file = new File("xykey/saved_pos/" + dateStr + ".json");
                            System.out.println(file.getAbsolutePath());
                            file.delete();
                            try {
                                MinecraftClient.getInstance().openScreen(new SavedPositionScreen()); // reload gui
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                           return InputResult.PROCESSED;
                        }
                    };
                    add(delete, 50, 80, 100, 18);

                    this.setSize(1, 2*18);
                }
            }

            {
                File dir = new File("xykey/saved_pos");
                dir.mkdirs();

                List<SavePosition.SavedPosition> positionList = new ArrayList<>();

                for(File file : Objects.requireNonNull(dir.listFiles())) {
                    String json = readFile(file.toPath());
                    SavePosition.SavedPosition pos = new Gson().fromJson(json, SavePosition.SavedPosition.class);
                    positionList.add(pos);
                }

//                WGridPanel root = new WGridPanel();
//                setRootPanel(root);
//                root.setSize(150, 150);

                BiConsumer<SavePosition.SavedPosition, ListItem> configurator = (SavePosition.SavedPosition pos, ListItem item) -> {
                    item.name.setLabel(new LiteralText(pos.name));
                    Text dim = new LiteralText(pos.dimension);
                    switch (pos.dimension) {
                        case "minecraft:overworld":
                            dim = new TranslatableText("xykey.dimension.overworld");
                            break;
                        case "minecraft:the_end":
                            dim = new TranslatableText("xykey.dimension.end");
                            break;
                        case "minecraft:the_nether":
                            dim = new TranslatableText("xykey.dimension.nether");
                    }
                    item.dimension.setLabel(dim);
                    item.coords.setLabel(new LiteralText(CoordinateUtils.coordinateString(pos.x, pos.y, pos.z)));
                    try {
                        item.date.setLabel(new LiteralText(SavePosition.format.parse(pos.date).toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        item.date.setLabel(new LiteralText("error while trying to get date"));
                    }
                    item.dateStr = pos.date;
                };

                if(!positionList.isEmpty()) {
                    WListPanel<SavePosition.SavedPosition, ListItem> list = new WListPanel<>(positionList, ListItem::new, configurator);
                    list.setListItemHeight(120);
                    list.setSize(220, 150);
                    setRootPanel(list);
//                root.add(list, 0, 0, 10, 10)
//                ;

                    rootPanel.validate(this);
                } else {
                    WGridPanel root = new WGridPanel();
                    setRootPanel(root);
                    root.setSize(220, 150);
                    WLabel label = new WLabel(new TranslatableText("menu.xykey.saved_pos.no_saved", Keybinds.savePosition.getKeyBinding().getBoundKeyLocalizedText()));
                    label.setHorizontalAlignment(HorizontalAlignment.LEFT);
                    root.add(label, 0, 1);
                }
            }
        });
    }
}
