package DefiningClasses.Pr07CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] engineData = reader.readLine().split("\\s+");
            String model = engineData[0];
            Integer power = Integer.parseInt(engineData[1]);
            if (engineData.length == 4) {
                Integer displacement = Integer.parseInt(engineData[2]);
                String efficiency = engineData[3];
                engines.add(new Engine(model, power, displacement, efficiency));
            } else if (engineData.length == 2) {
                engines.add(new Engine(model, power));
            } else if (isNumber(engineData[2])) {
                Integer displacement = Integer.parseInt(engineData[2]);
                engines.add(new Engine(model, power, displacement));
            } else {
                String efficiency = engineData[2];
                engines.add(new Engine(model, power, efficiency));
            }
        }
        
        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] carData = reader.readLine().split("\\s+");
            String model = carData[0];
            String enginetoFind = carData[1];
            Engine engineToAdd = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(enginetoFind)) {
                    engineToAdd = engine;
                }
            }

            if (carData.length == 4) {
                Integer weight = Integer.parseInt(carData[2]);
                String color = carData[3];
                cars.add(new Car(model, engineToAdd, weight, color));
            } else if (carData.length == 2) {
                cars.add(new Car(model, engineToAdd));
            } else if (isNumber(carData[2])) {
                Integer weight = Integer.parseInt(carData[2]);
                cars.add(new Car(model, weight, engineToAdd));
            } else {
                String color = carData[2];
                cars.add(new Car(model, color, engineToAdd));
            }
        }

        cars.stream().forEach(System.out::println);
    }

    private static boolean isNumber(String param) {
        try {
            Integer.parseInt(param);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model, Engine engine, Integer weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Integer weight, Engine engine) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, String color, Engine engine) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    @Override
    public String toString() {
        return String.format("%s:\n %s Weight: %s\n Color: %s",
                this.model,
                this.engine.toString(),
                this.weight == -1 ? "n/a" : this.weight,
                this.color);
    }
}

class Engine {
    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power, Integer displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, Integer power, Integer displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, Integer power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, Integer power) {
        this(model, power, -1, "n/a");
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return String.format("%s:\n  Power: %d\n  Displacement: %s\n  Efficiency: %s\n",
                this.model,
                this.power,
                (this.displacement == -1) ? "n/a" : this.displacement.toString(),
                this.efficiency);
    }
}
