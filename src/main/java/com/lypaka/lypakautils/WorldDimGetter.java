package com.lypaka.lypakautils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.Arrays;

public class WorldDimGetter {

    public static int getDimID (World world, EntityPlayerMP player) {

        // I'm sorry to anyone who ever has to read what I'm about to do here.
        int dimensionID = -99999; // default value because what are the chances of their being a dimension with this ID? Very slim I'd say
        try {

            // We try it the fast way first
            String[] worldSplit = world.toString().split(", ");
            String dim = worldSplit[1];
            dimensionID = Integer.parseInt(dim.replace("DimensionId=", ""));

        } catch (IndexOutOfBoundsException er) {

            // But if that doesn't work then we unfortunately have to resort to this method
            WorldServer[] worlds = world.getMinecraftServer().worlds;
            for (WorldServer ws : worlds) {

                if (ws.loadedEntityList.size() > 0) {

                    for (Entity ent : ws.loadedEntityList) {

                        if (ent instanceof EntityPlayerMP) {

                            EntityPlayerMP p = (EntityPlayerMP) ent;
                            if (p.getName().equalsIgnoreCase(player.getName())) {

                                dimensionID = ws.provider.getDimension();
                                break;

                            }

                        }

                    }

                }

            }

        }

        return dimensionID;

    }

}
