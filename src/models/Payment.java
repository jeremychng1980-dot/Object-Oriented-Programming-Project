package models;

import java.util.Date;

public class Payment {
    // data properties
    private String paymentID;
    private Date date;
    private float amount;
    private static int paymentCounter;
    //constant d.p
    private static final float MINOR_DAMAGE = 500;
    private static final float MODERATE_DAMAGE = 1000;
    private static final float MAJOR_DAMAGE = 1500;

    // no-args constructor
    public Payment() {
        this(new Date(),0.0f);
    }
    
    // constructor with args
    public Payment(Date date, float amount) {
        this.paymentID = generatePaymentID(); // use generatePaymentID() method
        this.date = date;
        this.amount = amount;

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

    public static float getMinorDamage(){
        return MINOR_DAMAGE;
    }

    public static float getModerateDamage(){
        return MODERATE_DAMAGE;
    }

    public static float getMajorDamage(){
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

    // ============== other methods ==============
    public String toString() {
        return "Payment ID: " + paymentID +
               "\nDate: " + date +
               "\nAmount: " + amount;
    }//end toString()

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
            }//end Switch
        }//end calculateDamage()

}//end of Payment Class