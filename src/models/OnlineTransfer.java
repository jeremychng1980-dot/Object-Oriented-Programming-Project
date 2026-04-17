package models;

public class OnlineTransfer extends Payment implements PaymentMethod {

    // ================= Data Properties =================
    private String accountNumber;
    private String accountName;
    private String bankName;
    private String swiftCode;
    private String reference;

    // ================= Constructors =================

    // No-args constructor
    public OnlineTransfer() {
        this("", "", "", "", "");
    }

    public OnlineTransfer(String accountNumber, String accountName, String bankName,
                          String swiftCode, String reference) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.bankName = bankName;
        this.swiftCode = swiftCode;
        this.reference = reference;
    }

    // ================= Getters =================

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public String getReference() {
        return reference;
    }

    // ================= Setters =================

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    // ================= Other Methods =================

    public String toString() {
        return "Account Number: " + maskAccountNumber(accountNumber) +
               "\nAccount Name: " + maskName(accountName) +
               "\nBank Name: " + bankName +
               "\nReference: " + reference;
    }

    public String getPaymentDetails() {
        return "Account Number: " + maskAccountNumber(accountNumber) +
               "\nAccount Name: " + maskName(accountName) +
               "\nBank Name: " + bankName +
               "\nReference: " + reference;
    }

    // ================= Helper Methods =================

    private String maskAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.length() <= 4) {
            return "****";
        }
        return "****" + accountNumber.substring(accountNumber.length() - 4);
    }

    private String maskName(String name) {
        if (name == null || name.length() <= 2) {
            return (name != null && name.length() > 0) ? name.charAt(0) + "*" : "*";
        }
        return name.charAt(0) + "***";
    }
}