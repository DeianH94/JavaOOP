package Inheritance.Pr06Animals;

import Inheritance.Pr06Animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

            while (!command.toLowerCase().equals("beast!")) {
                try {
                    Animal animal = null;
                    String[] params = reader.readLine().split("\\s+");
                    String name = params[0];
                    int age = Integer.parseInt(params[1]);
                    String gender = null;
                    switch (command) {
                        case "Cat":
                            gender = params[2];
                            animal = new Cat(name, age, gender);
                            break;
                        case "Kitten":
                            animal = new Kitten(name, age);
                            break;
                        case "Tomcat":
                            animal = new Tomcat(name, age);
                            break;
                        case "Dog":
                            gender = params[2];
                            animal = new Dog(name, age, gender);
                            break;
                        case "Frog":
                            gender = params[2];
                            animal = new Frog(name, age, gender);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid input!");
                    }

                    if (animal != null) {
                        System.out.println(animal);
                        System.out.println(animal.produceSound());
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

                command = reader.readLine();
            }

    }
}
