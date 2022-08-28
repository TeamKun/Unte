package net.kunmc.lab.unte.game;

//import com.sk89q.worldedit.EditSession;
//import com.sk89q.worldedit.WorldEdit;
//import com.sk89q.worldedit.bukkit.BukkitWorld;
//import com.sk89q.worldedit.extent.clipboard.io.BuiltInClipboardFormat;
//import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
//import com.sk89q.worldedit.session.ClipboardHolder;
import net.kunmc.lab.unte.Unte;
import net.kunmc.lab.unte.command.CommandConst;
import net.kunmc.lab.unte.game.stage.common.BlockLumpManager;
import net.kunmc.lab.unte.game.stage.field.FieldManager;
import net.kunmc.lab.unte.game.stage.task.StageTask;
import net.kunmc.lab.unte.game.stage.tutorial.Stage;

import java.io.InputStream;

public class UnteGameManager {
    public static GameMode runningMode = GameMode.MODE_NEUTRAL;
    public static String difficulty = CommandConst.GAME_MODE_TUTORIAL;

    // キャラクターの画像とか作る場合はworldEditで対応
    //public static EditSession editSession;
    //public static ClipboardHolder simpleBlockClipHolder;
    //public static ClipboardHolder long2BlockClipHolder;
    //public static ClipboardHolder long3BlockClipHolder;
    //public static ClipboardHolder long4BlockClipHolder;

    public static void gameController(GameMode mode) {
        runningMode = mode;
        switch (runningMode) {
            case MODE_START:
                FieldManager.setupField();
                //setupWorldEditResource();
                Stage stage = new Stage(new BlockLumpManager(), FieldManager.flameCube);
                stage.updateStage(10);
                StageTask stageTask = new StageTask(stage);
                stageTask.stageRunnable();
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

    //public static void setupWorldEditResource() {
    //    try {
    //        editSession = WorldEdit.getInstance().newEditSession(new BukkitWorld(Unte.getPlugin().config.startLocation.value().getWorld()));
    //        InputStream long2BlockSchem = Unte.getPlugin().getResource("hogehoge.schem");
    //        ClipboardReader reader = BuiltInClipboardFormat.SPONGE_SCHEMATIC.getReader(long2BlockSchem);
    //        long2BlockClipHolder = new ClipboardHolder(reader.read());
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //}
}
