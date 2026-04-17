package models;

public abstract class Car{
    private String carID;          // auto generate no need user input
    private static int carCount = 1;    // use to generate the carID
    private String plateNumber;
    private String model;
    private String brand;
    private double dailyRate;
    private int seatingCapacity;
    private int mileage;
    private String status;
    private double fuelLevel;
    private int reservationCount = 0;
    private String condition;

    // constructor

    public Car(){
        this("", "","",0.0, 0, 0, "", 0.0, "no damage");
    };

    public Car(String plateNumber, String model, String brand, double dailyRate, 
               int seatingCapacity, int mileage, String status, double fuelLevel, String condition) {
        carID = String.format("CA%04d", carCount + 1);
        this.plateNumber = plateNumber;
        this.model = model;
        this.brand = brand;
        this.dailyRate = dailyRate;
        this.seatingCapacity = seatingCapacity;
        this.mileage = mileage;
        this.status = status;
        this.fuelLevel = fuelLevel;
        this.condition = condition;
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

    public int getReservationCount() {
        return reservationCount;
    }

    public String getCondition() {
        return condition;
    }
    // setter
    public void setCarID(String carID){
        this.carID = carID;
    }

    public void setDailyRate(double dailyRate){
        this.dailyRate = dailyRate;
    }

    public void setMileage(int mileage){
        this.mileage = mileage;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public static void setCarCount(int carCount){
        Car.carCount = carCount;
    }

    public void setReservationCount(int reservationCount) {
        this.reservationCount = reservationCount;   
    }
    
    public void setCondition(String condition) {
        this.condition = condition;
    }

// other methods
	public abstract double calcRentalFee(int day);

	public String toString(){
		return String.format("%s |  %s | %s %s |  %.2f |  %d |  %d  | %s |  %.1f%% | %s", 
                carID, plateNumber, brand, model, dailyRate, seatingCapacity, mileage, status, fuelLevel, condition);
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