package models;
import java.util.Date;
public class Card extends Payment {
//data properties
    private String cardNo;
    private String CCV;
    private String nameOnCard;
    private String expiryMonth;  
    private String expiryYear;    

//methods
    // no-args constructor
    public Card() {
        this(null, 0.0, 0.0, "", "", "", 0, false, "", "", "", "", "");
    }
    
    // constructor with args
    public Card(Date date, double amount, double deposit, String damageCondition, 
        String customerID, String carID, int rentDuration,boolean status, String cardNo, String CCV, 
        String nameOnCard, String expiryMonth, String expiryYear) {
        super(date, amount, deposit, damageCondition, customerID, carID, rentDuration, status);
        this.cardNo = cardNo;
        this.CCV = CCV;
        this.nameOnCard = nameOnCard;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public Card(String customerID, String carID, String cardNo, String CCV, String nameOnCard, String expiryMonth, String expiryYear) { //TODO
        super(customerID, carID);
        this.cardNo = ""; // can be set later when payment is processed
        this.CCV = ""; // can be set later when payment is processed
        this.nameOnCard = ""; // can be set later when payment is processed
        this.expiryMonth = ""; // can be set later when payment is processed
        this.expiryYear = ""; // can be set later when payment is processed
    }

    // getters
    public String getCardNo() {
        return cardNo;
    }

    public String getCCV() {
        return CCV;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    // setters
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setCCV(String CCV) {
        this.CCV = CCV;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    //other methods

    public String toString() {
        return "Payment Method: Card" +
            "\nCard No.: **** **** **** " + getLast4Digits() +
            "\nCCV: ***" +
            "\nName on Card: " + maskName(nameOnCard) +
            "\nExpiry: " + expiryMonth + "/" + expiryYear;
    }

    public String getPaymentDetails() {
        return "Payment Method: Card" +
            "\nCard No.: **** **** **** " + getLast4Digits() +
            "\nCCV: ***" +
            "\nName on Card: " + maskName(nameOnCard) +
            "\nExpiry: " + expiryMonth + "/" + expiryYear;
    }

    //only display last 4 digits of card
    private String getLast4Digits() { 
    if (cardNo == null || cardNo.length() < 4) {
        return "XXXX";
    }
    return cardNo.substring(cardNo.length() - 4);
    }

//mask name except first letter for privacy
    private String maskName(String name) { 
    if (name.length() <= 2) {
        return name.charAt(0) + "*";
    }
    return name.charAt(0) + "***";
}

}//End of Card Class
