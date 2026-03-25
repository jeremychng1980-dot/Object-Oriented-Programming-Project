package utils;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);
    public static int getIntInput(String prompt, int lowerLimit, int upperLimit) {
        int input;

        while (true) {
            System.out.print(prompt);
                while (!scanner.hasNextInt()) {
                    Helper.printError("Please enter a valid number...");
                    scanner.nextLine();
                    return -1;
                }

            input = scanner.nextInt();

            if (input >= lowerLimit && input <= upperLimit) {
                return input;
            }

            Helper.printError("Please enter a number between " + lowerLimit + " and " + upperLimit + "...");  
            scanner.nextLine();
            return -1; 
        }
        
    }
}

