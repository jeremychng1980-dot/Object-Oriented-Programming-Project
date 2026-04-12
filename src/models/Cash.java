package models;



public class Cash implements PaymentMethod{
//data properties
    private float amountReceived;

//methods
    // no-args constructor
    public Cash() {
        this(0.0f);
    }
    
    // constructor with args
    public Cash(float amountReceived){
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



    //other methods
    public String toString() {
        return super.toString() +
            "\nAmount Received: " + amountReceived;
    }
    

}//End of Cash Class
