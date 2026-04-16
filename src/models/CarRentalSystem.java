package models;

public class CarRentalSystem {
    private String approval;
    private int rentDays;
    private Car car = new Car();
    private Customer customer = new Customer();
    private Payment payment = new Payment();

    public CarRentalSystem(){
        this(null, null, null);
     }// end of constructor

    public CarRentalSystem(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
        approval = " ";
        rentDays = 0;
    }

    public CarRentalSystem(Customer customer, Payment payment) {
        this.customer = customer;
        this.payment = payment;
    }

    public CarRentalSystem(Customer customer, Car car, Payment payment) {
        this.customer = customer;
        this.car = car;
        this.payment = payment;
    }
    
    public Car getCar() {
        return car;
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

    public void setCar(Car newCar) {
        this.car = newCar;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public void setPayment(Payment newPayment) {
        this.payment  = newPayment;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }

    public void rentCar(String approval, int rentDays, Customer customer, Car car) {
        String status = car.getStatus();

        if (status.equalsIgnoreCase("available")) {
            setApproval(approval);
            setRentDays(rentDays);
            car.setStatus("unavailable");
        } else if (status.equalsIgnoreCase("unavailable")) {
            System.out.println("Car is currently unavailable, please contact us for more inquiries!");
        }

        return;
    }

    public void checkout(Customer customer, Car car, Payment payment) {
        
    }

    public void processReturn(Customer customer, Car car, Payment payment) {

    }

    public void processPayment(Customer customer, Car car, Payment payment) {

    }

    public void inspection(Staff staff, Car car) {

    }
}// End of CarRentalSystem
