package net.kunmc.lab.unte.game.stage.common;

import java.util.ArrayList;
import java.util.List;

public class BlockLumpManager {
    List<BlockLumpBase> blocks = new ArrayList<>();

    public void updateBlockLump(){
        for (BlockLumpBase blockLump: blocks){
            updateBlockLump();
        }
    }
}
