package me.songe.castlestars.command;

import me.songe.castlestars.util.PlayerPermission;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    /*
    /setspawn lobby, defense, offense
     */
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission(PlayerPermission.SETUP.getPermission())) {
                switch (args[0]) {
                    case "lobby":

                        break;
                    case "defense":

                        break;
                    case "offense":

                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    private void setLocation(Location location, String path) {
        
    }

}
