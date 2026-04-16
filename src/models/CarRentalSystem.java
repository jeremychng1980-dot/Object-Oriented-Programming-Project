package models;

public class CarRentalSystem {
    private Car car = new Car();
    private Customer customer = new Customer();
    private Payment payment = new Payment();

    public CarRentalSystem(){
        this(null, null, null);
     }// end of constructor

    public CarRentalSystem(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
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

    public void setCar(Car newCar) {
        this.car = newCar;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }


}// End of CarRentalSystem
