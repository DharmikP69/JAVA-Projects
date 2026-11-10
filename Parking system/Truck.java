/**
 * A truck. Parking costs 50 per hour.
 */
public class Truck extends Vehicle{
    
    Truck(String plateNumber){
        super(plateNumber);
   }

   @Override 
   double hourlyRate(){
        return 50;
   }

   public String toString(){
        return "Truck [" + getPlateNumber() + "]";
    }
}
