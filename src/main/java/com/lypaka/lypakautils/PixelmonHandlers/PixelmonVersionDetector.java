package com.lypaka.lypakautils.PixelmonHandlers;

import com.lypaka.lypakautils.LypakaUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Loader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PixelmonVersionDetector {

    public static String VERSION = "None";

    public static void detectPixelmonVersionIfAny() {

        if (Loader.isModLoaded("pixelmon")) {

            Class pixelmonClass;
            try {

                pixelmonClass = Class.forName("com.pixelmonmod.pixelmon.Pixelmon");
                VERSION = "Reforged";

            } catch (ClassNotFoundException e) {

                LypakaUtils.logger.info("Couldn't detect Pixelmon Reforged class file, searching for Pixelmon Generations class file...");
                try {

                    pixelmonClass = Class.forName("com.pixelmongenerations.core.Pixelmon");
                    VERSION = "Generations";

                } catch (ClassNotFoundException er) {

                    LypakaUtils.logger.info("Couldn't detect Pixelmon Reforged or Pixelmon Generations class file, setting version to None");

                }

            }

            LypakaUtils.logger.info("Detected Pixelmon version: " + VERSION);

        }

    }

}
