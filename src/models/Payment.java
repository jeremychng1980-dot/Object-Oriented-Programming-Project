package models;

import java.util.Date;

/* TODO:
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
    private PaymentMethod paymentMethod;
    private double damageCharge;
    private double deposit; //TODO: Can be implemented later

    //Referenced characteristics
    private String customerID; //Who paid
    private String carID;      //Which car the payment is for

    // ================= Constructors =================
    public Payment() {
        this(new Date(), 0.0, null);
    }


    public Payment(Date date, double amount, PaymentMethod paymentMethod) {
        this.paymentID = generatePaymentID();
        this.date = date;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Payment(String carID, String damageCondition) {
        this.paymentID = generatePaymentID();
        this.carID = carID;
        this.damageCharge = calculateDamageCharge(damageCondition);
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

    public PaymentMethod getPaymentMethod()  {
        return paymentMethod;
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



    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
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
               "\nAmount: " + amount +
               "\nPayment Method: " + paymentMethod;
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
