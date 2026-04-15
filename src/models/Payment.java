package models;

import java.util.Date;

public class Payment {

    // ================= Data Properties =================
    private Date date;
    private double amount;//amount to be paid
    private static int paymentCounter;

    // Payment
    private String paymentID;
    private PaymentMethod paymentMethod;
    private double damageCharge;

    // Deposit
    private String depositID;
    private static int depositCounter;

    // Damage Constants
    private double MINOR_DAMAGE;
    private double MODERATE_DAMAGE;
    private double MAJOR_DAMAGE;

    // ================= Constructors =================
    public Payment() {
        this(new Date(), 0.0, null);
    }

    public Payment(Date date, double amount, PaymentMethod paymentMethod) {
        this.paymentID = generatePaymentID();
        this.date = date;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    // ================= ID Generation =================
    private static String generatePaymentID() {
        paymentCounter++;
        return String.format("P%04d", paymentCounter);
    }

    private static String generateDepositID() {
        depositCounter++;
        return String.format("D%04d", depositCounter);
    }

    // ================= Getters =================
    public String getPaymentID() {
        return paymentID;
    }

    public String getDepositID() {
        return depositID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    } 

    public static int getPaymentCounter(){
        return paymentCounter;
    }

    public static int getPaymentCounter() {
        return paymentCounter;
    }

    public static int getDepositCounter() {
        return depositCounter;
    }

    public double getDamageCharge() {
        return damageCharge;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getMinorDamage() {
        return MINOR_DAMAGE;
    }

    public double getModerateDamage() {
        return MODERATE_DAMAGE;
    }

    public double getMajorDamage() {
        return MAJOR_DAMAGE;
    }

    // ================= Setters =================
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDamageCharge(double damageCharge) {
        this.damageCharge = damageCharge;
    }

    public static void setPaymentCounter(int paymentCounter) {
        Payment.paymentCounter = paymentCounter;
    }

    public static void setDepositCounter(int depositCounter) {
        Payment.depositCounter = depositCounter;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setMINOR_DAMAGE(double MINOR_DAMAGE) {
        this.MINOR_DAMAGE = MINOR_DAMAGE;
    }

    public void setMODERATE_DAMAGE(double MODERATE_DAMAGE) {
        this.MODERATE_DAMAGE = MODERATE_DAMAGE;
    }

    public void setMAJOR_DAMAGE(double MAJOR_DAMAGE) {
        this.MAJOR_DAMAGE = MAJOR_DAMAGE;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    // ================= Other Methods =================

    public String paymentToString() {
        return "Payment ID: " + paymentID +
               "\nDate: " + date +
               "\nAmount: " + amount +
               "\nPayment Method: " + paymentMethod;
    }

    public String depositToString() {
        return "Deposit ID: " + depositID +
               "\nDate: " + date +
               "\nAmount: " + amount +
               "\nPayment Method: " + paymentMethod;
    }

    public void calculateTobePaid(String damageOption) {
        switch (damageOption.toLowerCase()) {

            case "none":
                break;

            case "minor":
                damageCharge += MINOR_DAMAGE;
                break;

            case "moderate":
                damageCharge += MODERATE_DAMAGE;
                break;

            case "heavy":
                damageCharge += MAJOR_DAMAGE;
                break;

            default:
                System.out.println("Invalid damage option!");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Payment other = (Payment) obj;
        return this.paymentID.equals(other.paymentID);
    }
}