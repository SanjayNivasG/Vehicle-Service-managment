package org.example;

import java.util.Scanner;
import org.example.service.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        CustomerService cs = new CustomerService();
        VehicleService vs = new VehicleService();
        ServiceManagement sm = new ServiceManagement();
        BillingService bs = new BillingService();

        while (true) {
            System.out.println("\n1.Add Customer");
            System.out.println("2.View Customers");
            System.out.println("3.Add Vehicle");
            System.out.println("4.View Vehicles");
            System.out.println("5.Add Service");
            System.out.println("6.Update Service Status");
            System.out.println("7.Add Bill");
            System.out.println("8.Pay Bill");
            System.out.println("9.View Bills");
            System.out.println("10.Search Vehicles by Customer");
            System.out.println("0.Exit");

            int ch = sc.nextInt();

            if (ch == 1) {
                sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Phone: ");
                String p = sc.nextLine();
                cs.addCustomer(n, p);
            }

            else if (ch == 2) cs.viewCustomers();

            else if (ch == 3) {
                System.out.print("Customer ID: ");
                int cid = sc.nextInt();
                sc.nextLine();
                System.out.print("Vehicle No: ");
                String vn = sc.nextLine();
                System.out.print("Type (Bike/Car): ");
                String t = sc.nextLine();
                System.out.print("Model: ");
                String m = sc.nextLine();
                vs.addVehicle(cid, vn, t, m);
            }

            else if (ch == 4) vs.viewVehicles();

            else if (ch == 5) {
                System.out.print("Vehicle ID: ");
                int vid = sc.nextInt();
                sm.addService(vid, "PENDING");
            }

            else if (ch == 6) {
                System.out.print("Service ID: ");
                int sid = sc.nextInt();
                sc.nextLine();
                System.out.print("Status: ");
                String s = sc.nextLine();
                sm.updateStatus(sid, s);
            }

            else if (ch == 7) {
                System.out.print("Service ID: ");
                int sid = sc.nextInt();
                System.out.print("Amount: ");
                double a = sc.nextDouble();
                bs.addBill(sid, a);
            }

            else if (ch == 8) {
                System.out.print("Bill ID: ");
                int bid = sc.nextInt();
                bs.payBill(bid);
            }

            else if (ch == 9) bs.viewBills();

            else if (ch == 10) {
                System.out.print("Customer ID: ");
                int cid = sc.nextInt();
                vs.viewByCustomer(cid);
            }

            else if (ch == 0) break;
        }
    }
}
