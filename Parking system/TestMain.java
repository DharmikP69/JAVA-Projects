public class TestMain {
    // public static void main(String[] args) {
    // This main is particular for the vehicle testing
    // Vehicle[] vehicles = {
    // new Car("GJ01PC4751"),
    // new Car("GJ01PC4752"),
    // new Bike("GJ02PC4752"),
    // new Bike("GJ02PC4751"),
    // new Truck("GJ05CP5147"),
    // new Truck("GJ05pc4751"),
    // new Car(" gj01pc4751 ")
    // };

    // for (Vehicle v : vehicles) {
    // System.out.println(v + " rate " + v.hourlyRate());
    // }

    // }

    // Output :
    // Car [GJ01PC4751] rate 20.0
    // Car [GJ01PC4752] rate 20.0
    // Bike [GJ02PC4752] rate 10.0
    // Bike [GJ02PC4751] rate 10.0
    // Truck [GJ05CP5147] rate 50.0
    // Truck [GJ05PC4751] rate 50.0

    // public static void main(String[] args) {
    // ParkingSlot slot = new ParkingSlot(1, "MEDIUM");
    // Vehicle car = new Car("GJ01PC4751");
    // Vehicle bike = new Bike("GJ02PC4752");

    // System.out.println(slot); // Slot 1 [MEDIUM] - Free
    // System.out.println(slot.assign(car)); // true
    // System.out.println(slot); // Slot 1 [MEDIUM] - Car [GJ01PC4751]
    // System.out.println(slot.assign(bike)); // false
    // System.out.println(slot); // still the car
    // slot.free();
    // System.out.println(slot); // Slot 1 [MEDIUM] - Free
    // System.out.println(slot.assign(bike)); // true
    // System.out.println(slot); // Slot 1 [MEDIUM] - Bike [GJ02PC4752]
    // }
    // Output :
    // Slot 1 [MEDIUM] - Free
    // true
    // Slot 1 [MEDIUM] - Car [GJ01PC4751]
    // false
    // Slot 1 [MEDIUM] - Car [GJ01PC4751]
    // Slot 1 [MEDIUM] - Free
    // true
    // Slot 1 [MEDIUM] - Bike [GJ02PC4752]

    // public static void main(String[] args) {
    //     Ticket t1 = new Ticket("GJ01PC4751", 1);
    //     System.out.println(t1);
    //     System.out.println(t1.getEntryTime() > 0);

    //     Ticket t2 = new Ticket("GJ02PC4752", 2, 1000L);
    //     System.out.println(t2.getEntryTime());
    //     System.out.println(t2);

    //     long threeHoursAgo = System.currentTimeMillis() - (3 * 3600000L);
    //     Ticket t3 = new Ticket("GJ05CP5147", 3, threeHoursAgo);
    //     long diff = System.currentTimeMillis() - t3.getEntryTime();
    //     System.out.println(diff >= 10800000L);

    //     System.out.println(t1.getSlotNumber() + " " + t1.getPlateNumber());
    //}
//Output :
// Ticket [GJ01PC4751] slot1
// true
// 1000
// Ticket [GJ02PC4752] slot2
// true
// 1 GJ01PC4751
public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2);

        System.out.println(lot.park(new Car("GJ01PC4751")));
        System.out.println(lot.park(new Bike("GJ02PC4752")));
        System.out.println(lot.park(new Car("gj01pc4751")));
        System.out.println(lot.park(new Truck("GJ05CP5147")));
        System.out.println(lot.park(null));
        lot.showStatus();

        System.out.println(lot.remove("gj01pc4751"));
        System.out.println(lot.remove("GJ99XX0000"));
        lot.showStatus();

        System.out.println(lot.park(new Truck("GJ05CP5147")));
        lot.showStatus();
    }
}
//Output :
// Parked: Ticket [GJ01PC4751] slot 1
// true
// Parked: Ticket [GJ02PC4752] slot 2
// true
// Already parked: GJ01PC4751
// false
// Lot Full
// false
// No vehicle given
// false
// Slot 1 [MEDIUM] - Car [GJ01PC4751]
// Slot 2 [MEDIUM] - Bike [GJ02PC4752]
// Removed: GJ01PC4751
// true
// Ticket not found: GJ99XX0000
// false
// Slot 1 [MEDIUM] - Free
// Slot 2 [MEDIUM] - Bike [GJ02PC4752]
// Parked: Ticket [GJ05CP5147] slot 1
// true
// Slot 1 [MEDIUM] - Truck [GJ05CP5147]
// Slot 2 [MEDIUM] - Bike [GJ02PC4752]