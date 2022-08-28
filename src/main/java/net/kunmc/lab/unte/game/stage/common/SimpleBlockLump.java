package net.kunmc.lab.unte.game.stage.common;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class SimpleBlockLump implements BlockLumpBase{
    private List<Block> blocks = new ArrayList<>();
    private Material material;
    int xDirect;
    int zDirect;
    String blockType; // 透過できるブロック（ダメージを受けるブロックかどうか）

    public SimpleBlockLump(Material material, int xDirect, int zDirect, String blockType){
        this.material = material;
        this.xDirect = xDirect;
        this.zDirect = zDirect;
        this.blockType = blockType;
    }

    public void addBlock(Block block, Material material){
        blocks.add(block);
        block.setType(material);
    }

    public void updateBlock(){
        // ブロック移動
        blocks = BlockMove.simpleMoveBlock(blocks, material, xDirect, zDirect);
    }

    public void removeBlock(){
    }
}
