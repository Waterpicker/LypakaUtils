package com.lypaka.lypakautils.PixelmonHandlers;

import com.lypaka.lypakautils.LypakaUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Loader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PixelmonVersionDetector {

    public static String VERSION;

    public static void detectPixelmonVersionIfAny (MinecraftServer server) throws FileNotFoundException {

        if (Loader.isModLoaded("pixelmon")) {

            Scanner scanner = new Scanner(server.getFile("/logs/latest.log"));
            boolean result = false;
            while (scanner.hasNext() && !result) {

                result = scanner.nextLine().contains("PixelmonGenerations");

            }
            scanner.close();

            if (result) {

                VERSION = "Generations";

            } else {

                VERSION = "Reforged";

            }

            LypakaUtils.logger.info("Detected Pixelmon version: " + VERSION);

        } else {

            VERSION = "None";

        }

    }

}
