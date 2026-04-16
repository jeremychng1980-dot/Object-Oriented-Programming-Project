package models;

public class CarRentalSystem {
    private String reservationID;
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
    
    public String getReservationID() {
        return reservationID;
    }

    public Car[] getCars() {
        return cars;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCar(Car[] cars) {
        this.cars = cars;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public static void rentCar(Customer customer, Car[] cars) {

    }

    public static void checkout(Customer customer, Car[] cars, Payment payment) {
    }

    public static void processReturn(Customer customer, Car[] cars, Payment payment) {

    }

    public static void processPayment(Customer customer, Car[] cars, Payment payment) {

    }

    public static void inspection(Staff staff, Car[] cars) {

    }

}// End of CarRentalSystem
