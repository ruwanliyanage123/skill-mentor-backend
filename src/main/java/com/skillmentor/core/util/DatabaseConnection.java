package com.skillmentor.core.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public final class DatabaseConnection {
    Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/skill_mentor";
    String username = "root";
    String password = "19940306";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
