package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vehicle_service?useSSL=false&serverTimezone=UTC",
                "root",
                "Nivas2006gs#"
        );
    }
}
