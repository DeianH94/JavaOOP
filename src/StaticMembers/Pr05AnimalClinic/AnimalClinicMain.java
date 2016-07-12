package StaticMembers.Pr05AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnimalClinicMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] petInfo = reader.readLine().split("\\s+");
        while (!petInfo[0].toLowerCase().equals("end")){
            String name = petInfo[0];
            String breed = petInfo[1];
            String command = petInfo[2];
            Animal animal = new Animal(name, breed);

            if (command.equals("heal")) {
                AnimalClinic.healAnimal(animal);
            } else if (command.equals("rehabilitate")) {
                AnimalClinic.rehabilitateAnimal(animal);
            }

            petInfo = reader.readLine().split("\\s+");
        }

        System.out.printf("Total healed animals: %d\n", AnimalClinic.getHealedAnimalsCount());
        System.out.printf("Total rehabilitated animals: %d\n", AnimalClinic.getRehabilitedAnimalsCount());

        String command = reader.readLine();
        if (command.equals("heal")) {
            for (Animal animal : AnimalClinic.getHealedAnimals()) {
                System.out.printf("%s %s\n", animal.getName(), animal.getBreed());
            }
        } else if (command.equals("rehabilitate")) {
            for (Animal animal : AnimalClinic.getRehabilitedAnimals()) {
                System.out.printf("%s %s\n", animal.getName(), animal.getBreed());
            }
        }
    }
}

class Animal {
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return String.format("[%s (%s)]", this.name, this.breed);
    }
}

class AnimalClinic {
    private static Integer patientId;
    private static Integer healedAnimalsCount;
    private static Integer rehabilitedAnimalsCount;
    private static List<Animal> healedAnimals;
    private static List<Animal> rehabilitedAnimals;

    static {
        patientId = 0;
        healedAnimalsCount = 0;
        rehabilitedAnimalsCount = 0;
        healedAnimals = new ArrayList<>();
        rehabilitedAnimals = new ArrayList<>();
    }

    public static Integer getHealedAnimalsCount() {
        return healedAnimalsCount;
    }

    public static Integer getRehabilitedAnimalsCount() {
        return rehabilitedAnimalsCount;
    }

    public static List<Animal> getHealedAnimals() {
        return healedAnimals;
    }

    public static List<Animal> getRehabilitedAnimals() {
        return rehabilitedAnimals;
    }

    public static void healAnimal(Animal animal) {
        patientId++;
        healedAnimalsCount++;
        healedAnimals.add(animal);
        System.out.printf("Patient %d: %s has been healed!\n", patientId, animal);
    }

    public static void rehabilitateAnimal(Animal animal) {
        patientId++;
        rehabilitedAnimalsCount++;
        rehabilitedAnimals.add(animal);
        System.out.printf("Patient %d: %s has been rehabilitated!\n", patientId, animal);
    }
}