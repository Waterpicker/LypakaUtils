package com.lypaka.lypakautils.PixelmonHandlers;

import com.pixelmongenerations.core.util.helper.RandomHelper;

import java.util.List;

public class RandomHandler {

    public static boolean getRandomChance (double chance) {

        if (PixelmonVersionDetector.VERSION.equalsIgnoreCase("Generations")) {

            return RandomHelper.getRandomChance(chance);

        } else {

            return com.pixelmonmod.pixelmon.RandomHelper.getRandomChance(chance);

        }

    }

    public static int getRandomNumberBetween (int min, int max) {

        if (PixelmonVersionDetector.VERSION.equalsIgnoreCase("Generations")) {

            return RandomHelper.getRandomNumberBetween(min, max);

        } else {

            return com.pixelmonmod.pixelmon.RandomHelper.getRandomNumberBetween(min, max);

        }

    }

    public static <T> T getRandomElementFromList (List<T> list) {

        if (PixelmonVersionDetector.VERSION.equalsIgnoreCase("Generations")) {

            return RandomHelper.getRandomElementFromList(list);

        } else {

            return com.pixelmonmod.pixelmon.RandomHelper.getRandomElementFromList(list);

        }

    }

}
