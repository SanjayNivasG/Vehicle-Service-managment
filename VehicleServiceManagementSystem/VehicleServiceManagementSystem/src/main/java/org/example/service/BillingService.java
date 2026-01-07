package org.example.service;

import java.sql.*;
import org.example.DBConnection;

public class BillingService {

    public void addBill(int sid, double amt) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "insert into billing(service_id, amount, paid_status) values (?,?,?)");
        ps.setInt(1, sid);
        ps.setDouble(2, amt);
        ps.setString(3, "UNPAID");
        ps.executeUpdate();
        con.close();
    }

    public void payBill(int bid) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "update billing set paid_status='PAID' where id=?");
        ps.setInt(1, bid);
        ps.executeUpdate();
        con.close();
    }

    public void viewBills() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from billing");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+" "+
                            rs.getInt("service_id")+" "+
                            rs.getDouble("amount")+" "+
                            rs.getString("paid_status")
            );
        }
        con.close();
    }
}
