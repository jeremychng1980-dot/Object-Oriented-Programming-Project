package models;

public class Car{
    private String carID ;          // auto generate no need use input
    private static int carCount = 1;    // use to generate the carID
    private String plateNumber;
    private String model;
    private String brand;
    private double dailyRate;
    private int seatingCapacity;
    private int mileage;
    private String status;
    private double fuelLevel;


    // constructor

    public Car(){
        this("", "","",0.0, 0, 0, "", 0.0);
    };

    public Car(String plateNumber, String model, String brand, double dailyRate, 
               int seatingCapacity, int mileage, String status, double fuelLevel){
        carID = String.format("CA%04d", carCount);
        this.plateNumber = plateNumber;
        this.model = model;
        this.brand = brand;
        this.dailyRate = dailyRate;
        this.seatingCapacity = seatingCapacity;
        this.mileage = mileage;
        this.status = status;
        this.fuelLevel = fuelLevel;
        carCount++;
    }

    // getter
    public String getCarID(){
        return carID;
    }
    
    public String getPlateNumber(){
        return plateNumber;
    }
    
    public String getModel(){
        return model;
    }

    public String getBrand(){
        return brand;
    }

    public double getDailyRate(){
        return dailyRate;
    }

    public int getSeatingCapacity(){
        return seatingCapacity;
    }

    public int getMileage(){
        return mileage;
    }

    public String getStatus(){
        return status;
    }

    public double getFuelLevel(){
        return fuelLevel;
    }

    public static int getCarCount(){
        return Car.carCount;
    }
    // setter
    public void setDailyRate(double dailyRate){
        this.dailyRate = dailyRate;
    }

    public void setMileage(int mileage){
        this.mileage = mileage;
    }

    public void setStatus(String status){
        this.status = status;
    }


// other methods
	public double calcRentalFee(int day){
		double rentalFee = day * dailyRate;
		return rentalFee;
	}

	public String toString(){
		return String.format("CarID:%s | Plate: %s | %s %s | Rate: RM%.2f/day | Seats: %d | Mileage: %d km | Status: %s | Fuel: %.1f%%", 
                carID, plateNumber, brand, model, dailyRate, seatingCapacity, mileage, status, fuelLevel);
	}
    
    public boolean equals(Object o){ 
		Car c = (Car)o;
	if(c instanceof Car){ // prevent tuntime error : ClassCastException
		return this.carID.equals(c.carID);  // true or false
	    }
	else{
		return false;}
    }

} // end of car class