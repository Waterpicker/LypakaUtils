package com.lypaka.lypakautils.ConfigurationLoaders;

import com.lypaka.lypakautils.LypakaUtils;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * Used to create a player-specific configuration loader system that creates a file per player to store player-specific values
 * Builds a config file per player based on a template file in the project's assets directory and adds it to a map for access later
 * Based on original design by landonjw of Pokemon Cobbled.
 * @author landonjw, Lypaka
 *
 */
public class PlayerConfigManager {

    private final String fileName;
    private final String folderName;
    private final Path configPath;
    private final Class mainClass;
    private final String modName;
    private final String modID;
    private final Logger logger;

    public PlayerConfigManager (String fileName, String folderName, Path configPath, Class mainClass, String modName, String modID, Logger logger) {

        this.fileName = fileName;
        this.folderName = folderName;
        this.configPath = configPath;
        this.mainClass = mainClass;
        this.modName = modName;
        this.modID = modID;
        this.logger = logger;

    }

    private Path mainPlayerDir;

    public void init() {

        this.mainPlayerDir = ConfigUtils.checkDir(Paths.get(".//config//" + this.modID + "//" + this.folderName));

    }

    public void loadPlayer (UUID uuid) {

        Path playerDir = ConfigUtils.checkDir(Paths.get(".//config//" + this.modID + "//" + this.folderName + "//" + uuid.toString()));
        if (ConfigUtils.playerConfig.containsKey(this.modID)) {

            Map<UUID, Path> map = ConfigUtils.playerConfig.get(this.modID);
            if (!map.containsKey(uuid)) {

                map.put(uuid, playerDir.resolve(this.fileName));
                ConfigUtils.playerConfig.put(this.modID, map);

            }

        } else {

            Map<UUID, Path> map = new HashMap<>();
            map.put(uuid, playerDir.resolve(this.fileName));
            ConfigUtils.playerConfig.put(this.modID, map);

        }

        try {

            if (!Files.exists(playerDir)) {

                Files.createDirectory(playerDir);

            }
           // Path filePath = this.configPath.resolve("//" + uuid.toString() + "//" + this.fileName); // fuck this shit, doing it the easier way
            Path filePath = Paths.get(".//config//" + this.modID + "//" + this.folderName + "//" + uuid.toString() + "//" + this.fileName);
            if (!filePath.toFile().exists()) {

                this.logger.info("Detected a missing account.conf file for " + uuid.toString() + "...creating a new one");
                Files.copy(this.mainClass.getClassLoader().getResourceAsStream("assets/" + this.modID + "/" + this.fileName), ConfigUtils.playerConfig.get(this.modID).get(uuid), StandardCopyOption.REPLACE_EXISTING);

            }

            Map<UUID, ConfigurationLoader<CommentedConfigurationNode>> loadMap = new HashMap<>();
            if (ConfigUtils.playerConfigLoad.containsKey(this.modID)) {

                loadMap = ConfigUtils.playerConfigLoad.get(this.modID);

            }
            loadMap.put(uuid, HoconConfigurationLoader.builder().setPath(ConfigUtils.playerConfig.get(this.modID).get(uuid)).build());
            ConfigUtils.playerConfigLoad.put(this.modID, loadMap);
            Map<UUID, CommentedConfigurationNode> nodeMap = new HashMap<>();
            if (ConfigUtils.playerConfigNode.containsKey(this.modID)) {

                nodeMap = ConfigUtils.playerConfigNode.get(this.modID);

            }
            nodeMap.put(uuid, HoconConfigurationLoader.builder().setPath(ConfigUtils.playerConfig.get(this.modID).get(uuid)).build().load());
            ConfigUtils.playerConfigNode.put(this.modID, nodeMap);

        } catch (IOException er) {

            this.logger.error(this.modName + " player account configuration could not load account for " + uuid.toString());

        }

    }

    public void savePlayer (UUID uuid) {

        try {

            ConfigUtils.playerConfigLoad.get(this.modID).get(uuid).save(ConfigUtils.playerConfigNode.get(this.modID).get(uuid));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public CommentedConfigurationNode getPlayerConfigNode (UUID uuid, Object... node) {

        System.out.println("uuid ==" + uuid.toString());
        System.out.println("this.modID == " + this.modID);
        if (ConfigUtils.playerConfigNode.containsKey(this.modID)) {

            System.out.println("Player configuration loader map contains key " + this.modID);
            Map<UUID, CommentedConfigurationNode> map = ConfigUtils.playerConfigNode.get(this.modID);
            if (map.containsKey(uuid)) {

                System.out.println("Player configuration loader map contains key " + this.modID + " and it contains key " + uuid);
                System.out.println("Value of commented configuration node inside of player uuid map: " + map.get(uuid));
                System.out.println("if ^ that is null, that's a big problem");
                if (map.get(uuid) != null) {

                    System.out.println("Value of commented configuration node inside of player uuid map was detected as not null!");
                    CommentedConfigurationNode ccn = map.get(uuid);
                    System.out.println("Looking for node " + node + " in player's commented configuration node gotten from player uuid map");
                    System.out.println("Value of node " + node + " == " + map.get(uuid).getNode(node));
                    System.out.println("if ^ that is null, then that's the problem");
                    if (map.get(uuid).getNode(node) != null) {

                        System.out.println("Detected that node " + node + " in the player uuid map is not null, printing value: ");
                        System.out.println(map.get(uuid).getNode(node));
                        System.out.println("IF NOTHING IS NULL AT THIS POINT.....BLAME WATERDUDE");

                    }

                }

            }

        }
        return ConfigUtils.playerConfigNode.get(this.modID).get(uuid).getNode(node);

    }

}
