package models;

public class CarRentalSystem {
    private String approval;
    private int rentDays;
    private String condition;
    private Car[] cars = new Car[100];
    private Customer[] customers = new Customer[100];
    private Payment[] payments = new Payment[100];

    public CarRentalSystem(){
        this(null, null, null);
     }// end of constructor

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

    public void setCar(Car[] cars) {
        this.cars = cars;
    }

    public void setCustomer(Customer[] newCustomer) {
        this.customers = newCustomer;
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
    
    public void changeStatus(Customer customers, Car car, Payment payments) { //Merged from processReturn and rentCar
        String status = car.getStatus();
        if (status.equalsIgnoreCase("not available")) {
            car.setStatus("available");
        } else if (status.equalsIgnoreCase("available")) { //Checkout
            car.setStatus("unavailable");
        }

        setApproval(approval);
        setRentDays(rentDays);

        return;
    }

    public void reservation(String approval, Customer customers, Car[] car, Payment payments) {
        //Not sure what does this want
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
