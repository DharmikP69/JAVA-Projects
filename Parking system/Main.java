import java.util.Scanner;

/**
 * Console menu for the parking system. Reads input, validates it,
 * and calls ParkingLot. It contains no parking logic itself.
 */
public class Main {

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();

            if (!scanner.hasNextLine()) {
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number from 1 to 4");
                continue;
            }

            switch (choice) {
                case 1:
                    parkVehicle(lot, scanner);
                    break;
                case 2:
                    removeVehicle(lot, scanner);
                    break;
                case 3:
                    lot.showStatus();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Choose 1 to 4");
            }
        }

        System.out.println("Goodbye");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Parking System =====");
        System.out.println("1. Park");
        System.out.println("2. Remove");
        System.out.println("3. Show Status");
        System.out.println("4. Exit");
        System.out.print("Choice: ");
    }

    private static void parkVehicle(ParkingLot lot, Scanner scanner) {
        System.out.print("Vehicle type (1 Car, 2 Bike, 3 Truck): ");
        int type;
        try {
            type = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid type");
            return;
        }

        if (type < 1 || type > 3) {
            System.out.println("Invalid type");
            return;
        }

        System.out.print("Plate number: ");
        String plate = scanner.nextLine().trim();
        if (plate.isEmpty()) {
            System.out.println("Plate cannot be empty");
            return;
        }

        Vehicle v;
        if (type == 1) {
            v = new Car(plate);
        } else if (type == 2) {
            v = new Bike(plate);
        } else {
            v = new Truck(plate);
        }

        lot.park(v);
    }

    private static void removeVehicle(ParkingLot lot, Scanner scanner) {
        System.out.print("Plate number: ");
        String plate = scanner.nextLine().trim();
        if (plate.isEmpty()) {
            System.out.println("Plate cannot be empty");
            return;
        }

        lot.remove(plate);
    }
}