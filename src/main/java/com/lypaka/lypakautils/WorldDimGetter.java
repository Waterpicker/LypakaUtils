package com.lypaka.lypakautils;

import net.minecraft.world.World;

public class WorldDimGetter {

    public static int getDimID (World world) {

        // I'm sorry to anyone who ever has to read what I'm about to do here.
        String[] worldSplit = world.toString().split(", ");
        String dim = worldSplit[1];
        int dimensionID = Integer.parseInt(dim.replace("DimensionId=", ""));
        return dimensionID;

    }

}
