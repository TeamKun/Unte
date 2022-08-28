package net.kunmc.lab.unte.game.stage.tutorial;

import net.kunmc.lab.unte.Unte;
import net.kunmc.lab.unte.game.stage.StageBase;
import net.kunmc.lab.unte.game.stage.StageConst;
import net.kunmc.lab.unte.game.stage.common.BlockLumpFactory;
import net.kunmc.lab.unte.game.stage.common.BlockLumpManager;
import net.kunmc.lab.unte.game.stage.field.Cube;
import org.bukkit.Material;
import org.bukkit.World;

public class Stage implements StageBase {
    // ステージ進行メインロジック
    BlockLumpManager blockLumpManager;
    Cube cube;

    public Stage(BlockLumpManager blockLumpManager, Cube cube){
        this.blockLumpManager = blockLumpManager;
        this.cube = cube;
    }

    public void updateStage(int timer){
        // csvに変える
        System.out.println(timer);
        switch (timer){
            case 10:
            case 30:
            case 20:
                blockLumpManager.addBlockLump(
                        BlockLumpFactory.CreateBlockLump(cube.xyz[0], cube.xyz[1],cube.xyz[2], 1,
                                Material.WHITE_CONCRETE,1,0,StageConst.BLOCK_LUMP_SIMPLE, "hogehoge"));
        }
        blockLumpManager.updateBlockLump();
    }
}
