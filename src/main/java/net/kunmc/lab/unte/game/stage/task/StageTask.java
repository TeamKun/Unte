package net.kunmc.lab.unte.game.stage.task;

import net.kunmc.lab.unte.Unte;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class StageTask {
    private static BukkitTask stageTask;
    private int timer = 0;
    public void stageRunnable() {
        stageTask = new BukkitRunnable() {
            @Override
            public void run() {
                timer+=1;
            }
        }.runTaskTimer(Unte.getPlugin(), 0, 1); // 固定する
    }
}
