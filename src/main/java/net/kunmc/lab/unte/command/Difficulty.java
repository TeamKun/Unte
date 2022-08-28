package net.kunmc.lab.unte.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.unte.game.UnteGameManager;

public class Difficulty extends Command {
    public Difficulty() {
        super(CommandConst.DIFFICULTY);
        argument(usageBuilder -> {
            usageBuilder.stringArgument(CommandConst.DIFFICULTY, suggestionBuilder -> {
                suggestionBuilder.suggest(CommandConst.GAME_MODE_TUTORIAL);
                suggestionBuilder.suggest(CommandConst.GAME_MODE_NORMAL);
                suggestionBuilder.suggest(CommandConst.GAME_MODE_HARD);
            });
        });
    }

    @Override
    public void execute(CommandContext ctx) {
        if (UnteGameManager.isRunning()) {
            ctx.sendFailure("ゲームを停止してから実行してください");
            return;
        }

        System.out.println(Difficulty.class.getName() + ": " + ctx.getArgs().get(0));
        ctx.sendSuccess("難易度を" + UnteGameManager.difficulty + "にしました");
    }
}
