package net.kunmc.lab.unte.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.unte.Unte;
import net.kunmc.lab.unte.game.UnteGameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Start extends Command {
    public Start() {
        super(CommandConst.START);
    }

    @Override
    public void execute(CommandContext ctx) {
        System.out.println("AAAAA");
        if (UnteGameManager.isRunning()) {
            System.out.println("BBBB");
            ctx.sendFailure("既に開始しています");
            return;
        }

        // coordinateモードの初期値設定がされてなければコマンド実行者のplayerの位置を入れるようにする
        Player player = Bukkit.getPlayer(ctx.getSender().getName());
        if (Unte.getPlugin().config.startLocation.value() == null && player != null) {
            Unte.getPlugin().config.startLocation.value(player.getLocation());
        }

        UnteGameManager.gameController(UnteGameManager.GameMode.MODE_START);
        ctx.sendSuccess("開始しました");
    }
}
