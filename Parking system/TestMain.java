//------------Vehicles testing------------
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

//------------Parking slot testing------------
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

//------------Ticket testing------------
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

//------------Parking lot Testing------------
// public static void main(String[] args) {
//         ParkingLot lot = new ParkingLot(2);

//         System.out.println(lot.park(new Car("GJ01PC4751")));
//         System.out.println(lot.park(new Bike("GJ02PC4752")));
//         System.out.println(lot.park(new Car("gj01pc4751")));
//         System.out.println(lot.park(new Truck("GJ05CP5147")));
//         System.out.println(lot.park(null));
//         lot.showStatus();

//         System.out.println(lot.remove("gj01pc4751"));
//         System.out.println(lot.remove("GJ99XX0000"));
//         lot.showStatus();

//         System.out.println(lot.park(new Truck("GJ05CP5147")));
//         lot.showStatus();
// }

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


public class TestMain {
    public static void main(String[] args) {

        //------------BilledHours (entry time = 0)------------
        System.out.println(ParkingLot.billedHours(0, 600000L));
        System.out.println(ParkingLot.billedHours(0, 3600000L));
        System.out.println(ParkingLot.billedHours(0, 3660000L));
        System.out.println(ParkingLot.billedHours(0, 9300000L));
        System.out.println(ParkingLot.billedHours(0, 0L));

        //------------CalculateFee------------
        ParkingLot lot = new ParkingLot(3);
        lot.park(new Car("GJ01PC4751"));
        lot.park(new Bike("GJ02PC4752"));
        lot.park(new Truck("GJ05CP5147"));

        long now = System.currentTimeMillis();
        long later = now + 2 * 3600000L + 35 * 60000L;

        System.out.println(lot.calculateFee("GJ01PC4751", later));
        System.out.println(lot.calculateFee("GJ02PC4752", later));
        System.out.println(lot.calculateFee("GJ05CP5147", later));
        System.out.println(lot.calculateFee("  gj01pc4751 ", later));
        System.out.println(lot.calculateFee("GJ99XX0000", later));
        System.out.println(lot.calculateFee(null, later));
        System.out.println(lot.calculateFee("GJ01PC4751", now));

        //------------Remove with fee------------
        System.out.println(lot.remove("gj01pc4751"));
        System.out.println(lot.calculateFee("GJ01PC4751", later));
        System.out.println(lot.remove("GJ01PC4751"));
        lot.showStatus();
    }
}
//Outout :
// 1
// 1
// 2
// 3
// 1
// Parked: Ticket [GJ01PC4751] slot 1
// Parked: Ticket [GJ02PC4752] slot 2
// Parked: Ticket [GJ05CP5147] slot 3
// 60.0
// 30.0
// 150.0
// 60.0
// -1.0
// -1.0
// 20.0
// Removed: GJ01PC4751
// true
// -1.0
// Ticket not found: GJ01PC4751
// false
// Slot 1 [MEDIUM] - Free
// Slot 2 [MEDIUM] - Bike [GJ02PC4752]
// Slot 3 [MEDIUM] - Truck [GJ05CP5147]