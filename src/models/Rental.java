package models;

import java.util.Date;

import models.Customer;
import models.Car;


public class Rental{
    private String rentalID;
    private String custID;
    private String carID;

    private Date rentalStartDate;
    private Date rentalEndDate;
    private Date actualReturnDate;
    private int estimatedDays;

    private double rentalCost;
    private double damageCost;

    private String rentalStatus;
    private static int rentalCount = 0;

    public Rental() {
        this();
    }
    
    public Rental(String custID, String carID, Date rentalStartDate, Date rentalEndDate, Date actualReturnDate, 
        int estimatedDays, double rentalCost, double damageCost, String rentalStatus) {
         = ;
    }

    
}
