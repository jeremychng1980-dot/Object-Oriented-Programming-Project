package models;
import java.util.Scanner;
import utils.Helper;
import utils.FileLoader;
import utils.FileUploader;
import models.Car;
import models.Customer;
import models.User;

public class CarRentalSystem {
    public CarRentalSystem(){
        // Load only customers from users.txt file
        User[] allUsers = new User[100];
        int userCount = utils.FileLoader.loadUsersFile("users.txt", allUsers);

        // Count customers first
        int customerCount = 0;
        for (int i = 0; i < userCount; i++) {
            if (allUsers[i] instanceof Customer) {
                customerCount++;
            }
        } // end of for loop

        // Create exact customer array
        Customer[] customers = new Customer[customerCount];
        int index = 0;
        for (int i = 0; i < userCount; i++) {
            if (allUsers[i] instanceof Customer) {
                customers[index++] = (Customer) allUsers[i];
            }
        } // end of for loop

        // Now 'customers' array contains ONLY Customer objects
        System.out.println("Loaded " + customers.length + " customers");
        for (Customer c : customers) {
            System.out.println(" - " + c.getName() + " (" + c.getCustID() + ")");
        }// end of for loop

        // Load only customers from users.txt file
        User[] users = new User[100];

        // Count customers first
            if (users[i] instanceof Customer) {
                customerCount++;
            }
        } // end of for loop} 
 
 // end of constructor
---------------------Rent a Vehicle-----------------------------------------

    public static void rentVehicle() {
        Scanner input = new Scanner(System.in);
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Rent a Vehicle            ");
        System.out.println("\n=====================================");

        CarRentalSystem sys = new CarRentalSystem();
        sys.displayAllCars();

        System.out.print("Press Enter to continue to login or '0' to exit... ");
        String choice = input.nextLine();//ask user if they want to continue to login or exit
        System.out.println("\n");
        // Check if user wants to exit
        if (choice.equals("0")) {
        	Helper.clearScreen();
            return;
        }

        input.nextLine();
        System.out.println("\n\nEnter the Vehicle's Car ID: ");
        String carId = input.nextLine();
        

        Car c1 = new Car();        c1.equals(String carId);
    }

//-----------------------Check out-----------------------------
    public static void checkOut(){
        System.out.println("\n=====================================");
        System.out.println("\n             Check  Out              ");
        System.out.println("\n=====================================");
    }


//------------------------Process Return----------------------------
    public static void processReturn(){
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Process Return            ");
        System.out.println("\n=====================================");
    }

//--------------------Process Payment-----------------------
    public static void processPayment(){
        System.out.println("\n=====================================");
        System.out.println("\n              Payment                ");
        System.out.println("\n=====================================");
    }

//-------------------------View History-------------------------------
    public static void viewHistory(){
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n         View Booking History        ");
        System.out.println("\n=====================================");

        
    }

    public void displayAllCars() {
        System.out.println("\n=====================================");
        System.out.println("           View All Vehicles           ");
        System.out.println("=====================================");
        System.out.println("\n==========================================================================");
        System.out.printf("%-10s | %-12s | %-10s | %-10s | %-10s\n", "ID", "Plate", "Brand", "Model", "Status");
        System.out.println("--------------------------------------------------------------------------");

        if (Car.getCarCount() == 0) {
            System.out.println("                     [ Currently no available vehicle record ]                      ");
        } else {
            for (int i = 0; i < Car.getCarCount(); i++) {

                System.out.println(cars[i].toString());
            }
        }
        System.out.println("==========================================================================");
    }


}
