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
        this(new Date(),0.0f, "", "", "", "","");
    }
    
    // constructor with args
    public Card(Date date, float amount, String cardNo, String CCV, String nameOnCard, String expiryMonth, String expiryYear) {
        super(date, amount);
        this.cardNo = cardNo;
        this.CCV = CCV;
        this.nameOnCard = nameOnCard;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
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
    public String toString(){
        return super.toString() +
        "\nCard No.: **** **** ****" + cardNo.substring(cardNo.length() - 4) + //only display the last 4 digits of Card no. for identification
        "\nCCV: ***" + //CCV is outputted as asterisk to protect privacy
        "\nName on Card: " + nameOnCard +
        "\nExpiry: " + expiryMonth + "/" + expiryYear;
    }


}//End of Card Class
