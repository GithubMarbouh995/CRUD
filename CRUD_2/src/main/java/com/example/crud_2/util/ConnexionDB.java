package com.example.crud_2.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/CRUD";
    private static final String USER = "root";
    private static final String PASSWORD = "03112002";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return connection;
    }
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
