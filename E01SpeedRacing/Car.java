package E01SpeedRacing;

public class Car {
    private static final double DEFAULT_TRAVELLED_DISTANCE = 0d;

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double travelledDistance;

    public Car(String model,
               double fuelAmount,
               double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.travelledDistance = DEFAULT_TRAVELLED_DISTANCE;
    }

    public void drive(double distance){
        double fuelNeeded = distance * this.fuelCost;
        if(this.fuelAmount - fuelNeeded < 0){
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
        this.fuelAmount -= fuelNeeded;
        this.travelledDistance += distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model
                , this.fuelAmount
                , this.travelledDistance);
    }
}
