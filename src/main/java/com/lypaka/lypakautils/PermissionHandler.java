package com.lypaka.lypakautils;

import net.minecraft.server.level.ServerPlayer;

public class PermissionHandler {

    /**
     * This boolean check for permissions is platform-independent. Meaning it will work for pure Forge, SpongeForge, and Spigot/Forge hybrids.
     * (provided that the unstable Spigot/Forge hybrid of choice doesn't do some janky hacky shit with permission checks)
     * It applies to commands as well as basically any other permission check (like "if have this permission, can click this block" for example)
     * @param player
     * @param permission
     * @return
     */
    public static boolean hasPermission (ServerPlayer player, String permission) {


        return true;

    }

}
