package net.kunmc.lab.unte.game;

import net.kunmc.lab.unte.command.CommandConst;
import net.kunmc.lab.unte.game.stage.field.FieldManager;

public class GameManager {
    public static GameMode runningMode = GameMode.MODE_NEUTRAL;
    public static String difficulty = CommandConst.GAME_MODE_TUTORIAL;

    public static void gameController(GameMode runningMode) {
        runningMode = runningMode;
        switch (runningMode) {
            case MODE_START:
                FieldManager.setupField();
                break;
            case MODE_NEUTRAL:
                break;
        }
    }

    public enum GameMode {
        MODE_START,
        MODE_NEUTRAL
    }

    public static boolean isRunning() {
        return runningMode == GameMode.MODE_START;
    }
}
