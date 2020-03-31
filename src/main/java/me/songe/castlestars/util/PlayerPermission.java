package me.songe.castlestars.util;

import me.songe.castlestars.config.ConfigProvider;

public enum PlayerPermission {

    SETUP ("games.setup"),
    START ("games.quickstart");

    private String permission;

    PlayerPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
