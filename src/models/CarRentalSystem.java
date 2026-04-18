package models;

import utils.Helper;

public class CarRentalSystem {
    private Car[] cars;
    private Customer[] customers;
    private Payment[] payments;

    public CarRentalSystem(){
        this(null, null, null);
     }// end of constructor

    public CarRentalSystem(Car[] cars) {
        this.cars = cars;
    }

    public CarRentalSystem(Customer[] customers, Car[] cars) {
        this.customers = customers;
        this.cars = cars;
    }

    public CarRentalSystem(Customer[] customers, Payment[] payments) {
        this.customers = customers;
        this.payments = payments;
    }


    public CarRentalSystem(Customer[] customers, Car[] cars, Payment[] payments) {
        this.customers = customers;
        this.cars = cars;
        this.payments = payments;
    }

    public Car[] getCars() {
        return cars;
    }

    public Customer[] getCustomer() {
        return customers;
    }

    public Payment[] getPayment() {
        return payments;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void setPayments(Payment[] payments){
        this.payments = payments;
    }
    
    public Car findCarById(String carID) {
        for (int i = 0; i < Car.getCarCount(); i++) {

            if (cars[i] != null && cars[i].getCarID().equalsIgnoreCase(carID)) {
                return cars[i]; 
            }
        }
        return null; // not found
    }

    public void displayAllCars() {

        System.out.println("\n=====================================");
        System.out.println("           View All Vehicles           ");
        System.out.println("=====================================");
        System.out.println("\n==========================================================================");
        System.out.println("CarID       |Plate      |Brand      |Model      |DailyRate(RM)|Seats      |Mileage KM |Status     |Fuel       |");
        System.out.println("--------------------------------------------------------------------------");

        if (Car.getCarCount() == 0) {
            System.out.println("                     [ Currently no available vehicle record ]                      ");
        } 
        else {
            for (int i = 0; i < Car.getCarCount(); i++) {
                if(cars[i] != null){
                    System.out.println(cars[i].toString());
                }
            } // end of for
        }
        System.out.println("==========================================================================");
        System.out.println("Total car count: " + Car.getCarCount());
    }

    public void displayRentedCars() {
        System.out.println("\n=====================================");
        System.out.println("           View Rented Vehicles           ");
        System.out.println("=====================================");
        System.out.println("\n==========================================================================");
        System.out.println("CarID       |Plate      |Brand      |Model      |DailyRate(RM)|Seats      |Mileage KM |Status     |Fuel       |");
        System.out.println("--------------------------------------------------------------------------");

        boolean hasRentedCars = false;
        for (int i = 0; i < Car.getCarCount(); i++) {
            if (cars[i] != null && cars[i].getStatus().equalsIgnoreCase("unavailable")) {
                System.out.println(cars[i].toString());
                hasRentedCars = true;
            }
        }

        if (!hasRentedCars) {
            System.out.println("                     [ Currently no rented vehicle record ]                      ");
        }
        System.out.println("==========================================================================");
    }

    public void displayAvailableCars() {
        System.out.println("\n=====================================");
        System.out.println("       View Available Vehicles        ");
        System.out.println("=====================================");
        System.out.println("\n==========================================================================");
        System.out.println("CarID       |Plate      |Brand      |Model      |DailyRate(RM)|Seats      |Mileage KM |Status     |Fuel       |");
        System.out.println("--------------------------------------------------------------------------");

        boolean hasAvailableCars = false;
        for (int i = 0; i < Car.getCarCount(); i++) {
            if (cars[i] != null && cars[i].getStatus().equalsIgnoreCase("available")) {
                System.out.println(cars[i].toString());
                hasAvailableCars = true;
            }
        }

        if (!hasAvailableCars) {
            System.out.println("                     [ Currently no available vehicle record ]                      ");
        }
        System.out.println("==========================================================================");
    }


    public void addCarToSystem(String filename, Car newCar) {
        if (Car.getCarCount() < cars.length) {
            cars[Car.getCarCount()] = newCar;

            utils.FileUploader.saveCarsToFile(filename, cars); 
            System.out.println("\nVehicle record has been uploaded to the system.");
        } 
        else {
            System.out.println("\nError, the garage is full, can not add new vehicle.");
            }
    }

    public double calculateRentalFee(Car targetCar, int rentDays) {
        double rentalFee = targetCar.calcRentalFee(rentDays);
        return rentalFee;
    }

    public void reservationRecord(Customer customer, Car car, double rentalFee, int rentDays) {
        Payment newPay = new Payment(customer.getCustomerID(), car.getCarID(),rentalFee, rentDays);

        for (int i = 0; i < payments.length; i++) {
        if (payments[i] == null) {
            payments[i] = newPay;
            break; // once store then break if no will fill up whole array
            }
        } //  end of for
        utils.FileUploader.savePaymentsToFile("payment.txt", payments);
    }

}// End of CarRentalSystem
