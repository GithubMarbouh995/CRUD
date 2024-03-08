package com.example.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
    private static final String URL = "jdbc:mysql://db-mysql-nyc3-45425-do-user-15838371-0.c.db.ondigitalocean.com:25060/defaultdb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "doadmin";
    private static final String PASSWORD = "AVNS_5U-vQolWA6URKlAM6qi";
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