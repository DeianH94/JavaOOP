package Polymorphism.Pr01Vehicles.models;

public class Car extends Vehicle{
    private final static double ADDED_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION);
    }
}
