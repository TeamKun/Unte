package net.kunmc.lab.unte.game.stage.task;

import net.kunmc.lab.unte.Unte;
import net.kunmc.lab.unte.game.stage.StageBase;
import net.kunmc.lab.unte.game.stage.common.BlockLumpManager;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class StageTask {
    private static BukkitTask stageTask;
    private int timer = 0;
    StageBase stage;

    public StageTask(StageBase stage){
        this.stage = stage;
    }

    public void stageRunnable() {
        stageTask = new BukkitRunnable() {
            @Override
            public void run() {
                stage.updateStage(timer);
                timer+=1;
            }
        }.runTaskTimer(Unte.getPlugin(), 0, 20); // 固定する
    }
}
