package net.kunmc.lab.unte.command;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.configlib.ConfigCommand;

public class Main extends Command {
    public Main(ConfigCommand configCommand) {
        super(CommandConst.MAIN);
        addChildren(new Start(), new Stop(), new Difficulty(), configCommand);
    }
}
