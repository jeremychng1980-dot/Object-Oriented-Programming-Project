package models;

public class CarRentalSystem {
    private String approval;
    private int rentDays;
    private String condition;
    private Car[] cars = {
        new Economy(),
        new SUV(),
        new Luxury()
    };
    private Customer customer = new Customer();
    private Payment payment = new Payment();

    public CarRentalSystem(){
        this(null, null, null);
     }// end of constructor

    public CarRentalSystem(Customer customer, Car[] cars) {
        this.customer = customer;
        this.cars = cars;
        approval = " ";
        rentDays = 0;
        condition = "none";
    }

    public CarRentalSystem(Customer customer, Payment payment) {
        this.customer = customer;
        this.payment = payment;
    }

    public CarRentalSystem(Customer customer, Car[] cars, Payment payment) {
        this.customer = customer;
        this.cars = cars;
        this.payment = payment;
    }
    
    public Car[] getCars() {
        return cars;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
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

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
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
    
    public void changeStatus(Customer customer, Car car, Payment payment) { //Merged from processReturn and rentCar
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

    public void reservation(String approval, Customer customer, Car[] car, Payment payment) {
        //Not sure what does this want
    }

    public void processPayment(Customer customer, Car[] cars, Payment payment) {

    }

    public void inspection(Staff staff, Car car) {
        Strrng

        if (damages.equalsIgnoreCase("none")) {

        } else if (damages.equalsIgnoreCase("minor")) {

        } else if (damages.equalsIgnoreCase("moderate")) {
            
        } else if (damages.equalsIgnoreCase("heavy")) {

        } else {
            System.out.println("Invalid damage type");
        }
*/
        return;
    }

}// End of CarRentalSystem
