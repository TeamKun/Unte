package net.kunmc.lab.unte.game.stage.common;

import org.bukkit.Material;
import org.bukkit.block.Block;

interface BlockLumpBase {
    public void updateBlock();
    public void removeBlock();
    public void addBlock(Block block, Material material);
}
