/**
 * Record of one parking visit: plate, slot number and entry time.
 * Fields are final because a ticket never changes once issued.
 */
public class Ticket {
    private final String plateNumber;
    private final int slotNumber;
    private final long entryTime;

    Ticket(String plateNumber, int slotNumber) {
        this.plateNumber = plateNumber;
        this.slotNumber = slotNumber;
        this.entryTime = System.currentTimeMillis();
    }

    Ticket(String plateNumber, int slotNumber, long entryTime){
        this.plateNumber = plateNumber;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
    }

    String getPlateNumber(){
        return plateNumber;
    }

    int getSlotNumber(){
        return slotNumber;
    }

    long getEntryTime(){
        return entryTime;
    }

    @Override
    public String toString(){
        return "Ticket [" + getPlateNumber() + "] slot " + getSlotNumber();
    }
}
