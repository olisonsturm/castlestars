package me.songe.castlestars;

import me.songe.castlestars.config.ConfigProvider;
import me.songe.castlestars.config.DatabaseConfigProvider;
import me.songe.castlestars.database.Database;
import me.songe.castlestars.database.DatabaseType;
import me.songe.castlestars.database.MySQLDatabase;
import me.songe.castlestars.database.PostgresDatabase;
import me.songe.castlestars.listener.LoginJoinListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.graalvm.compiler.code.DataSection;

import java.util.Arrays;

public class CastleStarsPlugin extends JavaPlugin {

    private ConfigProvider databaseConfigProvider;
    private Database database;
    private DatabaseType databaseType = DatabaseType.MYSQL;

    @Override
    public void onEnable() {
        databaseConfigProvider = new DatabaseConfigProvider(getDataFolder(), "credentials");
        readAndSetDatabaseType();
        String hostname = databaseConfigProvider.getFileConfiguration().getString("credentials.hostname");
        int port = databaseConfigProvider.getFileConfiguration().getInt("credentials.port");
        String database_name = databaseConfigProvider.getFileConfiguration().getString("credentials.database");
        String user = databaseConfigProvider.getFileConfiguration().getString("credentials.user");
        String password = databaseConfigProvider.getFileConfiguration().getString("credentials.password");
        switch(databaseType) {
            case MYSQL:
                database = new MySQLDatabase(hostname, port, database_name, user, password);
                break;
            case POSTGRESQL:
                database = new PostgresDatabase(hostname, port, database_name, user, password);
                break;
        }
        database.init();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new LoginJoinListener(this), this);
    }

    private void readAndSetDatabaseType() {
        databaseType = Arrays.stream(DatabaseType.values()).filter(type -> {
            return type.name().equalsIgnoreCase(databaseConfigProvider.getFileConfiguration().getString("database_type"));
        }).findFirst().orElse(DatabaseType.MYSQL);

    }

}
