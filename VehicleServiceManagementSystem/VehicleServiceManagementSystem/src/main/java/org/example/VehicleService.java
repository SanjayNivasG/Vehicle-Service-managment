package org.example.service;

import java.sql.*;
import org.example.DBConnection;

public class VehicleService {

    public void addVehicle(int cid, String number, String type, String model) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO vehicles(customer_id, vehicle_number, vehicle_type, model) VALUES (?, ?, ?, ?)"
        );

        ps.setInt(1, cid);
        ps.setString(2, number);
        ps.setString(3, type);
        ps.setString(4, model);

        ps.executeUpdate();
        con.close();
    }

    public void viewVehicles() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM vehicles");

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                            rs.getInt(2) + " " +
                            rs.getString(3) + " " +
                            rs.getString(4) + " " +
                            rs.getString(5)
            );
        }
        con.close();
    }

    public void viewByCustomer(int customerId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM vehicles WHERE customer_id=?"
        );

        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();

        System.out.println("Vehicles for Customer ID: " + customerId);

        while (rs.next()) {
            System.out.println(
                    rs.getString("vehicle_number") + " | " +
                            rs.getString("vehicle_type") + " | " +
                            rs.getString("model")
            );
        }
        con.close();
    }
}
