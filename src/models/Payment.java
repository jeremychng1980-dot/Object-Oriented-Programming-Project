package models;

import java.util.Date;

public class Payment {
    // data properties
    private String paymentID;
    private Date date;
    private float amount;
    private static int paymentCounter;
    private float MINOR_DAMAGE;
    private float MODERATE_DAMAGE;
    private float MAJOR_DAMAGE;

    // no-args constructor
    public Payment() {
        this(new Date(),0.0f, 500.0f, 1000.0f, 1500.0f);
    }
    
    // constructor with args
    public Payment(Date date, float amount, float MINOR_DAMAGE, float MODERATE_DAMAGE, float MAJOR_DAMAGE) {
        this.paymentID = generatePaymentID(); // use generatePaymentID() method
        this.date = date;
        this.amount = amount;
        this.MINOR_DAMAGE = MINOR_DAMAGE;
        this.MODERATE_DAMAGE = MODERATE_DAMAGE;
        this.MAJOR_DAMAGE = MAJOR_DAMAGE;
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

    public float getAmount() {
        return amount;
    } 

    public float getMinorDamage(){
        return MINOR_DAMAGE;
    }

    public float getModerateDamage(){
        return MODERATE_DAMAGE;
    }
    
    public float getMajorDamage(){
        return MAJOR_DAMAGE;
    }
    // ============== setters ================
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public static void setPaymentCounter(int paymentCounter){
        Payment.paymentCounter = paymentCounter;
    }

    public void setMinorDamage(float MINOR_DAMAGE){
        this.MINOR_DAMAGE = MINOR_DAMAGE;
    }

    public void setModerateDamage(float MODERATE_DAMAGE){
        this.MODERATE_DAMAGE = MODERATE_DAMAGE;
    }

    public void setMajorDamage(float MAJOR_DAMAGE){
        this.MAJOR_DAMAGE = MAJOR_DAMAGE;
    }

    // ============== other methods ==============
    public String toString() {
        return "Payment ID: " + paymentID +
               "\nDate: " + date +
               "\nAmount: " + amount;
    }

public void calculateDamage(int damageOption) { //reference for actual damage calculation
    switch (damageOption) {
        case 1: // No damage
            break;

        case 2: // Minor
            this.amount += MINOR_DAMAGE;
            break;

        case 3: // Moderate
            this.amount += MODERATE_DAMAGE;
            break;

        case 4: // High
            this.amount += MAJOR_DAMAGE;
            break;

        default:
            System.out.println("Invalid damage option!");
        }
    }

}//end of Payment Class