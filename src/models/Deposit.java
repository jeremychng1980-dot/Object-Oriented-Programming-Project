package models;

import java.util.Date;

public class Deposit {
    // data properties
    private String depositID;
    private double amount;
    private Date date;
    private PaymentMethod paymentMethod;
    private static int depositCounter;

    // no-args constructor
    public Deposit() {
        this(0.0, new Date(), null);
    }

    // constructor with args
    public Deposit(double amount, Date date, PaymentMethod paymentMethod) {
        this.depositID = generateDepositID();
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    //method to generate DepositID
    private static String generateDepositID() {
    depositCounter++;
    return String.format("D%04d", depositCounter);
}

    // ========== Getters ==========
    public String getDepositID() {
        return depositID;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public static int getDepositCounter() {
        return depositCounter;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    
    // ========== Setters ==========
    public void setDepositID(String depositID) {
        this.depositID = depositID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void setDepositCounter(int depositCounter) {
        Deposit.depositCounter = depositCounter;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // ========== Other Methods ==========
    public String toString() {
        return "Deposit ID: " + depositID +
               "\nAmount: " + amount +
               "\nDate: " + date +
               "\nPayment Method: " + paymentMethod;
    }
}