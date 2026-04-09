package models;
import models.User;
import models.Admin;
import java.util.Scanner;

import utils.Helper;



public class CarRentalSystem {
    private Car[] cars;
    private Customer[] cust;
    private Payment[] payment;

    private int carCount;
    private int custCount;
    private int paymentCount;

    public CarRentalSystem() {
        cars = new Car[100];
        cust = new Customer[100];
        payment = new Payment[100];

        carCount = 0;
        custCount = 0;
        paymentCount = 0;
    }

    public CarRentalSystem(int maxCars, int maxCustomers, int maxPayments) {
        cars = new Car[maxCars];
        cust = new Customer[maxCustomers];
        payment = new Payment[maxPayments];

        carCount = 0;
        custCount = 0;
        paymentCount = 0;
    }




}
