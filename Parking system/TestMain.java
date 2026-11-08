public class TestMain {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new Car("GJ01PC4751"),
            new Car("GJ01PC4752"),
            new Bike("GJ02PC4752"),
            new Bike("GJ02PC4751"),
            new Truck("GJ05CP5147"),
            new Truck("GJ05pc4751"),
            new Car("  gj01pc4751  ")
        };

        for (Vehicle v : vehicles) {
            System.out.println(v + " rate " + v.hourlyRate());
        }

    }
}
//Output : 
// Car [GJ01PC4751] rate 20.0
// Car [GJ01PC4752] rate 20.0
// Bike [GJ02PC4752] rate 10.0
// Bike [GJ02PC4751] rate 10.0
// Truck [GJ05CP5147] rate 50.0
// Truck [GJ05PC4751] rate 50.0
