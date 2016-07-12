package Polymorphism.Pr02VehiclesExtension.models;

public class Car extends Vehicle {
    private final static double ADDED_CONSUMPTION = 0.9;

    public Car(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption + ADDED_CONSUMPTION);
    }

}
