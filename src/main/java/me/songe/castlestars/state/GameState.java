package me.songe.castlestars.state;

import me.songe.castlestars.CastleStarsPlugin;

public abstract class GameState {

    private CastleStarsPlugin plugin;

    public GameState(CastleStarsPlugin plugin) {
        this.plugin = plugin;
    }

    public abstract void start();
    public abstract void stop();

}
