package me.songe.castlestars.state;

import org.bukkit.Bukkit;

public class StateLoader {

    private int currentState = 0;

    private GameState[] gameStates;

    public StateLoader(GameState... gameStates) {
        this.gameStates = gameStates;
    }

    public void nextState() {
        currentState++;
        if(currentState + 1 <= gameStates.length) {
            gameStates[currentState-1].stop();
            gameStates[currentState].start();
        } else {
            gameStates[currentState-1].stop();
        }
    }
}
