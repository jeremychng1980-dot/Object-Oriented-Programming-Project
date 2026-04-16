package models;

import utils.Helper;

public class CarRentalSystem {
    private String approval;
    private int rentDays;
    private String condition;
    private Car[] cars;
    private Customer[] customers = new Customer[100];
    private Payment[] payments = new Payment[100];
    private int carCount;

    public CarRentalSystem(){
        this(null, null, null);
     }// end of constructor

    public CarRentalSystem(Car[] cars) {
        this.cars = cars;
    }

    public CarRentalSystem(Customer[] customers, Car[] cars) {
        this.customers = customers;
        this.cars = cars;
        approval = " ";
        rentDays = 0;
        condition = "none";
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

    public String getApproval() {
        return approval;
    }

    public int getRentDays() {
        return rentDays;
    }

    public String getCondition() {
        return condition;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void setApproval(String newApproval) {
        this.approval = newApproval;
    }

    public void setRentDays(int newRentDays) {
        this.rentDays = newRentDays;
    }
    public void seCondition(String newCondition) {
        this.condition = newCondition;
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

    public void changeStatus(Car targetCar) { 
 
        String status = targetCar.getStatus();

        if (status.equalsIgnoreCase("available")) {// car available -> book reservation
                targetCar.setStatus("unavailable"); 
                System.out.println("Successful , You have booked the " + targetCar.getCarID() + " Vehicle.");
                Helper.delay(5);
                utils.FileUploader.saveCarsToFile("cars.txt", cars);
            } 
        else { // car unavailable -> cannot book reservation
                System.out.println("Current car status is " + targetCar.getStatus() + ", so unable to rent.");
            }

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
    

    public void reservation(String approval, Customer customers, Car[] car, Payment payments) {
        //Not sure what does this want

        setApproval(approval);
        setRentDays(rentDays);
    }

    public void processPayment(Customer customers, Car[] cars, Payment payments) {
        
    }

    public void inspection(Staff staff, Car car) {
        String damages = "abc"; //PLACEHOLDER VALUE

        if (damages.equalsIgnoreCase("none")) {
            

        } else if (damages.equalsIgnoreCase("minor")) {


        } else if (damages.equalsIgnoreCase("moderate")) {
           
            
        } else if (damages.equalsIgnoreCase("heavy")) {


        } else {
            System.out.println("Invalid damage type");
        }
    
        return;
    }

}// End of CarRentalSystem
