package cli;

import models.Car;
import models.Customer;
import models.User;
import utils.Helper;
import java.util.Scanner;

public class Menu {
    
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        displayMainMenu();
        boolean pageRunning = true;
        int choice = 0;
        while (pageRunning) {
            choice = Helper.getValidatedInt(input, "Choose an option [1/2/3]): ", 1, 3);
            switch (choice) {
                case -1:
                    break;
                case 1:
                    //Code here
                    System.out.println("Page 1");
                    pageRunning = false;
                    break;
                case 2:
                    //Code here
                    System.out.println("Page 2");
                    pageRunning = false;
                    break;
                case 3:
                     System.out.print("Exiting system...");
                    return;
            }
        }
    }

    public void displayMainMenu() {
        Helper.printSeperator();
        System.out.println("CAR MANAGEMENT SYSTEM");
        Helper.printSeperator();
        System.out.println("[1] Add Car");
        System.out.println("[2] Display All Cars");
        System.out.println("[3] Exit System");
        Helper.printSeperator();
    }

    




}