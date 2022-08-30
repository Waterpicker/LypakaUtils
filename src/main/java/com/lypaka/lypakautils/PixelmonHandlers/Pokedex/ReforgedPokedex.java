package com.lypaka.lypakautils.PixelmonHandlers.Pokedex;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.pokedex.Pokedex;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import net.minecraft.entity.player.EntityPlayerMP;

import java.text.DecimalFormat;

public class ReforgedPokedex {

    public static double getPercentage (EntityPlayerMP player) {

        PlayerPartyStorage storage = Pixelmon.storageManager.getParty(player);
        return (double) (storage.pokedex.countCaught() / Pokedex.pokedexSize) * 100;

    }

    public static String getPercentageAsString (EntityPlayerMP player) {

        double percent = getPercentage(player);
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(percent) + "%";

    }

}
