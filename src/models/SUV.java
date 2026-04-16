package models;

public class SUV extends Car{
	private final boolean fourWheelDrive;
	private final int groundClearance;  // using mm to measure

	public SUV(){
		this("","","", 0.0, 0, 0, "",0.0, false, 0);
	}

    public SUV(String plateNumber, String model, String brand, double dailyRate, int seatingCapacity, 
    	int mileage, String status, double fuelLevel, boolean fourWheelDrive, int groundClearance) {
    	super(plateNumber, model, brand, dailyRate, seatingCapacity, mileage, status, fuelLevel);
    	this.fourWheelDrive = fourWheelDrive;
    	this.groundClearance = groundClearance;
    }
    
    public boolean isFourWheelDrive(){
    	return fourWheelDrive;
    }
    
    public int getGroundClearance(){
    	return groundClearance;
    }
    
	public double calcRentalFee(int day){
        double rentalFee = day * super.getDailyRate();
		return rentalFee;
    }

    public String toString(){
    	String has4WD = this.fourWheelDrive ? "Yes" : "No";
    	return super.toString() + 
    	String.format("\n4WheelDrive: %s | Ground Clearance: %d mm", has4WD, this.groundClearance);
    }
    
	public boolean equals(Object o){
  		if(o instanceof SUV){
  			return super.equals(o);
  		}
  		else{
  			return false;
  		}
  	}
    
} // end of SUV class


