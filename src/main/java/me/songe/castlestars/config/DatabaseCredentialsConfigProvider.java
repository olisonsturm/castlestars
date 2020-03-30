package me.songe.castlestars.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class DatabaseCredentialsConfigProvider extends ConfigProvider {

    public DatabaseCredentialsConfigProvider(File folder, String fileName) {
        super(folder, fileName);
        setDefaults();
    }

    private void setDefaults() {
        FileConfiguration cfg = getFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("hostname", "127.0.0.1");
        cfg.addDefault("port", "3306");
        cfg.addDefault("database", "DatabaseName");
        cfg.addDefault("user", "username");
        cfg.addDefault("password", "*************");
        save();
    }

}
