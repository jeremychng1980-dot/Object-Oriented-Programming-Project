package models;
import java.util.Scanner;
import utils.Helper;
import utils.FileLoader;
import utils.FileUploader;
import models.Car;
import models.Customer;
import models.User;

public class CarRentalSystem {

    private Car[] cars = new Car[100];
    private Customer[] customers = new Customer[100];
    private Payment[] payments = new Payment[100];

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

    public Payment [] getPayments(){
        return payments;
    }

//---------------------Rent a Vehicle RESERVATION-------------------
    public double reservation(Scanner input, String carID, CarRentalSystem sys) {

        int rentalDayCount;
        double toBePaid;

        Car targetCar = sys.findCarById(carID);

        if (targetCar == null) {
        System.out.println("Cannot find the " + carID + " Car.");
            } 
        else {

            if (!targetCar.getStatus().equalsIgnoreCase("available")) { // if not available then cannot borrow
                System.out.println("Current car status is " + targetCar.getStatus() + ", so not available now.");
            } 
            else { // car available
                targetCar.setStatus("unavailable"); 
                System.out.println("Successful , You have booked the " + carID + " Vehicle.");
                System.out.println("This Vehicle information: " + targetCar.toString());
                System.out.println("Enter the days you wish to rent for: ");
                rentalDayCount = input.nextInt();
                toBePaid = rentalDayCount * targetCar.getDailyRate();
                System.out.println("Total rental fee (Without any additional charges): RM " + toBePaid);
                Helper.delay(5);
                return toBePaid;
            }
        }
        
        return 0.0;
    }

    public Car findCarById(String carID) {
        for (int i = 0; i < Car.getCarCount(); i++) {

            if (cars[i] != null && cars[i].getCarID().equalsIgnoreCase(carID)) {
                return cars[i]; 
            }
        }
        return null; // not found
    }

//-----------------------Check out-----------------------------
    public static void checkOut(Scanner input, CarRentalSystem sys) {
        
        System.out.println("\n=====================================");
        System.out.println("\n             Check  Out              ");
        System.out.println("\n=====================================");

        System.out.print("Press Enter to continue to login or '0' to exit... ");
        String choice = input.nextLine();//ask user if they want to continue to login or exit
        System.out.println("\n");
        // Check if user wants to exit
        if (choice.equals("0")) {
        	Helper.clearScreen();
            return;
        }

        System.out.print("Enter the Vehicle's Car ID: ");
        String carId = input.nextLine();
        Car targetCar = sys.findCarById(carId);
        
        if (targetCar == null) {
            System.out.println("Cannot find the " + carId + " Car.");
        } else {
            if (targetCar.getStatus().equalsIgnoreCase("available")) {
                targetCar.setStatus("unavailable"); 
                System.out.println("Successful , You have checked out the " + carId + " Vehicle.");
                Helper.delay(5);
            } 
            else { // car available
                System.out.println("Current car status is " + targetCar.getStatus() + ", so not checked out yet.");
            }
            
        }

        // how to store this car rented by this customer


    }




//------------------------Process Return---------------------
    public static void processReturn(Scanner input) {

        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Process Return            ");
        System.out.println("\n=====================================");

        System.out.println("Enter the damage option for the car returned (None/ Minor/ Moderate/ Heavy) :");
        String damageOption = input.nextLine();
        damageOption = damageOption.toLowerCase(); // Convert input to lowercase for case-insensitive comparison

        if (damageOption.equals("none") || damageOption.equals("minor") || damageOption.equals("moderate") || damageOption.equals("heavy")) {\
        
            double paymentAmount = payment.getDamageCharge();
            System.out.println("Damage charge calculated: RM " + paymentAmount);
            return paymentAmount;
        } else {
            System.out.println("Invalid damage option entered. Please enter None, Minor, Moderate, or Heavy.");
        }
    }
                          

//--------------------Process Payment-----------------------
    public static void processPayment(Scanner input, double toBePaid){
        boolean isRunning = true;
        double totalCharge = 0;
        double payAmount;

        while (isRunning) {
            System.out.println("\n=====================================");
            System.out.println("\n              Payment                ");
            System.out.println("\n=====================================");

            System.out.println("Select payment method ([C]Cash, [K]Card, [T]Online Transfer): ");
            char option = input.next().charAt(0);

            if (option == 'C') {
                Helper.delay(3);
                System.out.println("Payment type selected: Cash");
                //Show damages and rent cost, calculated in payment class
                System.out.println("Enter the amount you wish to pay: ");
                payAmount = input.nextDouble();
                //calculateTotalCost() {payAmount - totalCost}, need to be added in payment class
                Helper.delay(3);
                System.out.println("Change: " + (payAmount - toBePaid));
                System.out.println("Thank you for renting with us, please come again!");
                Helper.delay(5);
                isRunning = false;

            } else if (option == 'K') {
                Helper.delay(3);
                System.out.println("Enter your card PIN number: ");
                int pinNumber = input.nextInt(); //Basically mock process which provide 0 use



                System.out.println("Amount charged: " + toBePaid);
                System.out.println("Thank you for renting with us, please come again!");
                Helper.delay(5);
                isRunning = false;
            } else if (option == 'T') {
                Helper.delay(3);
                System.out.println("Enter your double-verification code: ");
                int pinNumber = input.nextInt(); //Basically mock process which provide 0 use

                System.out.println("Amount charged: " + toBePaid);
                System.out.println("Thank you for renting with us, please come again!");
                Helper.delay(5);
                isRunning = false;
                
            } else {
                System.out.println("Invalid option selected, please enter C, K or T only!");
                Helper.delay(5);
            }
        }

    }//end ProcessPayment//end ProcessPayment

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
        System.out.println("Total car count: " + Car.getCarCount());
    }
/* 
    public double calculateTotalCost(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            private double totalAmount = Payment.calculateDamage + cars[i].calcRentalFee();
            return totalAmount;
        }

    }
*/
    // Staff function 
    public static double inspection(Scanner input, Payment payment){
        double penalty = 0.0;

        System.out.println("Enter the damage option for the car returned (None/ Minor/ Moderate/ Heavy) :");
        String damageOption = input.nextLine();
        damageOption = damageOption.toLowerCase(); // Convert input to lowercase for case-insensitive comparison

        if (damageOption.equals("none") || damageOption.equals("minor") || damageOption.equals("moderate") || damageOption.equals("heavy")) {
        
            double paymentAmount = payment.getDamageCharge();
            System.out.println("Damage charge calculated: RM " + paymentAmount);
            return paymentAmount;
        } else {
            System.out.println("Invalid damage option entered. Please enter None, Minor, Moderate, or Heavy.");
        }

        // switch-case --> penalty --> return penalty 

        return penalty;
    }



    // Admin function
    public void addCarToSystem(String filename, Car newCar) {
        if (Car.getCarCount() < cars.length) {
            cars[Car.getCarCount()] = newCar;

            utils.FileUploader.saveCarsToFile(filename, cars); 
            System.out.println("\nVehicle record has been uploaded to the system.");
        } 
        else {
            System.out.println("\nError, the garage is full, can not add new vehicle.");
            }
    }
}

