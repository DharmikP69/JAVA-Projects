abstract class Vehicle {
    public final String plateNumber;

    Vehicle(String plateNumber){
        this.plateNumber = plateNumber.trim().toUpperCase();
    }

    String getPlateNumber(){
        return plateNumber;
    }

    abstract double hourlyRate();
}
