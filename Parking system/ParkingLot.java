import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages all slots and active tickets: park, remove and show status.
 */
public class ParkingLot {
    private final ArrayList<ParkingSlot> slots;
    private final HashMap<String, Ticket> activeTickets;

    ParkingLot(int totalSlots) {
        slots = new ArrayList<>();
        activeTickets = new HashMap<>();

        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i, "MEDIUM"));
        }
    }

    /**
     * @return the first free slot, or null if the lot is full
     */
    private ParkingSlot findFreeSlot() {
        for (ParkingSlot s : slots) {
            if (s.isFree()) {
                return s;
            }
        }
        return null;
    }

    /**
     * Parks a vehicle in the first free slot and issues a ticket.
     *
     * @param v the vehicle to park
     * @return true if parked; false if v is null, the plate is already
     *         parked, or the lot is full
     */
    boolean park(Vehicle v) {
        if (v == null) {
            System.out.println("No vehicle given");
            return false;
        }

        String plate = v.getPlateNumber();

        if (activeTickets.containsKey(plate)) {
            System.out.println("Already parked: " + plate);
            return false;
        }

        ParkingSlot slot = findFreeSlot();
        if (slot == null) {
            System.out.println("Lot Full");
            return false;
        }

        slot.assign(v);
        Ticket ticket = new Ticket(plate, slot.getSlotNumber());
        activeTickets.put(plate, ticket);
        System.out.println("Parked: " + ticket);
        return true;
    }

    /**
     * Removes a parked vehicle by plate number and frees its slot.
     *
     * @param plateNumber the plate, in any case, with or without spaces
     * @return true if removed; false if no ticket exists for that plate
     */
    boolean remove(String plateNumber) {
        if (plateNumber == null) {
            System.out.println("No plate given");
            return false;
        }

        String plate = plateNumber.trim().toUpperCase();
        Ticket ticket = activeTickets.get(plate);

        if (ticket == null) {
            System.out.println("Ticket not found: " + plate);
            return false;
        }

        // Wednesday: calculate the fee HERE, before freeing the slot
        ParkingSlot slot = slots.get(ticket.getSlotNumber() - 1);
        slot.free();
        activeTickets.remove(plate);
        System.out.println("Removed: " + plate);
        return true;
    }

    void showStatus() {
        for (ParkingSlot s : slots) {
            System.out.println(s);
        }
    }
}