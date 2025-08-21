package parking.system;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private String vehicleNumber;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.vehicleNumber = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void occupy(String vehicleNumber) {
        this.isOccupied = true;
        this.vehicleNumber = vehicleNumber;
    }

    public void vacate() {
        this.isOccupied = false;
        this.vehicleNumber = null;
    }

    @Override
    public String toString() {
        return "Spot " + spotNumber + ": " + (isOccupied ? "Occupied by " + vehicleNumber : "Available");
    }
}
