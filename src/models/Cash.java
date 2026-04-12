package models;


public class Cash implements PaymentMethod{
//data properties
    private double amountReceived;

//methods
    // no-args constructor
    public Cash() {
        this(0.0f);
    }
    
    // constructor with args
    public Cash(double amountReceived){
        this.amountReceived = amountReceived;
        
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
        return "\nAmount Received: " + amountReceived;
    }
    

}//End of Cash Class
