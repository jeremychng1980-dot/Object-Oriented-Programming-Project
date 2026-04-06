package utils;
import models.Admin;
import models.Customer;
import models.User;
import models.Staff;
import models.License;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

public class Helper {
//-------Reusable Clear Screen Method--------
   public static void clearScreen() {
    for (int i = 0; i < 50; i++) { 
        System.out.println();//print 50 lines
    }
}
//------Reusable Validation Method---------------
      public static int getValidatedInt(Scanner input, String prompt, int min, int max) {
        int value = 0;
        boolean valid = false;
        
        while (!valid) {
            try {
                System.out.print(prompt);//prompt Please enter a number (1-5): 
                String inputLine = input.nextLine(); //let user enter the input
                
                if (inputLine == null || inputLine.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty!"); //custom prompt if its empty
                }
                
                value = Integer.parseInt(inputLine.trim());//convert it to integer
                
                if (value < min || value > max) {
                    throw new IllegalArgumentException("Please enter a number between " + min + " and " + max);
                } //check to ensure value is in the right range else will prompt error
                
                valid = true;
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a NUMBER only.\n"); //error prompt if not a number
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");//prompt out the error if input is empty
            }
        }
        
        return value;//return the input
    }

//----------------instanceof method to display----------------------
public static void displayUsers(User[] users, int count) {
    for (int i = 0; i < count; i++) {
        // instanceof to indentifies the type of user
        if (users[i] instanceof Customer) {
        }
        else if (users[i] instanceof Staff) {
        }
        else if (users[i] instanceof Admin) {
        }
       
        System.out.println(users[i].toString());// toString() method that will decide which class toString to use
    }
}
public static void printSeperator(){
    System.out.print("===========================");
}
}