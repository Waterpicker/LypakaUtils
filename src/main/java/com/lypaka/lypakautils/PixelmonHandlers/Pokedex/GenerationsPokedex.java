package com.lypaka.lypakautils.PixelmonHandlers.Pokedex;

import com.pixelmongenerations.common.pokedex.Pokedex;
import com.pixelmongenerations.core.storage.PixelmonStorage;
import com.pixelmongenerations.core.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayerMP;

import java.text.DecimalFormat;

public class GenerationsPokedex {

    public static double getPercentage (EntityPlayerMP player) {

        PlayerStorage storage = PixelmonStorage.pokeBallManager.getPlayerStorage(player).get();
        return (double) (storage.pokedex.countCaught() / Pokedex.pokedexSize) * 100;

    }

    public static String getPercentageAsString (EntityPlayerMP player) {

        double percent = getPercentage(player);
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(percent) + "%";

    }

}
