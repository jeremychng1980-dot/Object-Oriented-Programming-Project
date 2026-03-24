import Util.p;


public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to AMCS2204!");
        p.println("Hello World");
        
        Car c1 = new Car("PQR2123", "Vios", "Toyota", 40.0, 4, 25009, "Available", 280);

        p.println("Test print car id: " + c1.getCarID());
        

    }
} 