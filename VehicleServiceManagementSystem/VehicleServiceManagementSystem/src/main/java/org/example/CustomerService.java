package org.example.service;

import java.sql.*;
import org.example.DBConnection;

public class CustomerService {

    public void addCustomer(String name, String phone) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "insert into customers(name, phone) values (?, ?)");
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.executeUpdate();
        con.close();
    }

    public void viewCustomers() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from customers");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id")+" "+
                            rs.getString("name")+" "+
                            rs.getString("phone")
            );
        }
        con.close();
    }
}
