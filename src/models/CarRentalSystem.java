package models;

public class CarRentalSystem {
    private String approval;
    private int rentDays;
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

    public void setCar(Car[] cars) {
        this.cars = cars;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public static void rentCar(Customer customer, Car car) {

    }

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

    public static void processReturn(Customer customer, Car[] cars, Payment payment) {

    }

    public static void processPayment(Customer customer, Car[] cars, Payment payment) {

    }

    public static void inspection(Staff staff, Car[] cars) {

    }

}// End of CarRentalSystem
