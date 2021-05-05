package com.app.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private PostgresConnection() {}
    private static Connection connection;

    static {
        try {
            String url="jdbc:postgresql://localhost:5432/postgres";
            String username="postgres";
            String password="P16ostgre!";
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    public static Connection getConnection() { return connection; }
}

/* How to build singleton java class
disable the constructor by making it private
keep static method method that checks and returs instance of the connection object
 */