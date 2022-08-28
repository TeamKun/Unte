package net.kunmc.lab.unte.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.unte.game.UnteGameManager;

public class Stop extends Command {
    public Stop() {
        super(CommandConst.STOP);
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!UnteGameManager.isRunning()) {
            ctx.sendFailure("開始されていません");
            return;
        }

        UnteGameManager.gameController(UnteGameManager.GameMode.MODE_NEUTRAL);
        ctx.sendSuccess("終了しました");
    }
}
