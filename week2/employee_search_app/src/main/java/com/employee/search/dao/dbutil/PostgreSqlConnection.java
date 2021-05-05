package com.employee.search.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConnection {
    private PostgreSqlConnection() { }

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/postgres";
        String username="postgres";
        String password="P16ostgre!";
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
