/**
 * A car. Parking costs 20 per hour.
 */
public class Car extends Vehicle {
    
   Car(String plateNumber){
        super(plateNumber);
   }

   @Override 
   double hourlyRate(){
        return 20;
   }

   public String toString(){
        return "Car [" + getPlateNumber() + "]";
    }
}
