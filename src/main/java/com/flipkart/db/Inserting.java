package com.flipkart.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserting {
    public String sayHello(String username,
                           String password,
                           String fullname,
                           String email,
                           String jdbcURL,
                           String username_sql,
                           String password_sql
    ) {

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username_sql, password_sql);
            if (connection != null) {
                System.out.println("connected to database");
                String sql_insert;
                sql_insert = "INSERT INTO users (username,password,fullname,email) VALUES (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql_insert);
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, fullname);
                statement.setString(4, email);
                int rows = statement.executeUpdate();
                connection.close();
                return "successfully inserted " + rows + " rows.";
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return "error";
        }
        return "hi";
    }
}
