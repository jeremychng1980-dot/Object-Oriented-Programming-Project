package models;


public class Customer extends User {
    // Attributes
    private String custID;
    private String email;
    private License license;
    private static int custCount = 0;  // Static counter for all customers
    
    // No-arg constructor
    public Customer() {
         this(" ", " ", " ", ' ', " ", " ", null);
        custCount++;
        this.custID = generateCustID();
    }
    
    // Parameterized constructor
    public Customer(String loginID, String password, String name, char gender, 
                    String phoneNo, String email, License license) {
        super(loginID, password, name, gender, phoneNo);
        this.email = email;
        this.license = license;
        custCount++;
        this.custID = generateCustID();
    }
    
    // Generate Customer ID (C001, C002, etc.)
    private String generateCustID() {
        return "C" + String.format("%03d", custCount);
    }
    
    // Getters
    public String getCustomerID() {
        return custID;
    }
    
    public String getEmail() {
        return email;
    }
    
    public License getLicense() {
        return license;
    }
    
    public static int getCustCount() {
        return custCount;
    }
    
    // Setters
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setLicense(License license) {
        this.license = license;
    }
    
    public void setCustomerID(String custID) {
    this.custID = custID;
}
//------------------------------------------validate register email----------------------------------------------    
      public static String validateRegisterEmail(String RegisterEmail) {
    // Check if null
    String trimmed = User.validateNonEmpty(RegisterEmail, "Email");
    
    // Check if contains @
    if (!trimmed.contains("@")) {
        throw new IllegalArgumentException("Email must contain '@' symbol!");
    }
    
    // Get position of @
    int atIndex = trimmed.indexOf("@");
    
    // Check if there's something before @ (username)
    if (atIndex == 0) {
        throw new IllegalArgumentException("Email must have a username before '@'!");
    }
    
    // Check if there's something after @ (domain)
    if (atIndex == trimmed.length() - 1) {
        throw new IllegalArgumentException("Email must have a domain after '@'!");
    }
    
    // Check if domain contains a dot (.)
    String domain = trimmed.substring(atIndex + 1);
    if (!domain.contains(".")) {
        throw new IllegalArgumentException("Email must contain a domain with a dot (e.g., .com, .org)!");
    }
    
    // Check if domain starts with dot
    if (domain.startsWith(".")) {
        throw new IllegalArgumentException("Email domain cannot start with a dot!");
    }
    
    // Check if domain ends with dot
    if (domain.endsWith(".")) {
        throw new IllegalArgumentException("Email domain cannot end with a dot!");
    }
    
    return trimmed;
}
//-----------------------------------Equals Method---------------------------
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    
    // Must be a Customer (not just any User)
    if (!(obj instanceof Customer)) return false;
    
    Customer other = (Customer) obj;
    return this.custID.equals(other.custID);
}

//-------------------------------------toString---------------------------
    public String toString(){ //to String method
    	return "Cust ID: "+ custID +
    		    "\n" + super.toString() +
    		   "\nEmail: " + email +
    		   "\n" + license.toString();
    }
}