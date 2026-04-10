package models;
import java.util.Scanner;
import utils.Helper;

public class CarRentalSystem {
    Scanner scan = new Scanner(System.in);

    CarRentalSystem[] system = new CarRentalSystem[100];
    Car[] car = new Car[100];

    public void RentCar() {
        boolean isRunning = true;

        System.out.println("Entering Rent Car Page...");
        Helper.delay(3);
        while (isRunning) {
            int option = Helper.getValidatedInt(scan, "Enter the no. of car you want to borrow : ", 1, car.length);

        }

        
    }

    public void Reservation(String carID) {

    }

    public void ReturnCar() {

    }

    public void Checkout() {

    }

    public void Inspection() {

    }
}
