package com.example.crud_2.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
    private static final String URL = "jdbc:mysql://dbaas-db-7965936-do-user-15838371-0.c.db.ondigitalocean.com:25060/defaultdb?";
    private static final String USER = "doadmin";
    private static final String PASSWORD = "AVNS_LBM3vY3Gn2pg6_k8TiR";
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
