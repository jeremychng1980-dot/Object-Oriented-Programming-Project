package models;

import java.util.Date;

public class Payment {
    // data properties
    private String paymentID;
    private Date date;
    private float amount;
    private static int paymentCounter;

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

    // ============== setters ================
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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
            this.amount += 1000;
            break;

        case 3: // Moderate
            this.amount += 1500;
            break;

        case 4: // High
            this.amount += 2000;
            break;

        default:
            System.out.println("Invalid damage option!");
        }
    }

}//end of Payment Class