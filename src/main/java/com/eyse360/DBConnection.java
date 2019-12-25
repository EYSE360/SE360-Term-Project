package com.eyse360;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
    private Connection connection = null;
    String connectionUrl;
    String username;
    String password;

    public DBConnection() {
        this.connectionUrl = "jdbc:mariadb://localhost/se360";
        this.username = "root";
        this.password = "";
    }

    public DBConnection(String connectionUrl, String username, String password) {
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }

    public Connection connect() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection = DriverManager.getConnection(this.connectionUrl, this.username, this.password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}