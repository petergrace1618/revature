package org.demo;

import java.sql.*;

public class InsertMain {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // step 1 - load driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            // step 2 - Open connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "P16ostgre!";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection/ping success");

            // Step 3 - Create statement using PreparedStatement
            String sql = "INSERT INTO employee_schema.employee\n"+
                    "(\"name\", age, contact, city, gender, deptid)\n"+
                    "VALUES(?, ?, ?, ?, ?, ?);\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "ajay");
            preparedStatement.setInt(2, 25);
            preparedStatement.setLong(3, 653126384687L);
            preparedStatement.setString(4, "Detroit");
            preparedStatement.setString(5, "F");
            preparedStatement.setInt(6, 1);

            // step 4 - execute query
            int c = preparedStatement.executeUpdate();

            // Step 5 - Process results
            System.out.println("Query executed - "+c+" no of row/s inserted successfully");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                // step 6 - Close connection
                connection.close();
                System.out.println("Connection closed");
            } catch(SQLException e) {
                System.out.println(e);
            }
        }
    }
}
