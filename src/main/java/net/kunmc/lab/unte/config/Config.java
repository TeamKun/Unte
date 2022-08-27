package net.kunmc.lab.unte.config;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.LocationValue;
import net.kunmc.lab.configlib.value.StringValue;
import net.kunmc.lab.unte.command.CommandConst;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {
    public StringValue difficulty = new StringValue(CommandConst.GAME_MODE_TUTORIAL)
            .addAllowableString(CommandConst.GAME_MODE_NORMAL)
            .addAllowableString(CommandConst.GAME_MODE_HARD);
    public LocationValue startLocation = new LocationValue();

    public Config(@NotNull Plugin plugin) {
        super(plugin);
    }
}
