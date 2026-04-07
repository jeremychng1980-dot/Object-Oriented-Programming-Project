import cli.Menu;
import models.Admin;
import models.Customer;
import models.User;
import models.Staff;
import models.License;
import utils.Helper;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

public class Main{
	
    static User[] users = new User[100]; //User polymorphic array
    private static final String USER_FILE = "users.txt"; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        loadUsersFile();
//-----------------------First Page---------------------     
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
                    customerLogin(); //to customer login page
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
                    System.out.println("\n? Admin login coming soon!");
                    System.out.println("Press Enter to continue...");
                    input.nextLine();
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
//--------------------------------------------Customer Registration-----------------------------------
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
        
        saveUsersToFile();//save to file
        
        System.out.println("\n=====================================");
        System.out.println("        REGISTRATION SUCCESSFUL!     ");
        System.out.println("=====================================");
        User[] tempArray = {users[User.getUserCount()- 1]}; //create temporary array using newCustomer object 
		displayUsers(tempArray, 1); // call method to print register information, (the index of the array i pass in, to avoid it continue printing
		                            //  so it print one only
		System.out.println("=====================================");
    
    System.out.println("\nPress Enter to continue...");
    input.nextLine();
    Helper.clearScreen();
}
//------------------------------ instanceof method---------------------------------
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
//-------------------------------Customer Login Page-----------------------------------------------
    public static void customerLogin() {
    Scanner input = new Scanner(System.in);
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
//-------------------------------- Customer main menu------------------------------------
    
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
        System.out.println("3. Rent a Vehicle");
        System.out.println("4. Check out");
        System.out.println("5. Return");
        System.out.println("6. Payment");
        System.out.println("7. View History");
        System.out.println("8. Log out");
        System.out.println("=====================================");
        
        choice = Helper.getValidatedInt(input, "Please enter a number (1-8): ", 1, 8); //use the reusable validation method
        
        switch(choice) {
            case 1:
                viewCustomerInformation(loggedInCustomer);
                break;
            case 2:
                updateLicenseExpiryDate(loggedInCustomer);
                break;
            case 3: 
                rentVehicle();
                break;
            case 4:
                System.out.println("Checkout coming soon");
                break;
            case 5:
                processReturn();
                break;
            case 6:
                System.out.println("Payment coming soon");
                break;
            case 7:
                System.out.println("View History coming soon");
                break;
            case 8:
                break;
        }
        
    } while (choice != 2);
}
//------------------------View Information Page ---------------------------------    
    public static void viewCustomerInformation(Customer customer) {
    Helper.clearScreen();
    System.out.println("\n=====================================");
    System.out.println("           YOUR INFORMATION            ");
    System.out.println("=====================================");
    
    User[] tempArray = {customer}; // create a temparary array that store the specific object of this customer
    
    displayUsers(tempArray, 1);// Use the instance of method to print
    
    System.out.print("License Status: ");//check if the license status is expired
    if (customer.getLicense().isExpired()) {
        System.out.println("Expired");
    } else {
        System.out.println("Valid");
    }
    
    System.out.println("\nPress Enter to Exit...   ");
    new Scanner(System.in).nextLine();  // Wait for user to press Enter
    Helper.clearScreen();
}

//-------------------------------Modify Customer License Expiry Date -------------
	public static void updateLicenseExpiryDate(Customer customer) {
		Scanner input = new Scanner(System.in);
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

            
            saveUsersToFile();  // Save changes to file
            
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

//-----------------------Rent a Vehicle-----------------------------------------
    public static void rentVehicle(){
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Rent a Vehicle            ");
        System.out.println("\n=====================================");

        
    }


//------------------------Process Return----------------------------
    public static void processReturn(){
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n           Process Return            ");
        System.out.println("\n=====================================");
    }



//-------------------------View History-------------------------------
    public static void viewHistory(){
        Helper.clearScreen();
        System.out.println("\n=====================================");
        System.out.println("\n         View Booking History        ");
        System.out.println("\n=====================================");
    }

//-------------------------------Save users to file method------------------------
public static void saveUsersToFile() {
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(new FileWriter(USER_FILE));
        
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
                    // Format: staffID|loginID|password|name|gender|phoneNo
                    writer.print(s.getStaffID() + "|");
                    writer.print(s.getLoginID() + "|");
                    writer.print(s.getPassword() + "|");
                    writer.print(s.getName() + "|");
                    writer.print(s.getGender() + "|");
                    writer.print(s.getPhoneNo());
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
//----------------------------LoadUsersFile---------------------------
public static void loadUsersFile() {
    File file = new File(USER_FILE);
    
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
        
        // Read each user
        for (int i = 0; i < totalUsers; i++) {
            String userType = reader.readLine();
            
            if (userType == null) break;
            
            if (userType.equals("CUSTOMER")) {
                String dataLine = reader.readLine();
                if (dataLine == null) break;
                
                // FIX: Use \\| for split (pipe is special character)
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
                
                users[User.getUserCount() - 1] = customer;
            }
            else if (userType.equals("STAFF")) {
                String dataLine = reader.readLine();
                if (dataLine == null) break;
                
                // FIX: Use \\| for split
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
                
                users[User.getUserCount() - 1] = staff;
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
                
                users[User.getUserCount() - 1] = admin;
            }
        }
           
        
    } catch (IOException e) {
        System.out.println("Error reading user file: ");
    } catch (ParseException e) {
        System.out.println("Error parsing date in file: ");
    }
}
}
