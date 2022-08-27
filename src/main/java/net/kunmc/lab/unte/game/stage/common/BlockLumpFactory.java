package net.kunmc.lab.unte.game.stage.common;

import net.kunmc.lab.unte.game.stage.StageConst;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockLumpFactory {
    /**
     * 同時に処理したいブロックの塊
     * @param form
     * @param startX
     * @param startY
     * @param size それぞれのcaseで定義が変わる
     * @return
     */
    public static List<Block> CreateBlockMass(String form, World world, int startX, int startY, int startZ, int size) {
        List<Block> blocks;
        switch (form){
            case StageConst.BLOCK_MASS_BLOCK:
                blocks = new ArrayList<>();
                for (int i = 0; i< size; i++) {
                    blocks.add(world.getBlockAt(startX + i, startY, startZ));
                    blocks.add(world.getBlockAt(startX + i, startY + 1, startZ));
                }
                break;
            case StageConst.BLOCK_MASS_STRAIGHT:
                blocks = new ArrayList<>();
                for (int i = 0; i< size; i++) {
                    blocks.add(world.getBlockAt(startX, startY + 1, startZ + i));
                }
                break;
            default:
                blocks = new ArrayList<>();
        }
        return blocks;
    }
}
