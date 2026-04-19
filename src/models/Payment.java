package models;

import java.util.Date;

public class Payment {

    // ================= Data Properties =================
    private Date reserveDate;
    private double amount;//amount received from customer
    private static int paymentCounter = 0;
    private Date returnDate;   
    private Date checkOutDate; 
    // Payment
    private String paymentID;
    private int rentDuration; // can be used to calculate amount based on car's daily rate
    private double damageCharge;
    private double deposit; 

    //Referenced characteristics
    private String customerID; //Who paid
    private String carID;      //Which car the payment is for
    private boolean status;  // true represent has completed the payment, false --> not yet

    // ================= Constructors =================
    public Payment() {
        this(new Date(), 0.0, 0.0, "NO_DAMAGE", null, null, 0, false);
    }

    public Payment(Date date, double amount, double deposit, String damageCondition, 
        String customerID, String carID, int rentDuration, boolean status) {
        this.paymentID = generatePaymentID();
        this.reserveDate = date;
        this.checkOutDate = null; // default null
        this.returnDate = null;   // default null
        this.amount = amount; 
        this.deposit = deposit; 
        this.damageCharge = calculateDamageCharge(damageCondition);
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = rentDuration;
        this.status = status;
    }

    public Payment(String customerID, String carID, String damageCondition) {
        this.paymentID = generatePaymentID();
        this.reserveDate = new Date();
        this.checkOutDate = null;
        this.returnDate = null;
        /*this.amount = amount; 
        this.deposit = deposit;*/ 
        this.damageCharge = calculateDamageCharge(damageCondition);
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = 0; 
        this.status = false;
    }

    public Payment(Date date, double amount) {
        this.paymentID = generatePaymentID();
        this.reserveDate = date;
        this.checkOutDate = null;
        this.returnDate = null;
        this.amount = amount;
    }

    public Payment(String customerID, String carID, int rentDuration) {
        this.reserveDate = new Date();
        this.checkOutDate = null;
        this.returnDate = null;
        this.amount = 0.0; 
        this.deposit = 0.0; 
        this.damageCharge = calculateDamageCharge("NO_DAMAGE");
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = rentDuration; 
        this.status = false;
    }

    public Payment(String customerID, String carID, double amount, int rentDuration) {
        this.reserveDate = new Date();
        this.checkOutDate = null;
        this.returnDate = null;
        this.paymentID = generatePaymentID();
        this.amount = amount;
        this.deposit = 0.0; 
        this.damageCharge = calculateDamageCharge("NO_DAMAGE");
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = rentDuration;
        this.status = false;
    }

    public Payment(String customerID, String carID) {
        this.reserveDate = new Date();
        this.checkOutDate = null;
        this.returnDate = null;
        this.amount = 0.0; 
        this.deposit = 0.0; 
        this.damageCharge = calculateDamageCharge("NO_DAMAGE");
        this.customerID = customerID;
        this.carID = carID;
        this.rentDuration = 0; 
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

    public Date getReserveDate() {
        return reserveDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Date getReturnDate() {
        return returnDate;
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

    public int getRentDuration() {
        return rentDuration;
    }

    public boolean getStatus(){
        return status;
    }

    // ================= Setters =================
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setDate(Date date) {
        this.reserveDate = date;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
               "\nDate: " + reserveDate +
               "\nAmount: " + amount;
    }


    public static boolean isValidCardNumber(String cardNo) {
        return cardNo.matches("\\d{16}");
    }

    public static boolean isValidCCV(String ccv) {
        return ccv.matches("\\d{3,4}");
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]{2,50}");
    }

    public static boolean isValidMonth(String month) {
        try {
            int m = Integer.parseInt(month);
            return m >= 1 && m <= 12;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidYear(String year) {
        try {
            int y = Integer.parseInt(year);
            return y >= 2024;
        } catch (Exception e) {
            return false;
        }
    }
    public double calculateDamageCharge(String damageCondition) {
        switch (damageCondition.toUpperCase()) {
            case "NO_DAMAGE":
                return 0.0;
            case "MINOR":
                return 100.0; 
            case "MODERATE":
                return 500.0; 
            case "MAJOR":
                return 1000.0; 
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