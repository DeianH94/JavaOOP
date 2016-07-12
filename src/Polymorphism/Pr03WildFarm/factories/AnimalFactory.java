package Polymorphism.Pr03WildFarm.factories;

import Polymorphism.Pr03WildFarm.models.animals.*;

public class AnimalFactory {
    public Animal getAnimal(String animalParams) {
        if (animalParams == null) {
            throw new IllegalArgumentException("No animal!");
        }

        String[] animal = animalParams.split("\\s+");
        String animalType = animal[0];
        String animalName = animal[1];
        double animalWeight = Double.parseDouble(animal[2]);
        String animalLivingRegion = animal[3];
        String animalBreed = null;
        if (animal.length == 5) {
            animalBreed = animal[4];
        }

        switch (animalType.toLowerCase()) {
            case "mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            case "zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "cat":
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalBreed);
            case "tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("Invalid animal");
        }
    }
}
