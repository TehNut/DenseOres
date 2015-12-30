package com.rwtema.denseores;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// TODO: Implement this instead of using the Forge config file. Need to write a system to convert the old config.
public class JsonConfigHandler {

    public static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().disableHtmlEscaping().create();
    private static Map<String, DenseOre> denseOreMap = new HashMap<String, DenseOre>();

    public static void init(File jsonConfig, File oldConfig) {
        try {
            Map<String, DenseOre> defaultMap = new HashMap<String, DenseOre>();

            if (oldConfig.exists()) {
                Configuration config = new Configuration(oldConfig);
                defaultMap = convertOldConfiguration(config);
            }

            if (!jsonConfig.exists() && jsonConfig.createNewFile() && !oldConfig.exists())
                defaultMap = getDefaultConfiguration();

            String json = gson.toJson(defaultMap, new TypeToken<Map<String, DenseOre>>(){ }.getType());
            FileWriter writer = new FileWriter(jsonConfig);
            writer.write(json);
            writer.close();

            denseOreMap = gson.fromJson(new FileReader(jsonConfig), new TypeToken<Map<String, DenseOre>>(){ }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, DenseOre> getDefaultConfiguration() {
        Map<String, DenseOre> defaultMap = new HashMap<String, DenseOre>();
        defaultMap.put("block_0", new DenseOre(0, "minecraft:iron_ore", 0, 1, "stone", "iron_ore", 0, 0));
        defaultMap.put("block_1", new DenseOre(1, "minecraft:gold_ore", 0, 1, "stone", "gold_ore", 0, 0));
        defaultMap.put("block_2", new DenseOre(2, "minecraft:lapis_ore", 0, 1, "stone", "lapis_ore", 0, 0));
        defaultMap.put("block_3", new DenseOre(3, "minecraft:diamond_ore", 0, 1, "stone", "diamond_ore", 0, 0));
        defaultMap.put("block_4", new DenseOre(4, "minecraft:emerald_ore", 0, 1, "stone", "emerald_ore", 0, 0));
        defaultMap.put("block_5", new DenseOre(5, "minecraft:redstone_ore", 0, 1, "stone", "redstone_ore", 0, 0));
        defaultMap.put("block_6", new DenseOre(6, "minecraft:coal_ore", 0, 1, "stone", "coal_ore", 0, 0));
        defaultMap.put("block_7", new DenseOre(7, "minecraft:quartz_ore", 0, 1, "netherrack", "quartz_ore", 0, 0));
        return defaultMap;
    }

    public static Map<String, DenseOre> convertOldConfiguration(Configuration config) {
        final String CATEGORY_BLOCK = "ores.block_";

        Map<String, DenseOre> defaultMap = new HashMap<String, DenseOre>();
        for (String cat : config.getCategoryNames()) {
            if (cat.startsWith(CATEGORY_BLOCK)) {
                try {
                    int id = Integer.parseInt(cat.substring(CATEGORY_BLOCK.length()));

                    if (config.hasKey(cat, "requiredMod") && !config.get(cat, "requiredMod", "").getString().equals("") && !Loader.isModLoaded(config.get(cat, "requiredMod", "").getString()))
                        continue;

                    if (!DenseOresRegistry.hasEntry(id) && config.hasKey(cat, "baseBlock") && config.hasKey(cat, "baseBlockTexture")) {

                        DenseOre denseOre = new DenseOre(
                                id,
                                config.get(cat, "baseBlock", "").getString().trim(),
                                config.get(cat, "baseBlockMeta", 0).getInt(0),
                                config.get(cat, "denseOreProbability", 1).getDouble(1),
                                config.get(cat, "underlyingBlock", "stone").getString().trim(),
                                config.get(cat, "baseBlockTexture", "").getString().trim(),
                                config.get(cat, "retroGenId", 0).getInt(),
                                config.get(cat, "renderType", 0).getInt(0)
                        );

                        if (config.hasKey(cat, "underlyingBlockTexture"))
                            denseOre.underlyingBlocktexture = config.get(cat, "underlyingBlockTexture", denseOre.baseBlock).getString();

                        if (defaultMap.size() < 16)
                            defaultMap.put(cat, denseOre);

                    }
                } catch (NumberFormatException e) {
                    // not an integer
                }
            }
        }
        return defaultMap;
    }

    public static Map<String, DenseOre> getDenseOreMap() {
        return denseOreMap;
    }
}
