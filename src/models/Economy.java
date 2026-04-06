package models;

public class Economy extends Car{
    private boolean isHatchback;
    
    public Economy(){
        this("", "","",0.0, 0, 0, "", 0.0, true);
    }

    public Economy(String plateNumber, String model, String brand, double dailyRate,int seatingCapacity, 
                int mileage, String status, double fuelLevel, boolean isHatchback){
        super(plateNumber, model, brand, dailyRate, seatingCapacity, mileage, status, fuelLevel);
        this.isHatchback = isHatchback;
    }
}
