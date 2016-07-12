package DefiningClasses.Pr06RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            String model = data[0];
            Integer engineSpeed = Integer.parseInt(data[1]);
            Integer enginePower = Integer.parseInt(data[2]);
            Integer cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Double tire1Pressure = Double.parseDouble(data[5]);
            Integer tire1Age = Integer.parseInt(data[6]);
            Double tire2Pressure = Double.parseDouble(data[7]);
            Integer tire2Age = Integer.parseInt(data[8]);
            Double tire3Pressure = Double.parseDouble(data[9]);
            Integer tire3Age = Integer.parseInt(data[10]);
            Double tire4Pressure = Double.parseDouble(data[11]);
            Integer tire4Age = Integer.parseInt(data[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tire1 = new Tires(tire1Pressure, tire1Age);
            Tires tire2 = new Tires(tire2Pressure, tire2Age);
            Tires tire3 = new Tires(tire3Pressure, tire3Age);
            Tires tire4 = new Tires(tire4Pressure, tire4Age);

            cars.add(new Car(model, engine, cargo, tire1, tire2, tire3, tire4));
        }

        String command = reader.readLine();
        if (command.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> car.checkPressure()).forEach(System.out::println);
        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250).forEach(System.out::println);
        }
    }
}

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tire1, Tires tire2, Tires tire3, Tires tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new Tires[4];
        this.tires[0] = tire1;
        this.tires[1] = tire2;
        this.tires[2] = tire3;
        this.tires[3] = tire4;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public boolean checkPressure() {
        for (Tires tire : this.tires) {
            if (tire.getTirePressure() < 1) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}

class Engine {
    private Integer engineSpeed;
    private Integer enginePower;

    public Engine(Integer engineSpeed, Integer enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public Integer getEnginePower() {
        return this.enginePower;
    }
}

class Cargo {
    private Integer cargoWeight;
    private String cargoType;

    public Cargo(Integer cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}

class Tires {
    private Double tirePressure;
    private Integer tireAge;

    public Tires(Double tirePressure, Integer tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public Double getTirePressure() {
        return this.tirePressure;
    }
}