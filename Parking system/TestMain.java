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

    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(1, "MEDIUM");
        Vehicle car = new Car("GJ01PC4751");
        Vehicle bike = new Bike("GJ02PC4752");

        System.out.println(slot); // Slot 1 [MEDIUM] - Free
        System.out.println(slot.assign(car)); // true
        System.out.println(slot); // Slot 1 [MEDIUM] - Car [GJ01PC4751]
        System.out.println(slot.assign(bike)); // false
        System.out.println(slot); // still the car
        slot.free();
        System.out.println(slot); // Slot 1 [MEDIUM] - Free
        System.out.println(slot.assign(bike)); // true
        System.out.println(slot); // Slot 1 [MEDIUM] - Bike [GJ02PC4752]
    }
}
//Output : 
// Slot 1 [MEDIUM] - Free
// true
// Slot 1 [MEDIUM] - Car [GJ01PC4751]
// false
// Slot 1 [MEDIUM] - Car [GJ01PC4751]
// Slot 1 [MEDIUM] - Free
// true
// Slot 1 [MEDIUM] - Bike [GJ02PC4752]