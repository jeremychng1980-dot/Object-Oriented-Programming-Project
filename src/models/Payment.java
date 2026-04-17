package models;

import java.util.Date;

/* TODO: Notes
Add damage condition
Set fixed value for each level of condition
Display penalty rate for each
Add to finalPayment
Reservation should know estimation of how much
Each car has their own rental rate
 */

public class Payment {

    // ================= Data Properties =================
    private Date date;
    private double amount;//amount received from customer
    private static int paymentCounter;

    // Payment
    private String paymentID;
    private int rentDuration; // can be used to calculate amount based on car's daily rate
    private double damageCharge;
    private double deposit; //TODO: Can be implemented later

    //Referenced characteristics
    private String customerID; //Who paid
    private String carID;      //Which car the payment is for

    // ================= Constructors =================
    public Payment() {
        this(generatePaymentID(), new Date(), 0.0, 0.0, "NO_DAMAGE", null, null, 0);
    }

    public Payment(String paymentID, Date date, double amount, double deposit, String damageCondition, 
        String customerID, String carID, int rentDuration) {
        this.paymentID = generatePaymentID();
        date = new Date();
        this.amount = 0.0; // amount can be calculated later based on rental duration and car rate
        this.deposit = 0.0; // can be set based on car type or rental duration
        this.damageCharge = calculateDamageCharge(damageCondition);
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = rentDuration;
    }

    public Payment(String customerID, String carID, String damageCondition) {
        this.paymentID = generatePaymentID();
        date = new Date();
        this.amount = 0.0; // amount can be calculated later based on rental duration and car rate
        this.deposit = 0.0; // can be set based on car type or rental duration
        this.damageCharge = calculateDamageCharge(damageCondition);
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = 0; // can be set later when rental duration is known
    }

    public Payment(Date date, double amount) {
        this.paymentID = generatePaymentID();
        this.date = date;
        this.amount = amount;
    }

    public Payment(String customerID, String carID, int rentDuration) {
        date = new Date();
        this.amount = 0.0; // amount can be calculated later based on rental duration and car rate
        this.deposit = 0.0; // can be set based on car type or rental duration
        this.damageCharge = calculateDamageCharge("NO_DAMAGE");
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = rentDuration; // can be set later when rental duration is known
    }

    // ================= ID Generation =================
    private static String generatePaymentID() {
        paymentCounter++;
        return String.format("P%04d", paymentCounter);
    }

    // ================= Getters =================
    public String getPaymentID() {
        return paymentID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getDeposit(){
        return deposit;
    }

    public double getDamageCharge() {
        return damageCharge;
    }

    public static int getPaymentCounter() {
        return paymentCounter;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCarID() {
        return carID;
    }

    public static int getPaymentCount() {
        return paymentCounter;
    }

    public static void setPaymentCount(int count) {
        paymentCounter = count;
    }

    public int getRentDuration() {
        return rentDuration;
    }



    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }


    // ================= Setters =================
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDeposit(double deposit){
        this.deposit = deposit;
    }

    public void setDamageCharge(double damageCharge) {
        this.damageCharge = damageCharge;
    }


    public static void setPaymentCounter(int paymentCounter) {
        Payment.paymentCounter = paymentCounter;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }
    
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
        try {
            int value = Integer.parseInt(paymentID.substring(1));
            if (value > paymentCounter) {
                paymentCounter = value;
            }
        } catch (NumberFormatException e) {
            // ignore invalid format
        }
    }


    // ================= Other Methods =================

    public String paymentToString() {
        return "Payment ID: " + paymentID +
               "\nDate: " + date +
               "\nAmount: " + amount;
    }

    public double calculateDamageCharge(String damageCondition) {
        switch (damageCondition.toUpperCase()) {
            case "NO_DAMAGE":
                return 0.0;
            case "MINOR":
                return 100.0; // Example charge for minor damage
            case "MODERATE":
                return 500.0; // Example charge for moderate damage
            case "MAJOR":
                return 1000.0; // Example charge for major damage
            default:
                throw new IllegalArgumentException("Invalid damage condition: " + damageCondition);
        }
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Payment other = (Payment) obj;
        return this.paymentID.equals(other.paymentID);
    }
}
