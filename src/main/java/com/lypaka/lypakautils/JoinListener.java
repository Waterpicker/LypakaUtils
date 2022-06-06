package com.lypaka.lypakautils;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JoinListener {

    /**
     * Used to store all actively online players
     * I know Forge has a way to do this, but I'm not particularly fond of how it works
     * To enable its use, just register this class on the MinecraftForge EVENT_BUS somewhere in your project.
     */
    public static Map<UUID, EntityPlayerMP> playerMap = new HashMap<>();

    @SubscribeEvent
    public void onJoin (PlayerEvent.PlayerLoggedInEvent event) {

        playerMap.put(event.player.getUniqueID(), (EntityPlayerMP) event.player);

    }

    @SubscribeEvent
    public void onLeave (PlayerEvent.PlayerLoggedOutEvent event) {

        playerMap.entrySet().removeIf(entry -> entry.getKey().toString().equalsIgnoreCase(event.player.getUniqueID().toString()));

    }

}
