package net.kunmc.lab.unte.game.stage.tutorial;

import net.kunmc.lab.unte.game.stage.common.BlockLumpManager;

public class Stage {
    // ステージ進行メインロジック
    BlockLumpManager blockLumpManager;

    public Stage(BlockLumpManager blockLumpManager){
        this.blockLumpManager = blockLumpManager;
    }

    public void updateStage(int timer){
        switch (timer){
            case 10:
        }
    }
}
