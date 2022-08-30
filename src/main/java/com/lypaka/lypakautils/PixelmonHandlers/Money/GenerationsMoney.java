package com.lypaka.lypakautils.PixelmonHandlers.Money;

import com.pixelmongenerations.core.storage.PixelmonStorage;
import net.minecraft.entity.player.EntityPlayerMP;

public class GenerationsMoney {

    public static int getBalance (EntityPlayerMP player) {

        int balance = 0;
        if (PixelmonStorage.pokeBallManager.getPlayerStorage(player).isPresent()) {

            balance = PixelmonStorage.pokeBallManager.getPlayerStorage(player).get().getAccountHolder().getBalance();

        }

        return balance;

    }

    public static void chargeMoney (EntityPlayerMP player, int cost) {

        PixelmonStorage.pokeBallManager.getPlayerStorage(player).get().getAccountHolder().withdraw(cost);

    }

    public static void giveMoney (EntityPlayerMP player, int amount) {

        PixelmonStorage.pokeBallManager.getPlayerStorage(player).get().getAccountHolder().deposit(amount);

    }

}
