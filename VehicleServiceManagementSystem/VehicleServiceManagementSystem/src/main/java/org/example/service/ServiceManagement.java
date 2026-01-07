package org.example.service;

import java.sql.*;
import org.example.DBConnection;

public class ServiceManagement {

    public void addService(int vehicleId, String status) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO services(vehicle_id, status) VALUES (?, ?)"
        );

        ps.setInt(1, vehicleId);
        ps.setString(2, status);

        ps.executeUpdate();
        con.close();
    }

    public void updateStatus(int serviceId, String status) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE services SET status=? WHERE id=?"
        );

        ps.setString(1, status);
        ps.setInt(2, serviceId);

        ps.executeUpdate();
        con.close();
    }
}
