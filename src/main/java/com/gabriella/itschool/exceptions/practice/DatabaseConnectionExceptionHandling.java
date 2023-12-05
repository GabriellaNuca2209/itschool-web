package com.gabriella.itschool.exceptions.practice;

import java.sql.*;

public class DatabaseConnectionExceptionHandling {

    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://localhost:5432/demo_project_database";
        String user = "admin";
        String password = "admin";

        try(Connection connection = DriverManager.getConnection(dbUrl, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
