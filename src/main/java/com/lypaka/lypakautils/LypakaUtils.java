package com.lypaka.lypakautils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = LypakaUtils.MOD_ID,
        name = LypakaUtils.MOD_NAME,
        version = LypakaUtils.VERSION,
        acceptableRemoteVersions = "*"
)
public class LypakaUtils {

    public static final String MOD_ID = "lypakautils";
    public static final String MOD_NAME = "LypakaUtils";
    public static final String VERSION = "0.0.2";
    public static final Logger logger = LogManager.getLogger("LypakaUtils");

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        logger.info("Loading LypakaUtils version: " + VERSION);

    }

    @Mod.EventHandler
    public void onPostInit (FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new JoinListener());

    }

    @Mod.EventHandler
    public void onServerStarted (FMLServerStartingEvent event) {

        WorldMap.load();

    }

}
