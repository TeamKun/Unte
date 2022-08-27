package net.kunmc.lab.unte.game.stage.field;

import net.kunmc.lab.unte.Unte;
import org.bukkit.Location;

public class Cube {
    // 番号で頂点を表すとわからなくなるので気合いでカバー
    // 立方体の頂点8個をxyz,Xyz,xYzなどで表す
    // 小文字、大文字によって頂点の座標の0,1を分ける(x=0,y=0,z=0ならxyz, x=1,y=0,z=0ならXyz)

    public int[] xyz = {0,0,0};
    public int[] XYZ = {0,0,0};

    public Cube(int flameXZHalfSize, int flameYSize){
        Location origin = Unte.getPlugin().config.startLocation.value();
        int centerX = (int) origin.getX();
        int centerY = (int) origin.getY();
        int centerZ = (int) origin.getZ();

        int smallX = centerX - flameXZHalfSize;
        int bigX = centerX + flameXZHalfSize;
        int smallY = centerY;
        int bigY = centerY + flameYSize;
        int smallZ = centerZ - flameXZHalfSize;
        int bigZ = centerZ + flameXZHalfSize;

        xyz[0] = smallX; xyz[1]=smallY; xyz[2] = smallZ;
        XYZ[0] = bigX; XYZ[1]=bigY; XYZ[2] = bigZ;
    }
}
