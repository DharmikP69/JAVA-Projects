public class ParkingSlot {
    private final int slotNumber; // final: set once in the constructor
    private final String size; // final: set once in the constructor
    private Vehicle occupiedVehicle; // NOT final: changes in assign() and free()

    ParkingSlot(int slotNumber, String size) {
        this.slotNumber = slotNumber;
        this.size = size;
    }

    boolean isFree() {
        return occupiedVehicle == null;
    }

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
