package com.lypaka.lypakautils;

import com.lypaka.lypakautils.ConfigurationLoaders.WebsiteConfigManager;
import com.lypaka.lypakautils.PixelmonHandlers.PixelmonVersionDetector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Mod(
        modid = LypakaUtils.MOD_ID,
        name = LypakaUtils.MOD_NAME,
        version = LypakaUtils.VERSION,
        acceptableRemoteVersions = "*"
)
public class LypakaUtils {

    public static final String MOD_ID = "lypakautils";
    public static final String MOD_NAME = "LypakaUtils";
    public static final String VERSION = "0.0.6";
    public static final Logger logger = LogManager.getLogger("LypakaUtils");
    public static WebsiteConfigManager websiteConfigManager;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) throws MalformedURLException {

        logger.info("Loading LypakaUtils version: " + VERSION);
        //websiteConfigManager = new WebsiteConfigManager("http://lypaka.com/verified.php");
        //websiteConfigManager.build();

    }

    @Mod.EventHandler
    public void onPostInit (FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new JoinListener());
        PixelmonVersionDetector.detectPixelmonVersionIfAny();

    }

    @Mod.EventHandler
    public void onServerStarting (FMLServerStartingEvent event) throws FileNotFoundException {

        WorldMap.load();

    }

}
