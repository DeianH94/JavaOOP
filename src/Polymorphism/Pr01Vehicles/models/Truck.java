package Polymorphism.Pr01Vehicles.models;

public class Truck extends Vehicle{
    private final static double ADDED_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION);
    }

    @Override
    public void refuel(double amount){
        super.refuel(amount*0.95);
    }
}
