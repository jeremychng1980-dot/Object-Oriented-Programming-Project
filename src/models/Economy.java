package models;

public class Economy extends Car{
    private boolean isHatchback;
    private double fuelEfficiencyPer100KM;
    
    public Economy(){
        this("", "","",0.0, 0, 0, "", 0.0, false, 0.0, "no damage");
    }

    public Economy(String plateNumber, String model, String brand, double dailyRate,int seatingCapacity, 
                int mileage, String status, double fuelLevel, boolean isHatchback, double fuelEfficiencyPer100KM, String condition) {
        super(plateNumber, model, brand, dailyRate, seatingCapacity, mileage, status, fuelLevel, condition);
        this.isHatchback = isHatchback;
        this.fuelEfficiencyPer100KM = fuelEfficiencyPer100KM;
    }
    // getter 
    public boolean isHatchback(){
    	return isHatchback;
    }
    
    public double getFuelEfficiencyPer100KM(){
    	return fuelEfficiencyPer100KM;
    }
    
    // other methods

    public double calcRentalFee(int day){
        double rentalFee = day * super.getDailyRate();
		return rentalFee;
    }
    
    public String toString(){
    	return super.toString() + String.format("\nHatchback: %s | Fuel Efficiency: %.2f L/100km", 
                ( isHatchback ? "Yes" : "No"), fuelEfficiencyPer100KM);
    }
    
    public boolean equals(Object o){
  		if(o instanceof Economy){
  			return super.equals(o);
  		}
  		else{
  			return false;
  		}
  	}
    
} // end of Economy class
