package org.wisam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection class provides a utility for obtaining a connection to the database.
 * It uses a singleton pattern to ensure only one connection instance is created.
 */
public class DatabaseConnection {
    private static Connection connection;

    /**
     * Returns the database connection. If the connection does not already exist,
     * it is created using the specified database URL, username, and password.
     *
     * @return The database connection.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://atm-db.czddj9aoyvxa.us-east-1.rds.amazonaws.com",
                        "admin",
                        "Helloworld1!"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}