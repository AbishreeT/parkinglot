package parking.system;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;

    public ParkingLot(int totalSpots) {
        parkingSpots = new ArrayList<>();
        for (int i = 1; i <= totalSpots; i++) {
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    public void parkCar(int spotNumber, String vehicleNumber) {
        ParkingSpot spot = findSpotByNumber(spotNumber);
        if (spot == null) {
            System.out.println("Invalid Spot Number!");
            return;
        }
        if (spot.isOccupied()) {
            System.out.println("Spot " + spotNumber + " is already occupied.");
            return;
        }
        spot.occupy(vehicleNumber);
        System.out.println("Car " + vehicleNumber + " parked at spot " + spotNumber);
    }

    public void vacateSpot(int spotNumber) {
        ParkingSpot spot = findSpotByNumber(spotNumber);
        if (spot == null) {
            System.out.println("Invalid Spot Number!");
            return;
        }
        if (!spot.isOccupied()) {
            System.out.println("Spot " + spotNumber + " is already empty.");
            return;
        }
        spot.vacate();
        System.out.println("Spot " + spotNumber + " is now vacated.");
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    private ParkingSpot findSpotByNumber(int spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                return spot;
            }
        }
        return null;
    }
}
