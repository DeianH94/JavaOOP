package Polymorphism.Pr03WildFarm.models.animals;

import Polymorphism.Pr03WildFarm.models.food.Food;
import Polymorphism.Pr03WildFarm.models.food.Vegetable;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
            System.out.println("A cheese was just eaten!");
        } else {
            System.out.println("Mouses are not eating that type of food!");
        }
    }
}
