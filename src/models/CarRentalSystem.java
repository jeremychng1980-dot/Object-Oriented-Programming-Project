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
        // Creaqte array to hold all Users temporarily
        User[] users = new User[100];

        // Load only customers from users.txt file
        int custCount = Customer.getCustCount();
        Customer[] customers = new Customer[custCount];
        FileLoader.loadUsersFile("users.txt", users);

        int customerIndex = 0;
        for (int i = 0; i < custCount; i++) {
            if (users[i] instanceof Customer) {
                customers[customerIndex++] = (Customer) users[i];
            }
        }

        int carCount = Car.getCarCount();
        Car[] cars = new Car[carCount];
        FileLoader.loadCarFile("cars.txt", cars);
    }// end of constructor

//---------------------Rent a Vehicle-------------------
    public static void rentVehicle() {
        Scanner input = new Scanner(System.in);
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Rent a Vehicle            ");
        System.out.println("\n=====================================");

        CarRentalSystem sys = new CarRentalSystem();
        sys.displayAllCars(cars);

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
        

        Car c1 = new Car();        
        c1.equals(String carId);
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

    public void displayAllCars(Car [] cars) {

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
