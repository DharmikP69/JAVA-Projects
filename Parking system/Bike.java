/**
 * A bike. Parking costs 10 per hour.
 */
public class Bike extends Vehicle{

    Bike(String plateNumber){
        super(plateNumber);
    }

    @Override 
    double hourlyRate(){
        return 10;
    }

    public String toString(){
        return "Bike [" + getPlateNumber() + "]";
    }
}
