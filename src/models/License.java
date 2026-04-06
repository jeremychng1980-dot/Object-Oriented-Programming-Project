package models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class License {
    // Attributes
    private String drivingLicenseNo;
    private Date licenseExpireDate;  // or use String for simplicity?
    
    // No-arg constructor
    public License() {
    	this(" ", null);
    }
    
    // Parameterized constructor
    public License(String drivingLicenseNo, Date licenseExpireDate) {
        this.drivingLicenseNo = drivingLicenseNo;
        this.licenseExpireDate = licenseExpireDate;
    }
    
    // Getters and Setters
    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }
    
    public Date getLicenseExpireDate() {
        return licenseExpireDate;
    
    }
    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }
    
     public void setLicenseExpireDate(Date licenseExpireDate) {
        this.licenseExpireDate = licenseExpireDate;
    }
//------------------------------------Register customer Driving License checking method------------------------
    public static String validateRegisterDrivingLicenseNo(String RegisterDrivingLicenseNo) {
    return User.validateDigitsNum(RegisterDrivingLicenseNo, "Driving license number", 12);//call the methods from user
}

//-----------------------------------Register customer driving license date expired method-------------------------
     public static Date validateRegisterLicenseDate(String RegisterLicenseDate) {

    if (RegisterLicenseDate == null || RegisterLicenseDate.trim().isEmpty()) {
        throw new IllegalArgumentException("License expiry date cannot be empty!");//check if empty
    }
    
    String trimmed = RegisterLicenseDate.trim();//ctrim the string to remove extra spaces
    
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);  // makes sure that invalid fate fails (e.g. 2026-02-31 will fails)
    
    Date expiryDate;
    try {
        expiryDate = sdf.parse(trimmed);//try to convert the string to date object
    } catch (ParseException e) {
        throw new IllegalArgumentException("Invalid date! Please use yyyy-MM-dd format (e.g., 2025-12-31)");//if fails custom message 
    }
    
    //check if license expired
    Date today = new Date();//get today's date
    if (expiryDate.before(today)) { //compares date whether it is before today or it is today
        throw new IllegalArgumentException("License has already expired! Please enter a future date.");//custom message if it ald expired
    }
    
    return expiryDate;//return the value if no error
}
//-------------------------------Method to check if the date is expired--------------------------------
    public boolean isExpired() {
    Date today = new Date();
    return licenseExpireDate.before(today);
}

//--------------------------------Equals Method----------------------------------------  
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    License other = (License) obj;
    return this.drivingLicenseNo.equals(other.drivingLicenseNo);
}

//--------------------------------ToString Method----------------------------------
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String expiryDate = sdf.format(licenseExpireDate);
        
        return "License Number: " + drivingLicenseNo + 
               "\nLicense Expiry Date: " + expiryDate;
    }
}
