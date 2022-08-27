package net.kunmc.lab.unte.game.stage.common;

import org.bukkit.Material;
import org.bukkit.block.Block;
import java.util.List;

public class StraightBlockLump implements BlockLumpBase {
    private List<Block> blocks;
    private Material material;
    int xDirect;
    int zDirect;
    String type;

    public StraightBlockLump(List<Block> blocks, Material material, int xDirect, int zDirect, String type){
        this.blocks = blocks;
        this.material = material;
        this.xDirect = xDirect;
        this.zDirect = zDirect;
        this.type = type;

    }

    public void updateBlock(){
        for (Block block: blocks) {
            // TODO バリアブロックなどを考えて条件を増やす
            // 移動先を変更
            block.getLocation().add(1*xDirect,0,1*zDirect).getBlock().setType(material);
            // 移動元をAirに
            block.setType(Material.AIR);
        }
        // 配列操作
        for (int i=0; i < blocks.size() - 1; i++) {
            blocks.set(i, blocks.get(i+1));
        }
        blocks.set(blocks.size()-1, blocks.get(blocks.size()-1));
    }

    public void removeBlock(){
    }
}
