package me.songe.castlestars;

import me.songe.castlestars.config.ConfigProvider;
import me.songe.castlestars.config.DatabaseCredentialsConfigProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class CastleStarsPlugin extends JavaPlugin {

    ConfigProvider databaseCredentialsConfigProvider;


    @Override
    public void onEnable() {
        databaseCredentialsConfigProvider = new DatabaseCredentialsConfigProvider(getDataFolder(), "credentials");
    }

    @Override
    public void onDisable() {

    }

}
