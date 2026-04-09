package models;

import java.util.Date;

public class Cash extends Payment{
//data properties
    private float amountReceived;

//methods
    // no-args constructor
    public Cash() {
        this(new Date(),0.0f, 0.0f);
    }
    
    // constructor with args
    public Cash(Date date, float amount, float amountReceived){
        super(date, amount);
        this.amountReceived = amountReceived;
        
    }

    // getters
    public float getAmountReceived() {
        return amountReceived;
    }


    // setters
    public void setAmountReceived(float amountReceived) {
        this.amountReceived = amountReceived;
    }

    public boolean isPaymentSufficient() {//check if payment received is more than amount to be paid 
        return amountReceived >= getAmount();
    }

    public float calculateChange() {
        if (!isPaymentSufficient()) {
            return 0;
        }
        return amountReceived - getAmount();
    }

    //other methods
    public String toString() {
        return super.toString() +
            "\nAmount Received: " + amountReceived +
            "\nPayment Status: " + (isPaymentSufficient() ? "Sufficient" : "Insufficient") +
            "\nChange: " + (isPaymentSufficient() ? calculateChange() : "N/A");
    }


}//End of Cash Class
