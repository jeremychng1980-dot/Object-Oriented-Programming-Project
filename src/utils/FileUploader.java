package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import models.Admin;
import models.Car;
import models.Customer;
import models.Staff;
import models.User;

import models.Car;
import models.Economy;
import models.Luxury;
import models.SUV;

public class FileUploader {
    public static void saveUsersToFile(String filename, User[] users) {
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(new FileWriter(filename));
        
        writer.println(User.getUserCount());
        
        for (int i = 0; i < User.getUserCount(); i++) {
            User u = users[i];
            if (u != null) {
                if (u instanceof Customer) {
                    writer.println("CUSTOMER");
                    Customer c = (Customer) u;
                    // Format: custID|loginID|password|name|gender|phoneNo|email|licenseNo|expiryDate
                    writer.print(c.getCustID() + "|");
                    writer.print(c.getLoginID() + "|");
                    writer.print(c.getPassword() + "|");
                    writer.print(c.getName() + "|");
                    writer.print(c.getGender() + "|");
                    writer.print(c.getPhoneNo() + "|");
                    writer.print(c.getEmail() + "|");
                    writer.print(c.getLicense().getDrivingLicenseNo() + "|");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    writer.print(sdf.format(c.getLicense().getLicenseExpireDate()));
                    writer.println();
                }
                else if (u instanceof Staff) {
                    writer.println("STAFF");
                    Staff s = (Staff) u;
                    // Format: staffID|loginID|password|name|gender|phoneNo|hireDate
                    writer.print(s.getStaffID() + "|");
                    writer.print(s.getLoginID() + "|");
                    writer.print(s.getPassword() + "|");
                    writer.print(s.getName() + "|");
                    writer.print(s.getGender() + "|");
                    writer.print(s.getPhoneNo() + "|");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					writer.print(sdf.format(s.getHireDate())); 
                    writer.println();
                }
                else if (u instanceof Admin) {
                    writer.println("ADMIN");
                    Admin a = (Admin) u;
                    // Format: adminID|loginID|password|name|gender|phoneNo
                    writer.print(a.getAdminID() + "|");
                    writer.print(a.getLoginID() + "|");
                    writer.print(a.getPassword() + "|");
                    writer.print(a.getName() + "|");
                    writer.print(a.getGender() + "|");
                    writer.print(a.getPhoneNo());
                    writer.println();
                }
            }
        }
        
    } catch (IOException e) {
        System.out.println("Error saving users to file: ");
    } finally {
        if (writer != null) {
            writer.close();
        }
    }
    }

    public static void saveCarsToFile(String filename, Car[] cars) {
        PrintWriter writer = null;
        

        try {
            writer = new PrintWriter(new FileWriter(filename));

            writer.println(Car.getCarCount());
            for (int i = 0; i < Car.getCarCount(); i++) {
                Car c = cars[i];
                if (c != null) {
                    if (cars[i] instanceof Economy) {
                        writer.println("ECONOMY");
                        Economy e = (Economy) c;

                        

                    } else if (cars[i] instanceof Luxury) {
                        writer.println("LUXURY");
                        Luxury l = (Luxury) c;

                    } else if (cars[i] instanceof SUV) {
                        writer.println("SUV");
                        SUV s = (SUV) c;

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving cars to file: ");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }



    }
}
