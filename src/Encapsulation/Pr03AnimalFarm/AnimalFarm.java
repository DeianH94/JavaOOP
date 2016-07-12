package Encapsulation.Pr03AnimalFarm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnimalFarm {
    public static void main(String[] args) {
        List<Field> fields = Arrays.asList(Chicken.class.getDeclaredFields());
        List<Method> methods = Arrays.asList(Chicken.class.getDeclaredMethods());
        assert fields.stream().filter(field -> Modifier.isPrivate(field.getModifiers())).count() == 4;
        assert methods.stream().filter(method -> Modifier.isPrivate(method.getModifiers())).count() == 1;

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.valueOf(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);

            System.out.printf("Chicken %s (age %d) can produce %.0f eggs per day.",
                    chicken.getName(),
                    chicken.getAge(),
                    chicken.getProductPerDay());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}

class Chicken {
    final int MIN_AGE = 0;
    public int MAX_AGE = 15;

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public double getProductPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        switch (this.age) {
            case 0:
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
            case 7:
                return 3;
            case 8:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                return 1;
        }
    }
}
