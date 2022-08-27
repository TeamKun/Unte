package net.kunmc.lab.unte.game.stage.field;

import net.kunmc.lab.unte.Unte;
import org.bukkit.Material;
import org.bukkit.World;

public class FieldManager {
    public static final int flameXZHalfSize=20;
    public static final int flameYSize=40;

    public static final int wallXZHalfSize = 30;
    public static final int wallYHalfSize = 50;

    public static Cube blackWallCube = new Cube(wallXZHalfSize, wallYHalfSize);
    public static Cube flameCube = new Cube(flameXZHalfSize, flameYSize);

    public static void setupField() {
        // フィールドの中心点(Yについては使用の利便性から上方向に伸びる点に注意)
        createBlackWall();
        createFlame();
    }

    public static void createBlackWall() {
        World world = Unte.getPlugin().config.startLocation.value().getWorld();
        for (int x = blackWallCube.xyz[0]; x <= blackWallCube.XYZ[0]; x++) {
            for (int y = blackWallCube.xyz[1]; y <= blackWallCube.XYZ[1]; y++) {
                for (int z = blackWallCube.xyz[2]; z <= blackWallCube.XYZ[2]; z++) {
                    if ((x == blackWallCube.xyz[0] || x == blackWallCube.XYZ[0] ||
                            y == blackWallCube.xyz[1] || y == blackWallCube.XYZ[1] ||
                            z == blackWallCube.xyz[2] || z == blackWallCube.XYZ[2])) {
                        world.getBlockAt(x, y, z).setType(Material.BLACK_CONCRETE);
                    } else {
                        world.getBlockAt(x, y, z).setType(Material.AIR);
                    }
                }
            }
        }
    }

    public static void createFlame() {
        World world = Unte.getPlugin().config.startLocation.value().getWorld();
        // 周りをバリアブロックで囲んで(BlackWallと同じ)から線を入れる
        //// バリアブロックで囲む
        for (int x = flameCube.xyz[0]; x <= flameCube.XYZ[0]; x++) {
            for (int y = flameCube.xyz[1]; y <= flameCube.XYZ[1]; y++) {
                for (int z = flameCube.xyz[2]; z <= flameCube.XYZ[2]; z++) {
                    if ((x == flameCube.xyz[0] || x == flameCube.XYZ[0] ||
                            y == flameCube.XYZ[1] ||
                            z == flameCube.xyz[2] || z == flameCube.XYZ[2])) {
                        world.getBlockAt(x, y, z).setType(Material.BARRIER);
                    }
                }
            }
        }
        //// 線を入れる
        ////// 立方体にの直線は12本、適当なpointA, Bの2点間にブロックを置いて立方体の格子を作る
        int[][] pointAList = {
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.XYZ[2]},
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.xyz[1],flameCube.xyz[2]},
                {flameCube.XYZ[0],flameCube.xyz[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.XYZ[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.XYZ[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.XYZ[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.XYZ[1],flameCube.XYZ[2]}
        };
        int[][] pointBList = {
                {flameCube.XYZ[0],flameCube.xyz[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.XYZ[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.xyz[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.xyz[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.xyz[1],flameCube.XYZ[2]},
                {flameCube.xyz[0],flameCube.XYZ[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.XYZ[1],flameCube.xyz[2]},
                {flameCube.XYZ[0],flameCube.XYZ[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.XYZ[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.XYZ[1],flameCube.xyz[2]},
                {flameCube.xyz[0],flameCube.XYZ[1],flameCube.XYZ[2]},
                {flameCube.XYZ[0],flameCube.XYZ[1],flameCube.XYZ[2]}
        };

        for (int i = 0; i< pointAList.length; i++) {
            int[] pointA = pointAList[i];
            int[] pointB = pointBList[i];
            for (int x = pointA[0]; x<= pointB[0];x++){
                for (int y = pointA[1]; y<= pointB[1];y++){
                    for (int z = pointA[2]; z<= pointB[2];z++){
                        world.getBlockAt(x, y, z).setType(Material.WHITE_CONCRETE);
                    }
                }
            }
        }
    }
}
