package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import models.*;

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
                    writer.print(c.getCustomerID() + "|");
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

        int actualCount = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) actualCount++;
        }

        writer.println(actualCount);
        for (int i = 0; i < cars.length; i++) {
            Car c = cars[i];
            if (c != null) {
                if (cars[i] instanceof Economy) {
                    writer.println("ECONOMY");
                    Economy e = (Economy) c;
                    // ADD reservationCount and totalRevenue at the end
                    writer.print(e.getCarID() + "|");
                    writer.print(e.getPlateNumber() + "|");
                    writer.print(e.getModel() + "|");
                    writer.print(e.getBrand() + "|");
                    writer.print(e.getDailyRate() + "|");
                    writer.print(e.getSeatingCapacity() + "|");
                    writer.print(e.getMileage() + "|");
                    writer.print(e.getStatus() + "|");
                    writer.print(e.getFuelLevel() + "|");
                    writer.print(e.isHatchback() + "|");
                    writer.print(e.getFuelEfficiencyPer100KM() + "|");
                    writer.print(e.getReservationCount() + "|");      // NEW
                    writer.print(e.getTotalRevenue());                // NEW
                    writer.println();
                } else if (cars[i] instanceof Luxury) {
                    writer.println("LUXURY");
                    Luxury l = (Luxury) c;
                    writer.print(l.getCarID() + "|");
                    writer.print(l.getPlateNumber() + "|");
                    writer.print(l.getModel() + "|");
                    writer.print(l.getBrand() + "|");
                    writer.print(l.getDailyRate() + "|");
                    writer.print(l.getSeatingCapacity() + "|");
                    writer.print(l.getMileage() + "|");
                    writer.print(l.getStatus() + "|");
                    writer.print(l.getFuelLevel() + "|");
                    writer.print(l.isHasLeatherSeats() + "|");
                    writer.print(l.isHasSunroof() + "|");
                    writer.print(l.getReservationCount() + "|");      // NEW
                    writer.print(l.getTotalRevenue());                // NEW
                    writer.println();
                } else if (cars[i] instanceof SUV) {
                    writer.println("SUV");
                    SUV s = (SUV) c;
                    writer.print(s.getCarID() + "|");
                    writer.print(s.getPlateNumber() + "|");
                    writer.print(s.getModel() + "|");
                    writer.print(s.getBrand() + "|");
                    writer.print(s.getDailyRate() + "|");
                    writer.print(s.getSeatingCapacity() + "|");
                    writer.print(s.getMileage() + "|");
                    writer.print(s.getStatus() + "|");
                    writer.print(s.getFuelLevel() + "|");
                    writer.print(s.isFourWheelDrive() + "|");
                    writer.print(s.getGroundClearance() + "|");
                    writer.print(s.getReservationCount() + "|");      // NEW
                    writer.print(s.getTotalRevenue());                // NEW
                    writer.println();
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


    public static void savePaymentsToFile(String filename, Payment[] payments) {
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter(new FileWriter(filename));

            int actualCount = 0;
            for (int i = 0; i < payments.length; i++) {
                if (payments[i] != null) actualCount++;
            }

            writer.println(actualCount);
            for (int i = 0; i < payments.length; i++) {
                Payment p = payments[i];
                if (p != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    
                    // Format: paymentID|reserveDate|checkOutDate|returnDate|amount|deposit|damageCharge|customerID|carID|rentDuration|status|PAYMENT_TYPE|payment-specific-fields
                    writer.print(p.getPaymentID() + "|");
                    writer.print(sdf.format(p.getReserveDate()) + "|");
                    
                    // if no value then put null
                    writer.print((p.getCheckOutDate() != null ? sdf.format(p.getCheckOutDate()) : "NULL_DATE") + "|");
                    writer.print((p.getReturnDate() != null ? sdf.format(p.getReturnDate()) : "NULL_DATE") + "|");

                    writer.print(p.getAmount() + "|");
                    writer.print(p.getDeposit() + "|");
                    writer.print(p.getDamageCharge() + "|");
                    writer.print(p.getCustomerID() + "|");
                    writer.print(p.getCarID() + "|");
                    writer.print(p.getRentDuration() + "|");
                    writer.print(p.getStatus() + "|");

                    // Write payment type and rent duration first
                    if (p instanceof Cash) {
                        Cash cash = (Cash) p;
                        writer.print("CASH|");
                        writer.print(cash.getAmountReceived());
                    } else if (p instanceof Card) {
                        Card card = (Card) p;
                        writer.print("CARD|");
                        writer.print(card.getCardNo() + "|");
                        writer.print(card.getCCV() + "|");
                        writer.print(card.getNameOnCard() + "|");
                        writer.print(card.getExpiryMonth() + "|");
                        writer.print(card.getExpiryYear());
                    } else if (p instanceof OnlineTransfer) {
                        OnlineTransfer transfer = (OnlineTransfer) p;
                        writer.print("ONLINETRANSFER|");
                        writer.print(transfer.getAccountNumber() + "|");
                        writer.print(transfer.getAccountName() + "|");
                        writer.print(transfer.getBankName() + "|");
                        writer.print(transfer.getSwiftCode() + "|");
                        writer.print(transfer.getReference());
                    } else {
                        writer.print("NULL|");
                    }
                    
                    writer.println();  // End the line
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error saving payments to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}// end of class
