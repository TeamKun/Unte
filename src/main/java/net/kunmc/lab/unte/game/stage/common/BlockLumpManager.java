package net.kunmc.lab.unte.game.stage.common;

import java.util.ArrayList;
import java.util.List;

public class BlockLumpManager {
    List<BlockLumpBase> blockLumps = new ArrayList<>();

    public void addBlockLump(BlockLumpBase blockLump){
        blockLumps.add(blockLump);
    }

    public void updateBlockLump(){
        for (BlockLumpBase blockLump: blockLumps){
            blockLump.updateBlock();
        }
    }
}
