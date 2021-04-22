package org.demo;

import java.sql.*;

public class HelloJdbc {
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

            // step 3 - create statement
            Statement statement = connection.createStatement();
            String sql = "select id, name, age, contact, city, gender from employee_schema.employee";

            // step 4 - execute query
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Query executed");

            // Step 5 - Process results
            while (resultSet.next()) {
                System.out.print("Id: " + resultSet.getInt("id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("City: " + resultSet.getString("city"));
                System.out.print("Gender: " + resultSet.getString("gender"));
                System.out.print("Age: " + resultSet.getInt("age"));
                System.out.println("Contact: " + resultSet.getLong("contact"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                // step 6
                connection.close();
                System.out.println("Connection closed");
            } catch(SQLException e) {
                System.out.println(e);
            }
        }
    }
}
