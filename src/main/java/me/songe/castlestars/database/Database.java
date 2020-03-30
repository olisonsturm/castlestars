package me.songe.castlestars.database;

import java.sql.Connection;

public interface Database {

    Connection getConnection();

    void close();

    boolean isConnected();

    void init();

}
