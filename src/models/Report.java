package models;

public class Report {
    // Attributes
    private int reserveCount;
    private String carID;
    private String carName;
    private double revenueGenerated;
    
    // No-arg constructor
    public Report() {
        this(0, "", "", 0.0);
    }
    
    // Parameterized constructor
    public Report(int reserveCount, String carID, String carName, double revenueGenerated) {
        this.reserveCount = reserveCount;
        this.carID = carID;
        this.carName = carName;
        this.revenueGenerated = revenueGenerated;
    }
    
    // Getters
    public int getReserveCount() {
        return reserveCount;
    }
    
    public String getCarID() {
        return carID;
    }
    
    public String getCarName() {
        return carName;
    }
    
    public double getRevenueGenerated() {
        return revenueGenerated;
    }
    
    // Setters
    public void setReserveCount(int reserveCount) {
        this.reserveCount = reserveCount;
    }
    
    public void setCarID(String carID) {
        this.carID = carID;
    }
    
    public void setCarName(String carName) {
        this.carName = carName;
    }
    
    public void setRevenueGenerated(double revenueGenerated) {
        this.revenueGenerated = revenueGenerated;
    }
    
    // toString method
    public String toString() {
    return String.format("%-15d %-15s %-23s RM %-15.2f", 
                reserveCount, carID, carName, revenueGenerated);
}
    
    // equals method - compares by Car ID
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        Report other = (Report) obj;
        return this.carID.equals(other.carID);
    }
}