package me.songe.castlestars.database;

import me.songe.castlestars.CastleStarsPlugin;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLStats {

    private final CastleStarsPlugin plugin;

    public SQLStats(CastleStarsPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean doesPlayerExistInStats(Player player) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM castlestarsstats WHERE uuid=?");
            preparedStatement.setString(1, player.getUniqueId().toString());
            return preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createPlayerIfNotExist(Player player) {
        if (doesPlayerExistInStats(player)) {
            return;
        }
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO castlestarsstats(uuid, kills, deaths) VALUES( ?, 0, 0)");
            preparedStatement.setString(1, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setKills(Player player, int kills) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE castlestarsstats SET kills=? WHERE uuid=?");
            preparedStatement.setInt(1, kills);
            preparedStatement.setString(2, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getKills(Player player) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM castlestarsstats WHERE uuid=?");
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("kills");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setDeaths(Player player, int deaths) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE castlestarsstats SET deaths=? WHERE uuid=?");
            preparedStatement.setInt(1, deaths);
            preparedStatement.setString(2, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDeaths(Player player) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM castlestarsstats WHERE uuid=?");
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("deaths");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
