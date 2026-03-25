package utils;

public class Helper {
    public static void printSeperator() {
        System.out.println("=====================");
    }

    public static void printMessage(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void printError(String errorMessage) {
        System.out.println("[Error] " + errorMessage);
    }
}