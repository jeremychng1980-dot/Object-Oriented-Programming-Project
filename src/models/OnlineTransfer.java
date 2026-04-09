package models;

import java.util.Date; 

public class OnlineTransfer extends Payment{
//data properties
    private String accountNumber;  
    private String accountName;    
    private String bankName;     
    private String swiftCode;      
    private String reference;      


    //methods 
    //no args con
    public OnlineTransfer() {
     this(new Date(),0.0f, "", "", "", "", "");
}

    public OnlineTransfer(Date date, float amount, String accountNumber, String accountName, String bankName
                            , String swiftCode, String reference){
        super(date, amount);
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.bankName = bankName;
        this.swiftCode = swiftCode;
        this.reference = reference;
    }

    //getter
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
    public String getBankName(){
        return bankName;
    }
    public String getSwiftCode(){
        return swiftCode;
    }
    public String getReference(){
        return reference;
    }

    //setter
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setAccountName(String accountName){
        this.accountName = accountName;
    }
    public void setBankName(String bankName){
        this.bankName = bankName;
    }
    public void setSwiftCode(String swiftCode){
        this.swiftCode = swiftCode;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    

    //other methods
    public String toString(){
        return super.toString() + 
        "\nAccount Number: " + accountNumber + 
        "\nAccount Name: " + accountName + 
        "\nBank Name: " + bankName + 
        "\nSwift Code: " + swiftCode + 
        "\nReference: " + reference;
    }

}//End of OnlineTransfer Class



