package models;
import java.util.Date;


public class Cash extends Payment{
//data properties
    private double amountReceived;

//methods
    // no-args constructor
    public Cash() {
        this("", null, 0.0, 0.0, "", "", "", 0, false, 0.0);
    }
    
    // constructor with args
    public Cash(String paymentID, Date date, double amount, double deposit, String damageCondition, 
        String customerID, String carID, int rentDuration, boolean status, double amountReceived){
        super(paymentID, date, amount, deposit, damageCondition, customerID, carID, rentDuration, status);
        this.amountReceived = amountReceived;
    }

    public Cash(String customerID, String carID, int amount) { //TODO
        super(customerID, carID);
        this.amountReceived = amount; // can be set later when payment is processed
    }

    // getters
    public double getAmountReceived() {
        return amountReceived;
    }


    // setters
    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }



    //other methods
    public String toString() {
        return "\nAmount Received: RM " + String.format("%.2f", amountReceived);
    }
    
    public String getPaymentDetails() {
        return "\nAmount Received: RM " + String.format("%.2f", amountReceived);
    }
    
}//End of Cash Class
