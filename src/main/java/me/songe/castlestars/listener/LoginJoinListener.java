package me.songe.castlestars.listener;

import me.songe.castlestars.CastleStarsPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class LoginJoinListener implements Listener {

    private final CastleStarsPlugin plugin;

    public LoginJoinListener(CastleStarsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(player + " ist beigetreten!");
    }

}
