package net.kunmc.lab.unte.game.stage.common;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockMove {
    /**
     * ブロック移動ロジック
     * @param blocks
     * @param material
     * @param xDirect
     * @param zDirect
     */
    public static List<Block> simpleMoveBlock(List<Block> blocks, Material material, int xDirect, int zDirect){
        List<Block> newBlocks = new ArrayList<>();
        for (Block block: blocks) {
            Block newBlock = block.getLocation().add(1 * xDirect, 0, 1 * zDirect).getBlock();
            newBlock.setType(material);
            newBlocks.add(newBlock);

            // 移動元をairに
            block.setType(Material.AIR);
        }
        return newBlocks;
    }
}
