package Inheritance.Pr04MordorsCrueltyPlan;

import Inheritance.Pr04MordorsCrueltyPlan.factories.FoodFactory;
import Inheritance.Pr04MordorsCrueltyPlan.factories.MoodFactory;
import Inheritance.Pr04MordorsCrueltyPlan.models.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Food> foods = new ArrayList<>();
        String[] foodParams = reader.readLine().split("\\s+");

        for(String food : foodParams){
            foods.add(FoodFactory.produceFood(food));
        }

        System.out.println(MoodFactory.produceMood(foods));
    }
}
