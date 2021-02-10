package com.kotakotik.xykey.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CoordinateUtils {
    public static String coordinateString(int x, int y, int z) {
        return x + ", " + y + ", " + z;
    }

    public static String coordinateString(BlockPos pos) {
        return coordinateString(pos.getX(), pos.getY(), pos.getZ());
    }

    public static String coordinateString(Vec3d vec3d) {
        return coordinateString(new BlockPos(vec3d));
    }

    public static String coordinateString(Entity entity) {
        return coordinateString(entity.getPos());
    }
}
