/**
 * Abstract parent of all vehicles. Each child defines its own hourly rate.
 */
public abstract class Vehicle {
    public final String plateNumber;

    Vehicle(String plateNumber){
        this.plateNumber = plateNumber.trim().toUpperCase();
    }

    String getPlateNumber(){
        return plateNumber;
    }

    /**
     * @return the price for one hour of parking for this vehicle type
     */
    abstract double hourlyRate();
}
