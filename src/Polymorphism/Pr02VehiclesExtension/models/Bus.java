package Polymorphism.Pr02VehiclesExtension.models;

public class Bus extends Vehicle{
    private final static double ADDED_CONSUMPTION = 1.4;

    public Bus(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption + 1.4);
    }

    public boolean driveWithoutPeople(double amount){
        double fuelQuantity = super.getFuelQuantity();
        double fuelConsumption = super.getFuelConsumption() - ADDED_CONSUMPTION;

        if(amount * fuelConsumption <= fuelQuantity){
            super.setFuelQuantity(fuelQuantity - (amount * fuelConsumption));
            return true;
        }

        return false;
    }
}
