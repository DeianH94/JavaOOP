package Polymorphism.Pr02VehiclesExtension.models;

public class Truck extends Vehicle {
    private final static double ADDED_CONSUMPTION = 1.6;

    public Truck(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption + ADDED_CONSUMPTION);
    }

    @Override
    public void refuel(double amount){
        double currentFuel = super.getFuelQuantity();
        super.setFuelQuantity(currentFuel + amount * 0.95);
    }
}
