//package net.kunmc.lab.unte.game.stage.field;
//
//import net.kunmc.lab.unte.Unte;
//import org.bukkit.Material;
//import org.bukkit.World;
//
//public class Flame {
//    private static final int flameXZHalfSize = 15;
//    private static final int flameYSize = 40;
//
//    public static void createFlame() {
//        World world = Unte.getPlugin().config.startLocation.value().getWorld();
//        int currentX = (int) Unte.getPlugin().config.startLocation.value().getX();
//        int currentY = (int) Unte.getPlugin().config.startLocation.value().getY();
//        int currentZ = (int) Unte.getPlugin().config.startLocation.value().getZ();
//
//        // 周りをバリアブロックで囲んで(BlackWallと同じ)から線を入れる
//
//        //// バリアブロックで囲む
//        for (int x = currentX - flameXZHalfSize; x <= currentX + flameXZHalfSize; x++) {
//            for (int y = currentY; y <= flameYSize + currentY; y++) {
//                for (int z = currentZ - flameXZHalfSize; z <= currentZ + flameXZHalfSize; z++) {
//                    if ((x == currentX - flameXZHalfSize || x == currentX + flameXZHalfSize ||
//                            y == currentY + flameYSize ||
//                            z == currentZ - flameXZHalfSize || z == currentZ + flameXZHalfSize)) {
//                        world.getBlockAt(x, y, z).setType(Material.BARRIER);
//                    }
//                }
//            }
//        }
//        //// 線を入れる
//        ///// いいロジックがわからんので二点を決めて間に線を引くことにする
//        int smallX = currentX - flameXZHalfSize;
//        int bigX = currentX + flameXZHalfSize;
//        int smallY = currentY;
//        int bigY = currentY + flameYSize;
//        int smallZ = currentZ - flameXZHalfSize;
//        int bigZ = currentZ + flameXZHalfSize;
//        int[][] pointAList = {{smallX, smallY, smallZ}, {smallX, smallY, smallZ}, {smallX, smallY, smallZ},
//                {bigX, smallY, smallZ},{smallX, smallY, bigZ},{smallX, smallY, bigZ},
//                {bigX, smallY, smallZ},{bigX, smallY, bigZ},{bigX, bigY, smallZ},
//                {smallX, bigY, smallZ},{smallX, bigY, smallZ},{smallX, bigY, bigZ}
//        };
//        int[][] pointBList = {{bigX, smallY, smallZ}, {smallX, bigY, smallZ}, {smallX, smallY, bigZ},
//                {bigX, smallY, bigZ},{bigX, smallY, bigZ},{smallX, bigY, bigZ},
//                {bigX, bigY, smallZ},{bigX, bigY, bigZ},{bigX, bigY, bigZ},
//                {bigX, bigY, smallZ},{smallX, bigY, bigZ},{bigX, bigY, bigZ},
//        };
//
//        for (int i = 0; i< pointAList.length; i++) {
//            int[] pointA = pointAList[i];
//            int[] pointB = pointBList[i];
//            for (int x = pointA[0]; x<= pointB[0];x++){
//                for (int y = pointA[1]; y<= pointB[1];y++){
//                    for (int z = pointA[2]; z<= pointB[2];z++){
//                        world.getBlockAt(x, y, z).setType(Material.WHITE_CONCRETE);
//                    }
//                }
//            }
//        }
//   }
//}
//