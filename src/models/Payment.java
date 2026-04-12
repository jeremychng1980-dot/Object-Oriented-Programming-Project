package models;

import java.util.Date;

public class Payment {
    // data properties
    private String paymentID;
    private Date date;
    private double amount;
    private static int paymentCounter;
    private PaymentMethod paymentMethod;
    //constant d.p
    private double damageCharge;
    private static final double MINOR_DAMAGE = 500;
    private static final double MODERATE_DAMAGE = 1000;
    private static final double MAJOR_DAMAGE = 1500;

    // no-args constructor
    public Payment() {
        this(new Date(),0.0f, null);
    }
    
    // constructor with args
    public Payment(Date date, double amount, PaymentMethod paymentMethod) {
        this.paymentID = generatePaymentID(); // use generatePaymentID() method
        this.date = date;
        this.amount = amount;
        this.paymentMethod = paymentMethod;

    }

    // method to generate paymentID
    private static String generatePaymentID() {
        paymentCounter++;
        return String.format("P%04d", paymentCounter);
    }

    // ============== getters ===============
    public String getPaymentID() {
        return paymentID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    } 

    public double getDamageCharge(){
        return damageCharge;
    }

    public PaymentMethod PaymentMethod(){
        return paymentMethod;
    }

    public static double getMinorDamage(){
        return MINOR_DAMAGE;
    }

    public static double getModerateDamage(){
        return MODERATE_DAMAGE;
    }

    public static double getMajorDamage(){
        return MAJOR_DAMAGE;
    }
    
    // ============== setters ================
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDamageCharge(double damageCharge){
        this.damageCharge = damageCharge;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public static void setPaymentCounter(int paymentCounter){
        Payment.paymentCounter = paymentCounter;
    }

    // ============== other methods ==============
    public String toString() {
        return "Payment ID: " + paymentID +
               "\nDate: " + date +
               "\nAmount: " + amount +
               "\n" + PaymentMethod();
            }//end toString()

    public void calculateDamage(String damageOption) { //reference for actual damage calculation
            switch (damageOption) {
                case "none": //No damage
                    break;
                case "minor": // Minor
                    damageCharge += MINOR_DAMAGE;
                    break;
                                                                                    
                case "moderate": // Moderate
                    damageCharge += MODERATE_DAMAGE;
                break;
                                 
                case "heavy": // High
                    damageCharge += MAJOR_DAMAGE;
                default:
                    System.out.println("Invalid damage option!");
                }//end switchbreak
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Payment other = (Payment) obj;
        return this.paymentID.equals(other.paymentID);
    }
}//end of Payment Class