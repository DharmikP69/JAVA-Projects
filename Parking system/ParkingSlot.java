/**
 * One parking space. Holds at most one vehicle at a time.
 */
public class ParkingSlot {
    private final int slotNumber;
    private final String size;
    private Vehicle occupiedVehicle;

    ParkingSlot(int slotNumber, String size) {
        this.slotNumber = slotNumber;
        this.size = size;
    }

    int getSlotNumber() {
        return slotNumber;
    }

    String getSize() {
        return size;
    }

    Vehicle getOccupiedVehicle() {
        return occupiedVehicle;
    }

    boolean isFree() {
        return occupiedVehicle == null;
    }

    /**
     * Parks the vehicle in this slot if it is free.
     *
     * @param v the vehicle to park
     * @return true if parked; false if v is null or the slot is taken
     */
    boolean assign(Vehicle v) {
        if (v == null || !isFree()) {
            return false;
        }
        occupiedVehicle = v;
        return true;
    }

    void free() {
        occupiedVehicle = null;
    }

    @Override
    public String toString() {
        if (isFree()) {
            return "Slot " + slotNumber + " [" + size + "] - Free";
        }
        return "Slot " + slotNumber + " [" + size + "] - " + occupiedVehicle;
    }
}