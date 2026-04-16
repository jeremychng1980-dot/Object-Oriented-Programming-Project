import models.*;
import utils.Helper;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

public class TestCarRentalSystem{
    static Scanner input = new Scanner(System.in); 
    static User[] users = new User[100]; //User polymorphic array
    static CarRentalSystem sys = new CarRentalSystem();
    CarRentalSystem[] crs = new CarRentalSystem[100];

    public static void main(String[] args) {
        // Load existing users from file
        utils.FileLoader.loadUsersFile("users.txt", users);
        utils.FileLoader.loadCarFile("cars.txt", sys.getCars());

//-----------------------First Page---------------------    
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do{
        	System.out.println("\n=====================================");
            System.out.println("     CAR RENTAL MANAGEMENT SYSTEM    ");
            System.out.println("=====================================");
            System.out.println("1. Customer Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Staff Login");
            System.out.println("4. Admin Login");
            System.out.println("5. Exit");
            System.out.println("=====================================");
        	
        	choice = Helper.getValidatedInt(input, "Please enter a number (1-5): ", 1, 5); //use the reusable validation method
        	
        	  switch(choice) {
                case 1:
                    customerLogin(input); //to customer login page
                    break;
                case 2:
                    customerRegistration();//to customer registration page
                    break;
                case 3:
                    System.out.println("\n? Staff login coming soon!");
                    System.out.println("Press Enter to continue...");
                    input.nextLine();
                    break;
                case 4:
                    adminLogin(input);
                    break;
                case 5:
                    System.out.println("\n=====================================");
                    System.out.println("     Thank you for using the system!");
                    System.out.println("     Goodbye!");
                    System.out.println("=====================================");
                    break;

            }
        	
        }while (choice != 5);
        
        input.close();
    }
//Customer Registration
    public static void customerRegistration(){
    	 Scanner input = new Scanner(System.in);
    	 
    	Helper.clearScreen();
    	System.out.println("\n=====================================");
        System.out.println("       CUSTOMER REGISTRATION         ");
        System.out.println("=====================================");
       
     String loginID = "";
    String password = "";
    String name = "";
    char gender = ' ';
    String phoneNo = "";
    String email = "";
    String drivingLicenseNo = "";      
    Date licenseExpireDate = null;      
    
    System.out.print("Press Enter to continue to register or '0' to exit... ");
    
    String userChoice = input.nextLine();//ask user if they want to return or proceed to register
    System.out.println("\n");
        
    // Check if user wants to exit
    if (userChoice.equals("0")) {
       Helper.clearScreen();
       return;
    }
        
    // LOGIN ID
    boolean loginValid = false;
    while (!loginValid) {
        try {
            System.out.print("Enter Login ID: ");
            loginID = input.nextLine();//get the login ID input
            loginID = User.validateNonEmpty(loginID, "Login ID");//call the method for non empty checking
            loginValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");//prompt error message if its empty 
        }
    }
    
    // PASSWORD
    boolean passwordValid = false;
    while (!passwordValid) {
        try {
            System.out.print("Enter Password: ");
            password = input.nextLine();//get the login ID input
            password = User.validateNonEmpty(password, "Password");//call the method for non empty checking
            passwordValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");//prompt error message if its empty 
        }
    }
    
    // NAME
    boolean nameValid = false;
    while (!nameValid) {
        try {
            System.out.print("Enter Name: ");
            name = input.nextLine();
            name = User.validateRegisterName(name);//call the method for non empty checking
            nameValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");//prompt error message if its empty and got number
        }
    }
    
    // GENDER
    boolean genderValid = false;
    while (!genderValid) {
        try {
            System.out.println("Select Your Gender:");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.print("Enter choice (1-2): ");
            
            String genderInput = input.nextLine();//ask for user input
            gender = User.validateRegisterGender(genderInput);//use the method for checking
            genderValid = true;
            System.out.println((gender == 'M' ? "Male" : "Female") + " selected");//Used tenary operator ?:(a shorthand way of writing if else) if M is equal to male else is female 
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
    
    // PHONE NUMBER
    boolean phoneValid = false;
    while (!phoneValid) {
        try {
            System.out.print("Enter your Phone Number(Exp:0126789991): ");
            phoneNo = input.nextLine();
            phoneNo = User.validateRegisterPhoneNo(phoneNo);
            phoneValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
    
    // EMAIL
    boolean emailValid = false;
    while (!emailValid) {
        try {
            System.out.print("Enter your Email(Exp:john@gmail.com): ");
            email = input.nextLine();
            email = Customer.validateRegisterEmail(email);
            emailValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
    
    // LICENSE NUMBER - NOW USING VARIABLE DECLARED AT TOP
    boolean licenseValid = false;
    while (!licenseValid) {
        try {
            System.out.print("Enter your Driving License Number(Exp:070529070821): ");
            drivingLicenseNo = input.nextLine();  // ? NO "String" here! Just assign
            drivingLicenseNo = License.validateRegisterDrivingLicenseNo(drivingLicenseNo);
            licenseValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
    
    // LICENSE DATE - NOW USING VARIABLE DECLARED AT TOP
    boolean dateValid = false;
    while (!dateValid) {
        try {
            System.out.print("Enter License Expiry Date (yyyy-mm-dd): ");
            String LicenseExpireDateInput = input.nextLine();
            licenseExpireDate = License.validateRegisterLicenseDate(LicenseExpireDateInput);  // ? NO "Date" here!
            dateValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
	License license = new License(drivingLicenseNo, licenseExpireDate);//Create License Object
    
    // Create Customer object
    Customer newCustomer = new Customer(loginID, password, name, gender, 
                                        phoneNo, email, license);
    

        users[User.getUserCount()- 1] = newCustomer;  // Store at correct index
        
        utils.FileUploader.saveUsersToFile("users.txt", users);//save to file
        
        System.out.println("\n=====================================");
        System.out.println("        REGISTRATION SUCCESSFUL!     ");
        System.out.println("=====================================");
        User[] tempArray = {users[User.getUserCount()- 1]}; //create temporary array using newCustomer object 
		Helper.displayUsers(tempArray, 1); // call method to print register information, (the index of the array i pass in, to avoid it continue printing
		                            //  so it print one only
		System.out.println("=====================================");
    
    System.out.println("\nPress Enter to continue...");
    input.nextLine();
    Helper.clearScreen();
}

//Customer Login Page
    public static void customerLogin(Scanner input) {

    boolean loggedIn = false;
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("          CUSTOMER LOGIN              ");
        System.out.println("=====================================");
        
        System.out.print("Press Enter to continue to login or '0' to exit... ");
        String choice = input.nextLine();//ask user if they want to continue to login or exit
        System.out.println("\n");
        // Check if user wants to exit
        if (choice.equals("0")) {
        	Helper.clearScreen();
            return;
        }
        
        while (!loggedIn) {
        String loginID = "";
        String password = "";
        
        // LOGIN ID 
        boolean loginValid = false;
        while (!loginValid) {
            try {
                System.out.print("Enter Login ID: ");
                loginID = input.nextLine();
                loginID = User.validateNonEmpty(loginID, "Login ID");//call the method to heck if empty
                loginValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");//prompt the custom message if empty 
            }
        }
        
        // PASSWORD
        boolean passwordValid = false;
        while (!passwordValid) {
            try {
                System.out.print("Enter Password: ");
                password = input.nextLine();
                password = User.validateNonEmpty(password, "Password");//call method to check if empty
                passwordValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");//prompt the custom message if empty
            }
        }
        
        for (int i = 0; i < User.getUserCount(); i++) { //go through all the user
            if (users[i] instanceof Customer) { //check if it is a customer, skip the staff object in the array
                Customer c = (Customer) users[i]; //
                if (c.verifyLogin(loginID, password)) { //call the methods on this specific customer object
                    customerMenu(c); //if login successfully pass the specific object to customerMenu
                    return;  // Exit method after successful login
                }
            }
        }
        
        System.out.println("\nInvalid customer login credentials!");
        System.out.println("Please try again.\n");
    }
    }

//Customer main menu
    public static void customerMenu(Customer loggedInCustomer) {
    Scanner input = new Scanner(System.in);
    int choice = 0;
    Helper.clearScreen();
    
    do {
        System.out.println("\n=====================================");
        System.out.println("               WELCOME!                ");
        System.out.println("=====================================");
        System.out.println("1. View Profile");
        System.out.println("2. Modify License Expired Date");
        System.out.println("3. Rent a Vehicle(Reservation)");
        System.out.println("4. Check out");
        System.out.println("5. Return Vehicle");
        System.out.println("6. Payment");
        System.out.println("7. View History record");
        System.out.println("8. Log out");
        System.out.println("=====================================");
        
        choice = Helper.getValidatedInt(input, "Please enter a number (1-8): ", 1, 8); //use the reusable validation method
        
        switch(choice) {
            case 1:
                viewCustomerInformation(loggedInCustomer, input);
                break;
            case 2:
                updateLicenseExpiryDate(loggedInCustomer, input);
                break;
            case 3: 
                rentVehicle(input, sys.getCars());
                break;
            case 4:
                checkout(loggedInCustomer, null, null);
                break;
            case 5:
                processReturn(loggedInCustomer, null, null);
                break;
            case 6:
                processPayment(loggedInCustomer, null, null);
                break;
            case 7:
                CarRentalSystem.viewHistory(); //View history?
                break;
            case 8:
                break;
        }
        
    } while (choice != 8);
}

//View Information Page  
    public static void viewCustomerInformation(Customer customer, Scanner input){
    Helper.clearScreen();
    System.out.println("\n=====================================");
    System.out.println("           YOUR INFORMATION            ");
    System.out.println("=====================================");
    
    User[] tempArray = {customer}; // create a temparary array that store the specific object of this customer
    
    Helper.displayUsers(tempArray, 1);// Use the instance of method to print
    
    System.out.print("License Status: ");//check if the license status is expired
    if (customer.getLicense().isExpired()) {
        System.out.println("Expired");
    } else {
        System.out.println("Valid");
    }
    
    System.out.println("\nPress Enter to Exit...   ");
    input.nextLine();  // Wait for user to press Enter
    Helper.clearScreen();
}

//Modify Customer License Expiry Date
	public static void updateLicenseExpiryDate(Customer customer, Scanner input) {
	Helper.clearScreen();
    System.out.println("\n=====================================");
    System.out.println("      Modify License Expired Date      ");
    System.out.println("=====================================");
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println("Current License Expiry Date: " + sdf.format(customer.getLicense().getLicenseExpireDate()));//print out the license expired date
    System.out.print("License Status: ");//check if the license status is expired
    if (customer.getLicense().isExpired()) {
        System.out.println("Expired");
    } else {
        System.out.println("Valid");
    }
   
    System.out.print("\nPress Enter to continue to modify or '0' to exit... ");
        
        String choice = input.nextLine();//ask user if they want to continue to login or exit
        
        // Check if user wants to exit
        if (choice.equals("0")) {
        	Helper.clearScreen();
            return;
        }
	
	 boolean valid = false;
    while (!valid) {
        try {
            System.out.print("\nEnter New License Expired Date: ");
            String newExpiredDateInput = input.nextLine();
            
            //call the methods to update the new license expired date and also for validation
            customer.getLicense().updateLicenseExpiryDate(newExpiredDateInput, customer.getLicense().getLicenseExpireDate());

            
            utils.FileUploader.saveUsersToFile("users.txt", users);  // Save changes to file
            
            System.out.println("\n==========================================");
    		System.out.println("  License Expired Date Update Successfully!");
    		System.out.println("=============================================");
    		System.out.println("\nNew License Expiry Date: " + sdf.format(customer.getLicense().getLicenseExpireDate()));//print out the license expired date
    		System.out.print("License Status: ");//check if the license status is expired
    		if (customer.getLicense().isExpired()) {
        	System.out.println("Expired");
    		} else {
        	System.out.println("Valid");
    		
    		}
            valid = true;
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    System.out.println("\nPress Enter to continue...");
    input.nextLine();
}      

//Reservation (rentVehicle)
    public static void rentVehicle(Car[] cars){

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

        System.out.print("\n\nEnter the Vehicle's Car ID: ");
        String carID = input.nextLine();


    }

    public static void checkout(Customer loggedInCustomer, Car car, Payment payment){
        
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
            if (targetCar.getStatus().equalsIgnoreCase("unavailable")) { // if not available then can check out
                targetCar.setStatus("available"); 
                System.out.println("Successful , You have checked out the " + carId + " Vehicle.");
                Helper.delay(5);
            } else { // car available
                System.out.println("Current car status is " + targetCar.getStatus() + ", so not checked out yet.");
            }
            
        }
    }//end Checkout
    
    public static void processReturn(Customer loggedInCustomer, Car car, Payment payment){
        
    }//end processReturn

    public static void processPayment(Customer loggedInCustomer, Car car, Payment payment){

    }//end processPayment

//Admin Login
 public static void adminLogin(Scanner input) {
    boolean loggedIn = false;
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("            ADMIN LOGIN              ");
        System.out.println("=====================================");
        
        System.out.print("Press Enter to continue to login or '0' to exit... ");
        String choice = input.nextLine();//ask user if they want to continue to login or exit
        System.out.println("\n");
        // Check if user wants to exit
        if (choice.equals("0")) {
        	Helper.clearScreen();
            return;
        }
        
        while (!loggedIn) {
        String loginID = "";
        String password = "";
        
        // LOGIN ID 
        boolean loginValid = false;
        while (!loginValid) {
            try {
                System.out.print("Enter Login ID: ");
                loginID = input.nextLine();
                loginID = User.validateNonEmpty(loginID, "Login ID");//call the method to heck if empty
                loginValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");//prompt the custom message if empty 
            }
        }
        
        // PASSWORD
        boolean passwordValid = false;
        while (!passwordValid) {
            try {
                System.out.print("Enter Password: ");
                password = input.nextLine();
                password = User.validateNonEmpty(password, "Password");//call method to check if empty
                passwordValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");//prompt the custom message if empty
            }
        }
        
        for (int i = 0; i < User.getUserCount(); i++) { //go through all the user
            if (users[i] instanceof Admin) { //check if it is a admin, skip the staff object in the array
                Admin a = (Admin) users[i]; //
                if (a.verifyLogin(loginID, password)) { //call the methods on this specific admin object
                    adminMenu(a); //if login successfully pass the specific object to adminMenu
                    return;  // Exit method after successful login
                }
        
        }
        
        System.out.println("\nInvalid Admin login credentials!");
        System.out.println("Please try again.\n");
    }
    }   
}// end of admin login

    public static void adminMenu(Admin loggedInAdmin){
    Scanner input = new Scanner(System.in);
    int choice = 0;
    Helper.clearScreen();
    
    do {
        System.out.println("\n=====================================");
        System.out.println("               WELCOME!                ");
        System.out.println("=====================================");
        System.out.println("1. View Profile");
        System.out.println("2. View Car");
        System.out.println("3. Add Car");
        System.out.println("4. Update Mileage");
        System.out.println("5. Set Maintenance Status");
        System.out.println("6. Log out");

        System.out.println("=====================================");
        
        choice = Helper.getValidatedInt(input, "Please enter a number (1-6): ", 1, 6); //use the reusable validation method
        
        switch(choice) {
            case 1:
                viewAdminInformation(loggedInAdmin, input);
                break;
            case 2:
                viewCar(input);
                break;
            case 3: 
                addCar(input);
                break;
            case 4:
                updateMileage(input, sys);
                break;
            case 5:
                setMaintenance(input);
                break;
            case 6:
                break;
        }
        
    } while (choice != 6);
} // end of admin menu

    //======================== ADMIN FUNCTIONS ========================
    public static void viewAdminInformation(Admin admin, Scanner input){
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("           YOUR INFORMATION            ");
        System.out.println("=====================================");
        
        User[] tempArray = {admin}; // create a temparary array that store the specific object of this customer
        
        Helper.displayUsers(tempArray, 1);// Use the instance of method to print
        
        System.out.print("\nPress Enter to Exit...   ");
        input.nextLine();  // Wait for user to press Enter
        Helper.clearScreen(); 
    }//end viewAdminInformation

    public static void viewCar(Scanner input){
        sys.displayAllCars();

        System.out.print("\nPress Enter to Exit...   ");
        input.nextLine();  // Wait for user to press Enter
    }//end viewCar

    public static void addCar(Scanner input){
        Helper.clearScreen();
        System.out.println("=====================================");
        System.out.println("            Add New Vehicle          ");
        System.out.println("=====================================");

        System.out.println("Select Category:");
        System.out.println("1. Economy");
        System.out.println("2. SUV");
        System.out.println("3. Luxury");
        int type = Helper.getValidatedInt(input, "Choice (1-3): ", 1, 3);

        // data input
        System.out.print("Enter Plate Number: ");
        String plate = input.nextLine().trim();
        while(plate.isEmpty()){
            System.out.print("Plate cannot be empty. Please re-enter: ");
            plate = input.nextLine().trim();
        }
        System.out.print("Enter Model: ");
        String model = input.nextLine();
        System.out.print("Enter Brand: ");
        String brand = input.nextLine();
        double rate = Helper.getValidatedDouble(input, "Enter Daily Rate: ");
        int seats = Helper.getValidatedInt(input, "Enter Seating Capacity: ", 2, 7);
        int mileage = Helper.getValidatedInt(input, "Enter Mileage: ", 0, 100000);

        Car newCar = null;

        switch (type) {
            case 1: // Economy
                System.out.print("Is it a Hatchback? (true/false): ");
                boolean isHb = input.nextBoolean();
                System.out.print("Fuel Efficiency (L/100km): ");
                double eff = input.nextDouble();
                //  status default is "available", fuelLevel 100.0
                newCar = new Economy(plate, model, brand, rate, seats, mileage, "available", 100.0, isHb, eff);
                break;

            case 2: // SUV
                System.out.print("Four Wheel Drive? (true/false): ");
                boolean fwd = input.nextBoolean();
                System.out.print("Ground Clearance (mm): ");
                int gc = input.nextInt();
                newCar = new SUV(plate, model, brand, rate, seats, mileage, "available", 100.0, fwd, gc);
                break;

            case 3: // Luxury
                System.out.print("Leather Seats? (true/false): ");
                boolean leather = input.nextBoolean();
                System.out.print("Has Sunroof? (true/false): ");
                boolean sunroof = input.nextBoolean();
                newCar = new Luxury(plate, model, brand, rate, seats, mileage, "available", 100.0, leather, sunroof);
                break;
        }

        // store into file
        if (newCar != null) {
            sys.addCarToSystem("cars.txt", newCar); 
            System.out.println("\nSuccessfully added: " + newCar.getCarID());
        }

        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }//end addCar


    public static void updateMileage(){
        Helper.clearScreen();
        System.out.println("=====================================");
        System.out.println("           Update Mileage            ");
        System.out.println("=====================================");

        System.out.print("Enter Car ID: ");
        String carID = input.nextLine();

        Car target = sys.findCarById(carID);
        
        if (target != null) {
            System.out.println("Current Mileage for " + carID + ": " + target.getMileage() + " KM.");
            
            int additionalKm = Helper.getValidatedInt(input, "Enter additional distance (km): ", 0, 10000);
            
            target.setMileage(target.getMileage() + additionalKm);
            
            utils.FileUploader.saveCarsToFile("cars.txt", sys.getCars());
            
            System.out.println("\nMileage updated successfully!");
        } 
        else {
            System.out.println("Error: Car ID not found.");
        }
        input.nextLine();
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }

    public static void setMaintenance(Scanner input){
        Helper.clearScreen();
        System.out.println("=====================================");
        System.out.println("        SET MAINTENANCE STATUS       ");
        System.out.println("=====================================");

        System.out.print("Enter Car ID to send for maintenance: ");
        String carID = input.nextLine();

        Car target = sys.findCarById(carID);

        if (target != null) {
            target.setStatus("maintenance");

            utils.FileUploader.saveCarsToFile("cars.txt", sys.getCars());
            
            System.out.println("\nVehicle " + carID + " is already in maintenance.");
        } 
        else {
            System.out.println("Error: Car ID not found.");
        }
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }







}//end CarRentalSystem
  
