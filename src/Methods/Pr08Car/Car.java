package Methods.Pr08Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Car {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        double speed = Double.parseDouble(input[0]);
        double fuel = Double.parseDouble(input[1]);
        double fuelEconomy = Double.parseDouble(input[2]);
        CarClass car = new CarClass(speed, fuel, fuelEconomy);

        String[] command = reader.readLine().trim().split("\\s+");
        while (!command[0].toLowerCase().equals("end")) {
            switch (command[0]) {
                case "Travel":
                    double distance = Double.parseDouble(command[1]);
                    car.travel(distance);
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(command[1]);
                    car.refuel(liters);
                    break;
                case "Distance":
                    System.out.printf("Total distance: %s kilometers\n", car.getTotalDistance());
                    break;
                case "Time":
                    double totalTime = car.getTime();
                    int hours = (int)totalTime / 60;
                    int minutes = (int)totalTime % 60;
                    System.out.printf("Total time: %s hours and %s minutes\n", hours, minutes);
                    break;
                case "Fuel":
                    System.out.printf("Fuel left: %s liters\n", car.getFuel());
            }

           command = reader.readLine().trim().split("\\s+");
        }
    }
}

class CarClass {
    private Double speed;
    private Double fuel;
    private Double fuelEconomy;
    private Double totalDistance;
    private Double time;

    public CarClass(Double speed, Double fuel, Double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.totalDistance = 0d;
        this.time = 0d;
    }

    public Double getFuel() {
        return this.fuel;
    }

    public Double getTotalDistance() {
        return this.totalDistance;
    }

    public Double getTime() {
        return this.time;
    }

    public void travel (Double distance) {
        double canTravel = (this.fuel *100) / this.fuelEconomy;
        if (canTravel < distance) {
            distance = canTravel;
        }

        this.fuel -= distance * (this.fuelEconomy / 100);
        this.totalDistance += distance;
        this.time += distance / this.speed * 60;
    }

    public void refuel (Double liters) {
        this.fuel += liters;
    }
}