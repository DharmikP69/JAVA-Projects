import java.util.ArrayList;
import java.util.HashMap;

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

    

    private ParkingSlot findFreeSlot() {
        for (ParkingSlot s : slots) {
            if (s.isFree()) {
                return s;
            }
        }
        return null;
    }

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