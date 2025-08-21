package parking.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of spots: ");
        int total = readInt(scanner, 5); // default 5 if invalid
        ParkingLot parkingLot = new ParkingLot(total);

        while (true) {
            System.out.println();
            System.out.println("1. Park Car");
            System.out.println("2. Vacate Spot");
            System.out.println("3. View Parking Lot");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = readInt(scanner, -1);

            switch (choice) {
                case 1: {
                    System.out.print("Enter Spot Number: ");
                    int spotNumber = readInt(scanner, -1);
                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber = scanner.next();
                    parkingLot.parkCar(spotNumber, vehicleNumber);
                    break;
                }
                case 2: {
                    System.out.print("Enter Spot Number to Vacate: ");
                    int vacateSpot = readInt(scanner, -1);
                    parkingLot.vacateSpot(vacateSpot);
                    break;
                }
                case 3: {
                    System.out.println("Parking Lot Status:");
                    for (ParkingSpot spot : parkingLot.getParkingSpots()) {
                        System.out.println(spot);
                    }
                    break;
                }
                case 4:
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static int readInt(Scanner sc, int fallback) {
        try {
            return Integer.parseInt(sc.next());
        } catch (Exception e) {
            return fallback;
        }
    }
}
