package Polymorphism.Pr03WildFarm.factories;

import Polymorphism.Pr03WildFarm.models.food.Food;
import Polymorphism.Pr03WildFarm.models.food.Meat;
import Polymorphism.Pr03WildFarm.models.food.Vegetable;

public class FoodFactory {
    public Food getFood(String foodParams) {
        if (foodParams == null) {
            throw new IllegalArgumentException("No food!");
        }

        String[] food = foodParams.split("\\s+");
        String foodType = food[0];
        int quantity = Integer.parseInt(food[1]);

        switch (foodType.toLowerCase()) {
            case "meat":
                return new Meat(quantity);
            case "vegetable":
                return new Vegetable(quantity);
            default:
                throw new IllegalArgumentException("Invalid food");
        }
    }
}
