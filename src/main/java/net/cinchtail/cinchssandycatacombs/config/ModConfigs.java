package net.cinchtail.cinchssandycatacombs.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import static net.cinchtail.cinchssandycatacombs.CinchsSandyCatacombs.MOD_ID;

public class ModConfigs {

    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH =
            FabricLoader.getInstance().getConfigDir().resolve("cinchssandycatacombs.json");

    public static boolean configMissing = false;

    public static boolean enableHuskSandDrops;
    public static boolean enableParchedSandDrops;
    public static boolean enableCamelHuskSandDrops;
    public static boolean enableStraySnowBallDrops;
    public static boolean enableBoggedMossBlockDrops;

    private static boolean getOrDefaultBooleon(JsonObject json, String key, boolean defaultValue) {
        return json.has(key) ? json.get(key).getAsBoolean() : defaultValue;
    }

    public static void load() {
        try {
            JsonObject json;
            if (!Files.exists(CONFIG_PATH)) {
                configMissing = true;
                generateDefault();
                return;
            }

            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                json = GSON.fromJson(reader, JsonObject.class);
            }

            enableHuskSandDrops = getOrDefaultBooleon(json, "enableHuskSandDrops", true);
            enableParchedSandDrops = getOrDefaultBooleon(json, "enableParchedSandDrops", true);
            enableCamelHuskSandDrops = getOrDefaultBooleon(json, "enableCamelHuskSandDrops", true);
            enableCamelHuskSandDrops = getOrDefaultBooleon(json, "enableStraySnowBallDrops", false);
            enableCamelHuskSandDrops = getOrDefaultBooleon(json, "enableBoggedMossBlockDrops", false);

            boolean updated = false;

            updated |= patchMissing(json, "enableHuskSandDrops", enableHuskSandDrops);
            updated |= patchMissing(json, "enableParchedSandDrops", enableParchedSandDrops);
            updated |= patchMissing(json, "enableCamelHuskSandDrops", enableCamelHuskSandDrops);
            updated |= patchMissing(json, "enableStraySnowBallDrops", enableStraySnowBallDrops);
            updated |= patchMissing(json, "enableBoggedMossBlockDrops", enableBoggedMossBlockDrops);
            if (updated) {
                rewriteConfig(json);
            }

        } catch (Exception e) {
            LOGGER.error("Failed to read config, regenerating defaults", e);
            generateDefault();
        }
    }

    private static void generateDefault() {
        try {
            JsonObject json = new JsonObject();

            json.addProperty("enableHuskSandDrops", true);
            json.addProperty("enableParchedSandDrops", true);
            json.addProperty("enableCamelHuskSandDrops", true);
            json.addProperty("enableStraySnowBallDrops", false);
            json.addProperty("enableBoggedMossBlockDrops", false);

            enableHuskSandDrops = true;
            enableParchedSandDrops = true;
            enableCamelHuskSandDrops = true;
            enableStraySnowBallDrops = false;
            enableBoggedMossBlockDrops = false;

            Files.createDirectories(CONFIG_PATH.getParent());

            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
                GSON.toJson(json, writer);
            }

        } catch (IOException e) {
            LOGGER.error("Failed to generate default config", e);
        }
    }

    private static boolean patchMissing(JsonObject json, String key, boolean value) {
        if (!json.has(key)) {
            json.addProperty(key, value);
            return true;
        }
        return false;
    }

    private static void rewriteConfig(JsonObject json) {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(json, writer);
        } catch (IOException e) {
            LOGGER.error("Failed to rewrite config", e);
        }
    }
}