package cli;

import models.Car;
import utils.Helper;
import utils.InputHelper;
import java.util.Scanner;

public class Menu {
    
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        displayMainMenu();
        boolean pageRunning = true;
        
        while (pageRunning) {
            int choice = InputHelper.getIntInput("Choose an Option[1/2/3]: ", 1, 3);
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
                    Helper.printError("Exiting system...");
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