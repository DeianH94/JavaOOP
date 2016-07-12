package Polymorphism.Pr03WildFarm;

import Polymorphism.Pr03WildFarm.factories.AnimalFactory;
import Polymorphism.Pr03WildFarm.factories.FoodFactory;
import Polymorphism.Pr03WildFarm.models.animals.Animal;
import Polymorphism.Pr03WildFarm.models.food.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();
        FoodFactory foodFactory = new FoodFactory();
        AnimalFactory animalFactory = new AnimalFactory();
        String animalParams = reader.readLine();
        while (!animalParams.toLowerCase().equals("end")) {
            try {
                Animal animal = animalFactory.getAnimal(animalParams);
                animal.makeSound();
                animals.add(animal);
                String foodParams = reader.readLine();
                Food food = foodFactory.getFood(foodParams);
                animal.eat(food);
                System.out.println(animal);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animalParams = reader.readLine();
        }

        //animals.stream().forEach(System.out::println);
    }
}
