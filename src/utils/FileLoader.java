package utils;
import models.Admin;
import models.Car;
import models.Customer;
import models.Economy;
import models.License;
import models.Luxury;
import models.SUV;
import models.Staff;
import models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class FileLoader {
    
    public static void loadUsersFile(String filename, User[] users) { 
        File file = new File(filename);
        
        // Check if file exists
        if (!file.exists()) {
            System.out.println("No existing file found");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
            // Read total number of users
            String line = reader.readLine();
            if (line == null) {
                return;
            }
            
            int totalUsers = Integer.parseInt(line.trim());
            int count = 0;  // Track number of users loaded
            
            // Read each user
            for (int i = 0; i < totalUsers; i++) {
                String userType = reader.readLine();
                
                if (userType == null) break;
                
                if (userType.equals("CUSTOMER")) {
                    String dataLine = reader.readLine();
                    if (dataLine == null) break;
                    
                    // Use \\| for split (pipe is special character)
                    String[] parts = dataLine.split("\\|");
                    
                    // parts[0]=custID, [1]=loginID, [2]=password, [3]=name, 
                    // [4]=gender, [5]=phoneNo, [6]=email, [7]=licenseNo, [8]=licenseExpiredDate
                    String custID = parts[0];
                    String loginID = parts[1];
                    String password = parts[2];
                    String name = parts[3];
                    char gender = parts[4].charAt(0);
                    String phoneNo = parts[5];
                    String email = parts[6];
                    String licenseNo = parts[7];
                    String licenseExpireDateStr = parts[8];
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date licenseExpireDate = sdf.parse(licenseExpireDateStr);
                    
                    License license = new License(licenseNo, licenseExpireDate);
                    Customer customer = new Customer(loginID, password, name, gender, 
                                                    phoneNo, email, license);
                    customer.setCustID(custID);
                    
                    users[count] = customer;
                    count++;
                    
                    System.out.println("✓ Loaded customer: " + name);
                }
                else if (userType.equals("STAFF")) {
                    String dataLine = reader.readLine();
                    if (dataLine == null) break;
                    
                    // Use \\| for split
                    String[] parts = dataLine.split("\\|");
                    
                    // parts[0]=staffID, [1]=loginID, [2]=password, [3]=name, [4]=gender, [5]=phoneNo, [6]=hireDate
                    String staffID = parts[0];
                    String loginID = parts[1];
                    String password = parts[2];
                    String name = parts[3];
                    char gender = parts[4].charAt(0);
                    String phoneNo = parts[5];
                    String hireDateStr = parts[6];
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date hireDate = sdf.parse(hireDateStr);
                    Staff staff = new Staff(loginID, password, name, gender, phoneNo, hireDate);
                    staff.setStaffID(staffID);
                    
                    users[count] = staff;
                    count++;
                    
                    System.out.println("✓ Loaded staff: " + name);
                }
                else if (userType.equals("ADMIN")) {
                    String dataLine = reader.readLine();
                    if (dataLine == null) break;
                    
                    // Use \\| for split
                    String[] parts = dataLine.split("\\|");
                    
                    // parts[0]=adminID, [1]=loginID, [2]=password, [3]=name, [4]=gender, [5]=phoneNo
                    String adminID = parts[0];
                    String loginID = parts[1];
                    String password = parts[2];
                    String name = parts[3];
                    char gender = parts[4].charAt(0);
                    String phoneNo = parts[5];
                    
                    Admin admin = new Admin(loginID, password, name, gender, phoneNo);
                    admin.setAdminID(adminID);
                    
                    users[count] = admin;
                    count++;
                    
                    System.out.println("✓ Loaded admin: " + name);
                }
            }
            
            System.out.println("Successfully loaded " + count + " users from file");
            
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing date in file: " + e.getMessage());
        }
    }

    public static void loadCarFile(String filename, Car[] cars) {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("No existing file found");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //Read total number of cars
            String line = reader.readLine();
            if (line == null) {
                return;
            }

            //Convert the first line to an integer to get the total number of cars
            int totalCars = Integer.parseInt(line.trim());
            int count = 0;

            for (int i = 0; i < totalCars; i++) {
                String carType = reader.readLine();

                if (carType == null) break;

                if (carType.equals("ECONOMY")) {
                    String dataline = reader.readLine();
                    if (dataline == null) break;
                    String[] parts = dataline.split("\\|");
                    // parts[0]=carID, [1]=plateNumber, [2]=model, [3]=brand, [4]=dailyRate,
                    // [5]=seatingCapacity, [6]=mileage, [7]=status, [8]=fuelLevel, [9q]=isHatchback, [10]=fuelEfficiencyPer100KM
                    String carID = parts[0];
                    String plateNumber = parts[1];
                    String model = parts[2];
                    String brand = parts[3];
                    double dailyRate = Double.parseDouble(parts[4]);
                    int seatingCapacity = Integer.parseInt(parts[5]);
                    int mileage = Integer.parseInt(parts[6]);
                    String status = parts[7];
                    double fuelLevel = Double.parseDouble(parts[8]);
                    boolean isHatchback = Boolean.parseBoolean(parts[9]);
                    double fuelEfficiencyPer100KM = Double.parseDouble(parts[10]);

                        Economy eco = new Economy(plateNumber, model, brand, dailyRate, seatingCapacity, 
                                                mileage, status, fuelLevel, isHatchback, fuelEfficiencyPer100KM);
                        eco.setCarID(carID); 
                        cars[count++] = eco; 


                } else if (carType.equals("LUXURY")) {
                    String dataline = reader.readLine();
                    if (dataline == null) break;
                    String[] parts = dataline.split("\\|");
                    // parts[0]=carID, [1]=plateNumber, [2]=model, [3]=brand, [4]=dailyRate,
                    // [5]=seatingCapacity, [6]=mileage, [7]=status, [8]=fuelLevel, [9]=hasLeatherSeats, [10]=hasSunroof
                    String carID = parts[0];
                    String plateNumber = parts[1];
                    String model = parts[2];
                    String brand = parts[3];
                    double dailyRate = Double.parseDouble(parts[4]);
                    int seatingCapacity = Integer.parseInt(parts[5]);
                    int mileage = Integer.parseInt(parts[6]);
                    String status = parts[7];
                    double fuelLevel = Double.parseDouble(parts[8]);
                    boolean hasLeatherSeats = Boolean.parseBoolean(parts[9]);
                    boolean hasSunroof = Boolean.parseBoolean(parts[10]);
                        Luxury lux = new Luxury(plateNumber, model, brand, dailyRate, seatingCapacity, 
                                                mileage, status, fuelLevel, hasLeatherSeats, hasSunroof);
                        lux.setCarID(carID); 
                        cars[count++] = lux;

                         
                } else if (carType.equals("SUV")) {
                    String dataline = reader.readLine();
                    if (dataline == null) break;
                    String[] parts = dataline.split("\\|");
                    // parts[0]=carID, [1]=plateNumber, [2]=model, [3]=brand, [4]=dailyRate,
                    // [5]=seatingCapacity, [6]=mileage, [7]=status, [8]=fuelLevel, [9]=fourWheelDrive, [10]=groundClearance
                    String carID = parts[0];
                    String plateNumber = parts[1];
                    String model = parts[2];
                    String brand = parts[3];
                    double dailyRate = Double.parseDouble(parts[4]);
                    int seatingCapacity = Integer.parseInt(parts[5]);
                    int mileage = Integer.parseInt(parts[6]);
                    String status = parts[7];
                    double fuelLevel = Double.parseDouble(parts[8]);
                    boolean fourWheelDrive = Boolean.parseBoolean(parts[9]);
                    int groundClearance = Integer.parseInt(parts[10]);
                        SUV suv = new SUV(plateNumber, model, brand, dailyRate, seatingCapacity, 
                                            mileage, status, fuelLevel, fourWheelDrive, groundClearance);
                        suv.setCarID(carID); 
                        cars[count++] = suv; 
                }
            }// end of for loop
            Car.setCarCount(count); // Update the static carCount variable to reflect the number of cars loaded
            
        } catch (IOException e) {
            System.out.println("Error reading car file: " + e.getMessage());
        }

    }
}