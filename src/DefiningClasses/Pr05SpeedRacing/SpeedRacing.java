package DefiningClasses.Pr05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = reader.readLine().split("\\s+");
            String model = carInfo[0];
            Double fuelAmount = Double.parseDouble(carInfo[1]);
            Double fuelCost = Double.parseDouble(carInfo[2]);
            cars.add(new Car(model, fuelAmount, fuelCost));
        }

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] carInfo = input.split("\\s+");
            String model = carInfo[1];
            Integer distanceTraveled = Integer.parseInt(carInfo[2]);

            for (Car car : cars) {
                if (car.getModel().equals(model)) {
                    car.distanceToCheck(distanceTraveled);
                }
            }

            input = reader.readLine();
        }

        cars.stream().forEach(System.out::println);
    }
}

class Car {
    private String model;
    private Double fuelAmount;
    private Double fuelCost;
    private Integer distanceTraveled;

    public Car(String model, Double fuelAmount, Double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void distanceToCheck (Integer distanceToTravel) {
        if (this.fuelAmount < distanceToTravel * this.fuelCost) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.distanceTraveled += distanceToTravel;
            this.fuelAmount -= (distanceToTravel * this.fuelCost);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
