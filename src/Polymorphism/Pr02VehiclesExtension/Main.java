package Polymorphism.Pr02VehiclesExtension;

import Polymorphism.Pr02VehiclesExtension.models.Bus;
import Polymorphism.Pr02VehiclesExtension.models.Car;
import Polymorphism.Pr02VehiclesExtension.models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    static Car car;
    static Truck truck;
    static Bus bus;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] info = reader.readLine().split("\\s+");

            String vehicle = info [0];
            double fuelQuantity = Double.parseDouble(info[1]);
            double fuelConsumption = Double.parseDouble(info[2]);
            double tankCapacity = Double.parseDouble(info[3]);

            switch(vehicle){
                case "Car":
                    car = new Car(tankCapacity, fuelQuantity, fuelConsumption);
                    break;
                case "Truck":
                    truck = new Truck(tankCapacity, fuelQuantity, fuelConsumption);
                    break;
                case "Bus":
                    bus = new Bus(tankCapacity, fuelQuantity, fuelConsumption);
                    break;
            }
        }


        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");

            String vehicle = info[1];
            double amount = Double.parseDouble(info[2]);
            NumberFormat format = DecimalFormat.getInstance();
            format.setMinimumFractionDigits(0);

            switch (info[0]){
                case "DriveEmpty":
                    boolean driven = bus.driveWithoutPeople(amount);
                    String message = driven ?
                            vehicle + " travelled " + format.format(amount) + " km" :
                            vehicle + " needs refueling";
                    System.out.println(message);
                    break;
                case "Drive":
                    driven = tryDriveVehicle(vehicle, amount);
                    message = driven ?
                            vehicle + " travelled " + format.format(amount) + " km" :
                            vehicle + " needs refueling";
                    System.out.println(message);
                    break;
                case "Refuel":
                    tryRefuelVehicle(vehicle, amount);
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }

    private static void tryRefuelVehicle(String vehicle, double amount) {
        switch(vehicle){
            case "Car":
                car.refuel(amount);
                break;
            case "Truck":
                truck.refuel(amount);
                break;
            case "Bus":
                bus.refuel(amount);
                break;
        }
    }

    private static boolean tryDriveVehicle(String vehicle, double amount) {
        switch(vehicle){
            case "Car":
                return car.drive(amount);
            case "Truck":
                return truck.drive(amount);
            case "Bus":
                return bus.drive(amount);
            default:
                return false;
        }
    }
}