//package net.kunmc.lab.unte.game.stage.field;
//
//import net.kunmc.lab.unte.Unte;
//import org.bukkit.Material;
//import org.bukkit.World;
//
//public class BlackWall {
//    private static final int flameXZHalfSize = 20;
//    private static final int flameYSize = 50;
//
//    public static void createFlame() {
//        World world = Unte.getPlugin().config.startLocation.value().getWorld();
//        int currentX = (int) Unte.getPlugin().config.startLocation.value().getX();
//        int currentY = (int) Unte.getPlugin().config.startLocation.value().getY();
//        int currentZ = (int) Unte.getPlugin().config.startLocation.value().getZ();
//        for (int x = currentX - flameXZHalfSize; x <= currentX + flameXZHalfSize; x++) {
//            for (int y = currentY; y <= flameYSize + currentY; y++) {
//                for (int z = currentZ - flameXZHalfSize; z <= currentZ + flameXZHalfSize; z++) {
//                    if ((x == currentX - flameXZHalfSize || x == currentX + flameXZHalfSize ||
//                            y == currentY || y == currentY + flameYSize ||
//                            z == currentZ - flameXZHalfSize || z == currentZ + flameXZHalfSize)) {
//                        world.getBlockAt(x, y, z).setType(Material.BLACK_CONCRETE);
//                    } else {
//                        world.getBlockAt(x, y, z).setType(Material.AIR);
//                    }
//                }
//            }
//        }
//    }
//}
//