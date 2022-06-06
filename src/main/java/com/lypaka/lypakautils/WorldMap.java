package com.lypaka.lypakautils;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    public static Map<String, World> worldMap = new HashMap<>();

    public static void load() {

        for (WorldServer ws : FMLCommonHandler.instance().getMinecraftServerInstance().worlds) {

            World w = ws.init();
            String worldName = w.getWorldInfo().getWorldName();
            worldMap.put(worldName, w);

        }

    }

}
