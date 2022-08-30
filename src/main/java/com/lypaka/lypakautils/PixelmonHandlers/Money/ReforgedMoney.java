package com.lypaka.lypakautils.PixelmonHandlers.Money;

import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraft.entity.player.EntityPlayerMP;

public class ReforgedMoney {

    public static int getBalance (EntityPlayerMP player) {

        int balance = 0;
        if (Pixelmon.moneyManager.getBankAccount(player.getUniqueID()).isPresent()) {

            balance = Pixelmon.moneyManager.getBankAccount(player.getUniqueID()).get().getMoney();

        }

        return balance;

    }

    public static void chargeMoney (EntityPlayerMP player, int cost) {

        Pixelmon.moneyManager.getBankAccount(player.getUniqueID()).get().changeMoney(cost);

    }

    public static void giveMoney (EntityPlayerMP player, int amount) {

        Pixelmon.moneyManager.getBankAccount(player.getUniqueID()).get().setMoney(getBalance(player) + amount);

    }

}
