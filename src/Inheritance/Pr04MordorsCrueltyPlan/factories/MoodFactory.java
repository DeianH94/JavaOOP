package Inheritance.Pr04MordorsCrueltyPlan.factories;

import Inheritance.Pr04MordorsCrueltyPlan.models.Food;

import java.util.List;

public class MoodFactory {
    public static String produceMood(List<Food> foods){
        int amountOfHappiness = 0;

        for (Food food : foods) {
            amountOfHappiness += food.getAmount();
        }

        if(amountOfHappiness < -5){
            return amountOfHappiness + "\n" + "Angry";
        } else if (amountOfHappiness < 0){
            return amountOfHappiness + "\n" + "Sad";
        } else if (amountOfHappiness < 15){
            return amountOfHappiness + "\n" + "Happy";
        } else{
            return amountOfHappiness + "\n" + "JavaScript";
        }
    }
}
