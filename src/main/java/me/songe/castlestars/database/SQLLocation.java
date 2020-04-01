package me.songe.castlestars.database;

import me.songe.castlestars.CastleStarsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLLocation {

    private final CastleStarsPlugin plugin;

    public SQLLocation(CastleStarsPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean doesLocationExist(String spawnname, Location mapname) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM castlestarslocations WHERE spawnname=? AND mapname=?");
            preparedStatement.setString(1, spawnname.toString());
            preparedStatement.setString(2, mapname.getWorld().getName());
            return preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createLocation(String spawnname, Location location) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO castlestarslocations(spawnname, mapname, x, y, z, pitch, yaw) VALUES( ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, spawnname);
            preparedStatement.setString(2, location.getWorld().getName());
            preparedStatement.setDouble(3, location.getX());
            preparedStatement.setDouble(4, location.getY());
            preparedStatement.setDouble(5, location.getZ());
            preparedStatement.setDouble(6, location.getYaw());
            preparedStatement.setDouble(7, location.getPitch());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Location getLocation(String spawnname) {
        Location location = null;
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM castlestarsstats WHERE spawnname=?");
            preparedStatement.setString(1, spawnname);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("spawname");
                World world = Bukkit.getWorld(rs.getString("mapname"));
                double x = rs.getDouble("x");
                double y = rs.getDouble("y");
                double z = rs.getDouble("z");
                float yaw = rs.getFloat("yaw");
                float pitch = rs.getFloat("pitch");
                location = new Location(world, x, y, z, yaw, pitch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    public void deleteLocation(String spawnname, String mapname) {
        try (Connection connection = plugin.getCustomDatabase().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM castlestarsstats WHERE spawnname=? AND mapname=?");
            preparedStatement.setString(1, spawnname);
            preparedStatement.setString(2, mapname);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
