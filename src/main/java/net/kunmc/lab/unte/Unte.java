package net.kunmc.lab.unte;

import lombok.Getter;
import net.kunmc.lab.commandlib.CommandLib;
import net.kunmc.lab.configlib.ConfigCommand;
import net.kunmc.lab.configlib.ConfigCommandBuilder;
import net.kunmc.lab.unte.command.Main;
import net.kunmc.lab.unte.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class Unte extends JavaPlugin {

    @Getter
    private static Unte plugin;
    public Config config;

    @Override
    public void onEnable() {
        plugin = this;
        config = new Config(this);

        ConfigCommand configCommand = new ConfigCommandBuilder(config).build();
        CommandLib.register(this, new Main(configCommand));
    }

    @Override
    public void onDisable() {
    }
}
