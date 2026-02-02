package com.airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/airline_db",
                "root",
                "Gulshan@2212"
            );

            System.out.println("Database connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
