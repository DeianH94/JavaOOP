package Encapsulation.Pr05PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PizzaCalories {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] input = reader.readLine().split("\\s+");
            while (!input[0].toLowerCase().equals("end")) {
                String flour;
                String tehnique;
                Integer weight;
                String type;
                Dough dough;
                Topping topping;
                switch (input[0].toLowerCase()) {
                    case "dough":
                        flour = input[1];
                        tehnique = input[2];
                        weight = Integer.parseInt(input[3]);
                        dough = new Dough(flour, tehnique, weight);
                        System.out.printf("%.2f\n", dough.getCalories());
                        break;
                    case "topping":
                        type = input[1];
                        weight = Integer.parseInt(input[2]);
                        topping = new Topping(type, weight);
                        System.out.printf("%.2f\n", topping.getCalories());
                        break;
                    case "pizza":
                        String name = input[1];
                        Integer toppingsCount = Integer.parseInt(input[2]);
                        Pizza pizza = new Pizza(name, toppingsCount);
                        String[] line = reader.readLine().split("\\s+");
                        flour = line[1];
                        tehnique = line[2];
                        weight = Integer.parseInt(line[3]);
                        dough = new Dough(flour, tehnique, weight);
                        pizza.setDough(dough);

                        for (int i = 0; i < toppingsCount; i++) {
                            line = reader.readLine().split("\\s+");
                            type = line[1];
                            weight = Integer.parseInt(line[2]);
                            topping = new Topping(type, weight);
                            pizza.addTopping(topping);
                        }
                        System.out.println(pizza);
                        break;
                }

                input = reader.readLine().split("\\s+");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Pizza {
    private String name;
    private Dough dough;
    private int toppingCount;
    private List<Topping> toppings;

    public Pizza(String name, Integer toppingCount) {
        this.setName(name);
        this.setToppingCount(toppingCount);
        this.toppings = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0 || name.trim().length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppingCount(int toppingCount) {
        if (toppingCount > 10 || toppingCount < 0) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppingCount = toppingCount;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }
    
    public Double getTotalCalories() {
        Double total = this.dough.getCalories();
        for (Topping topping : toppings) {
            total += topping.getCalories();
        }

        return total;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f Calories.", this.name, this.getTotalCalories());
    }
}

class Dough {
    private String flourType;
    private String bakingTechnique;
    private Integer weight;

    public Dough(String flourType, String bakingTechnique, int weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.toLowerCase().equals("white")
                && !flourType.toLowerCase().equals("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.toLowerCase().equals("crispy")
                && !bakingTechnique.toLowerCase().equals("chewy")
                && !bakingTechnique.toLowerCase().equals("homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(Integer weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public Double getCalories() {
        return 2 * this.weight
                * this.getModifier(this.flourType)
                * this.getModifier(this.bakingTechnique);
    }

    private Double getModifier(String type) {
        switch (type.toLowerCase()) {
            case "white":
                return 1.5;
            case "wholegrain":
                return 1.0;
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            case "homemade":
                return 1.0;
            default:
                return 1d;
        }
    }
}

class Topping {
    private String type;
    private Integer weight;

    public Topping(String type, Integer weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    public void setType(String type) {
        if (!type.toLowerCase().equals("meat")
                && !type.toLowerCase().equals("veggies")
                && !type.toLowerCase().equals("cheese")
                && !type.toLowerCase().equals("sauce")) {
            throw  new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }

        this.type = type;
    }

    public void setWeight(Integer weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.type + " weight should be in the range [1..50].");
        }

        this.weight = weight;
    }

    public Double getCalories() {
        return 2 * this.weight * this.getModifier(this.type);
    }

    private Double getModifier(String type) {
        switch (type.toLowerCase()) {
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            case "sauce":
                return 0.9;
            default:
                return 1d;
        }
    }
}