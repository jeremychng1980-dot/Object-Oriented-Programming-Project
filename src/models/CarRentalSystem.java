package models;
import java.util.Scanner;
import utils.Helper;
import utils.FileLoader;
import utils.FileUploader;
import models.Car;
import models.Customer;
import models.User;

public class CarRentalSystem {
    Scanner input = new Scanner(System.in);
    private Car[] cars = new Car[100];
    private Customer[] customers = new Customer[100];


    public CarRentalSystem(){
        // Creaqte array to hold all Users temporarily
        User[] users = new User[100];

        // Load only customers from users.txt file
        int custCount = Customer.getCustCount();
        FileLoader.loadUsersFile("users.txt", users);

        int customerIndex = 0;
        for (int i = 0; i < custCount; i++) {
            if (users[i] instanceof Customer) {
                customers[customerIndex++] = (Customer) users[i];
            }
        }

        FileLoader.loadCarFile("cars.txt", cars);
    }// end of constructor

    public Car [] getCars(){
        return cars;
    }

    public Customer [] getCustomers(){
        return customers;
    }

//---------------------Rent a Vehicle-------------------
    public static void rentVehicle(Scanner input, Car[] cars, CarRentalSystem sys) {

        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Rent a Vehicle            ");
        System.out.println("\n=====================================");

        sys.displayAllCars();

        System.out.print("Press Enter to continue to login or '0' to exit... ");
        String choice = input.nextLine();//ask user if they want to continue to login or exit
        System.out.println("\n");
        // Check if user wants to exit
        if (choice.equals("0")) {
        	Helper.clearScreen();
            return;
        }

        System.out.print("\nEnter the Vehicle's Car ID: ");
        String carId = input.nextLine();
            
        Car targetCar = sys.findCarById(carId);
        if (targetCar == null) {
        System.out.println("Cannot find the " + carId + " Car.");
            } 
        else {

        if (!targetCar.getStatus().equalsIgnoreCase("available")) { // if not available then cannot borrow
            System.out.println("Current car status is " + targetCar.getStatus() + ", so not available now.");
        } else { // car available
            targetCar.setStatus("unavailable"); 
            System.out.println("Successful , You have booked the " + carId + " Vehicle.");
            System.out.println("This Vehicle information: " + targetCar.toString());
        }
    }

    }

    public Car findCarById(String carId) {
        for (int i = 0; i < Car.getCarCount(); i++) {

            if (cars[i] != null && cars[i].getCarID().equalsIgnoreCase(carId)) {
                return cars[i]; 
            }
        }
        return null; // not found
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
    public static void processPayment(Scanner input){
        boolean isRunning = true;
        int totalCharge = 0; //Temporary

        while (isRunning) {
            System.out.println("\n=====================================");
            System.out.println("\n              Payment                ");
            System.out.println("\n=====================================");

            System.out.println("Select payment method ([C]Cash, [K]Card: ");
            char option = input.next().charAt(0);

            if (option == 'C') {
                Helper.delay(3);
                System.out.println("Payment type selected: Cash");
                //Show damages and rent cost, calculated in payment class
                System.out.println("Enter the amount you wish to pay: ");
                double payAmount = input.nextDouble();
                //calculateTotalCost() {payAmount - totalCost}, need to be added in payment class
                Helper.delay(3);
                System.out.println("Change: ");
                System.out.println("Thank you for renting with us, please come again!");
                Helper.delay(5);
                isRunning = false;

            } else if (option == 'K') {
                Helper.delay(3);
                System.out.println("Enter your card pin number: ");
                int pinNumber = input.nextInt(); //Basically mock process which provide 0 use

                System.out.println("Amount charged: " + totalCharge);
                System.out.println("Thank you for renting with us, please come again!");
                Helper.delay(5);
                isRunning = false;
            } else {
                System.out.println("Invalid option selected, please enter C or K only!");
                Helper.delay(5);
            }
        }

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
        System.out.println("CarID       |Plate      |Brand      |Model      |DailyRate  |Seats      |Mileage    |Status     |Fuel       |");
        System.out.println("--------------------------------------------------------------------------");

        if (Car.getCarCount() == 0) {
            System.out.println("                     [ Currently no available vehicle record ]                      ");
        } else {
            for (int i = 0; i < Car.getCarCount(); i++) {
                if(cars[i] != null){
                    System.out.println(cars[i].toString());
                    }
            }
        }
        System.out.println("==========================================================================");
    }

    public double calculateTotalCost(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            private double totalAmount = Payment.calculateDamage + cars[i].calcRentalFee();
            return totalAmount;
        }

    }

    // Admin function
    public void addCarToSystem(String filename, Car newCar) {
        if (Car.getCarCount() < cars.length) {
            cars[Car.getCarCount()] = newCar;

            utils.FileUploader.saveCarsToFile(filename, this.cars); 
            System.out.println("\nVehicle record has been uploaded to the system.");
        } 
        else {
            System.out.println("\nError, the garage is full, can not add new vehicle.");
            }
    }

}
