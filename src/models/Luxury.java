package models;

public class Luxury extends Car{
	private boolean hasLeatherSeats;
	private boolean hasSunroof;
	
	public Luxury(){
		this("", "", "",0.0, 0, 0, "", 0.0 ,false, false);
	}
	
	public Luxury(String plateNumber, String model, String brand, double dailyRate, int seatingCapacity, 
		int mileage, String status, double fuelLevel, boolean hasLeatherSeats, boolean hasSunroof){
			super(plateNumber, model, brand, dailyRate, seatingCapacity, mileage, status, fuelLevel);
			this.hasLeatherSeats = hasLeatherSeats;
			this.hasSunroof = hasSunroof;
	}
	
    public boolean isHasLeatherSeats(){
        return hasLeatherSeats;
    }
	
    public boolean isHasSunroof(){
        return hasSunroof;
    }

	public double calcRentalFee(int day){
        double rentalFee = day * super.getDailyRate();
		return rentalFee;
    }

	public String toString(){
		String leatherSeats = this.hasLeatherSeats ? "Yes" : "No";
		String sunroof = this.hasSunroof ? "Yes" : "No";
		return super.toString() + String.format("\nHas Leather Seats: %s | Has Sunroof: %s", leatherSeats, sunroof);
	}

	public boolean equals(Object o){
  		if(o instanceof Luxury){
  			return super.equals(o);
  		}
  		else{
  			return false;
  		}
  	}

} // end of Luxury class

