package Polymorphism.Pr01Vehicles;

import Polymorphism.Pr01Vehicles.models.Car;
import Polymorphism.Pr01Vehicles.models.Truck;
import Polymorphism.Pr01Vehicles.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        Double carFuelQuantity = Double.parseDouble(carInfo[1]);
        Double carFuelConsumption = Double.parseDouble(carInfo[2]);
        Vehicle car = new Car(carFuelQuantity, carFuelConsumption);

        String[] truckInfo = reader.readLine().split("\\s+");
        Double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        Double truckFuelConsumption = Double.parseDouble(truckInfo[2]);
        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int n = Integer.parseInt(reader.readLine());
        DecimalFormat format = new DecimalFormat("0.######");

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            Double param = Double.parseDouble(command[2]);
            boolean tryToDrive;
            switch (parseCommand(command)) {
                case 1:
                    tryToDrive = car.drive(param);
                    if (tryToDrive) {
                        System.out.println(command[1] + " travelled " + format.format(param) + " km");
                    } else {
                        System.out.printf("%s needs refueling\n", command[1]);
                    }

                    break;
                case 2:
                    tryToDrive = truck.drive(param);
                    if (tryToDrive) {
                        System.out.println(command[1] + " travelled " + format.format(param) + " km");
                    } else {
                        System.out.printf("%s needs refueling\n", command[1]);
                    }

                    break;
                case 3:
                    car.refuel(param);
                    break;
                case 4:
                    truck.refuel(param);
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }

    private static int parseCommand(String[] command) {
        if (command[0].equals("Drive")) {
            if (command[1].equals("Car")) {
                return 1;
            } else if (command[1].equals("Truck")) {
                return 2;
            }
        } else if (command[0].equals("Refuel")) {
            if (command[1].equals("Car")) {
                return 3;
            } else if (command[1].equals("Truck")) {
                return 4;
            }
        }

        return 5;
    }
}
