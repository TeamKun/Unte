package net.kunmc.lab.unte.game.stage.common;

import net.kunmc.lab.unte.Unte;
import net.kunmc.lab.unte.game.stage.StageConst;
import org.bukkit.Material;
import org.bukkit.World;

public class BlockLumpFactory {
    /**
     * 同時に処理したいブロックの塊
     * @param startX
     * @param startY
     * @param startZ
     * @param size
     * @param material
     * @param xDirect
     * @param zDirect
     * @param blockForm
     * @param blockType
     * @return
     */
    public static BlockLumpBase CreateBlockLump(int startX, int startY, int startZ, int size, Material material, int xDirect, int zDirect, String blockForm, String blockType) {
        World world = Unte.getPlugin().config.startLocation.value().getWorld();
        BlockLumpBase blockLumpBase = null;
        switch (blockForm) {
            case StageConst.BLOCK_LUMP_SIMPLE:
                blockLumpBase = new SimpleBlockLump(material, xDirect, zDirect, blockType);
                blockLumpBase.addBlock(world.getBlockAt(startX,startY,startZ), material);
                break;
        }
        //switch (form){
        //    case StageConst.BLOCK_MASS_BLOCK:
        //        for (int i = 0; i< size; i++) {
        //            blocks.add(world.getBlockAt(startX + i, startY, startZ));
        //            blocks.add(world.getBlockAt(startX + i, startY + 1, startZ));
        //        }
        //        break;
        //    case StageConst.BLOCK_LUMP_STRAIGHT:
        //        BlockLumpBase straightBlockLump = new StraightBlockLump();
        //        for (int i = 0; i< size; i++) {
        //            blocks.add(world.getBlockAt(startX, startY + 1, startZ + i));
        //        }
        //        break;
        //    default:
        //        blocks = new ArrayList<>();
        //}
        //return blocks;
        return blockLumpBase;
    }
}
