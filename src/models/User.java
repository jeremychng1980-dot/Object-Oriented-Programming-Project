package models;

public class User {
    // Attributes
    private String loginID;
    private String password;
    private String name;
    private char gender;
    private String phoneNo;
    private static int userCount = 0;
    
    // No-arg constructor
    public User() {
    	this(" ", " ", " ", ' ', " ");
    	userCount++;
    }
    
    // Parameterized constructor
        public User(String loginID,String password,String name, char gender,String phoneNo){
        this.loginID = loginID;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        userCount++;
    }
    
       // Getters and Setters   
     public String getLoginID() {
        return loginID;
    }
    
     public String getPassword() {
        return password;
    }
    
    public char getGender() {
        return gender;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }
    
    public String getName() {
        return name;
    } 
    public static int getUserCount(){
    	return userCount;
    }
    
    public void setLoginID(String loginID) {
        this.loginID = loginID;   
    }
    
     public void setPassword(String password) {
        this.password = password;
    }
   
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void setName(String name) {
        this.name = name;
    }

//---------------------------------non empty checking methods-----------------------------------
    public static String validateNonEmpty(String value, String fieldName) {
    if (value == null || value.trim().isEmpty()) { //check if its empty
        throw new IllegalArgumentException(fieldName + " field cannot be empty!");//custom message if its empty
    }
    return value.trim();//else return the value
}

//---------------------------------Register customer name checking method----------------------------------
    public static String validateRegisterName(String RegisterName) {
    //use the existing validateNonEmpty method to check for empty
    String trimmed = validateNonEmpty(RegisterName, "Name");
    
    //Check if there's number
    for (int i = 0; i < trimmed.length(); i++) {
        if (Character.isDigit(trimmed.charAt(i))) {
            throw new IllegalArgumentException("Name field cannot contain numbers!");//custom message if the input contain a number
        }
    }
    
    return trimmed;//return the trim value if no error
}

//-----------------------------Register customer gender checking method-------------------------------
    public static char validateRegisterGender(String RegisterGender) {
    // Check if empty
     String trimmed = validateNonEmpty(RegisterGender, "Gender");
     
    int choice;
    
    try {
        choice = Integer.parseInt(trimmed);//convert trimmed back to int and store in choice 
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid input! Please enter 1 for Male or 2 for Female.");//custom error message if its not a number
    }
    //return the gender M or F if no error
    if (choice == 1) {
        return 'M';
    } else if (choice == 2) {
        return 'F';
    } else {
        throw new IllegalArgumentException("Invalid choice! Please enter 1 for Male or 2 for Female.");//custom error message if its not 1 or 2
    }
}

//----------------------------------to display string gender--------------------------------------
   public String strGender(char gender){
   	if(gender == 'M'){
   		return "Male";
   }else{
   	     return "Female";
   }
   }
   
//------------------------------------validate the digits number and checks if its digits only------------------------
   
   public static String validateDigitsNum(String value, String fieldName, int exactLength) {
    
    String trimmed = validateNonEmpty(value, fieldName);//check if empty (reusing validateNonEmpty)
    
    // Check exact length
    if (trimmed.length() != exactLength) {
        throw new IllegalArgumentException(fieldName + " must be exactly " + exactLength + " digits! You entered " + trimmed.length() + " character(s)."); 
    }
    
    // Check each character whether it is a digit
    for (int i = 0; i < trimmed.length(); i++) {
        if (!Character.isDigit(trimmed.charAt(i))) {
            throw new IllegalArgumentException(fieldName + " can only contain digits (0-9)");
        }
    }
    
    return trimmed;//return the trimmed value if no error
}
 
//------------------------------------Register customer Phone Number checking method------------------------  
   public static String validateRegisterPhoneNo(String RegisterPhoneNo) {
    return validateDigitsNum(RegisterPhoneNo, "Phone number", 10);//call the methods
}

//------------------------------------check for loginID and password in login Page--------------------------
   public boolean verifyLogin(String inputLoginID, String inputPassword) {
    return this.loginID.equals(inputLoginID) && this.password.equals(inputPassword); //checks if the entered login ID and password match the stored login ID and password 
}
//------------------------------------ Equals method------------------------------------------------------
// checks if this User is equal to another User object by comparing their login IDs.
    public boolean equals(Object obj) { //pass the object into the parameter of the method
    if (this == obj) return true; //check if its the same object, return true if same
    if (obj == null) return false;//check whether if the object is null, if yes then false
    if (getClass() != obj.getClass()) return false;//check if same type of class
    
    User other = (User) obj;//cast the object to user
    return this.loginID.equals(other.loginID);//compare loginID
}
//-----------------------------------toString methods-----------------------------------------------------
    public String toString(){
    	return "Login ID: " + loginID +
    		   "\nName: " + name +
    		   "\nGender: " + strGender(gender)+
    		   "\nPhone Number: " + phoneNo;
    }
}