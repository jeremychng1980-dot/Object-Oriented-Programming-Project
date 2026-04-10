package utils;
import models.Car;
import models.Customer;
import models.License;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
    public static int loadCustomer(String filename, Customer[] custArray) {
        int custCount = 0;

        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine() && custCount < custArray.length) {
                String line = scan.nextLine();
                Customer customer = parseCustomer(line);
            }
        }
    }

    public static int loadCar(String filename, Car[] carArray) {
        
    }

    private static Customer parseTicket(String line) {
        String[] parts = line.split("\\|");

        if (parts.length < 9) {
            System.out.println("Invalid line format" + line);
            return null;
        }

        String custId = parts[0];
        String custUsername = parts[1];
        String password = parts[2];
        String custName = parts[3];
        char custGender = parts[4].charAt(0);
        int custPhone = Integer.parseInt(parts[5]);
        String custEmail = parts[6];
        int custIdentityNo = Integer.parseInt(parts[7]);
        String custLicenseDate = parts[8];

        License license = new License(" ", custLicenseDate);

            //public Customer(String loginID, String password, String name, char gender, 
                    //String phoneNo, String email, License license)

        return new Customer(custId, password, custName, custGender, custPhone, custEmail, custIdentityNo, custLicenseDate);
    }
/* 
    public static int loadPayment?(String filename, Array[] array) {
        
    }
*/
}
