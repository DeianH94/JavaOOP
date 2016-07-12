package Methods.Pr12PrintPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Person> people = new ArrayList<>();

        String[] info = reader.readLine().split("\\s+");
        while (!info[0].toLowerCase().equals("end")) {
            String name = info[0];
            Integer age = Integer.parseInt(info[1]);
            String occupation = info[2];
            people.add(new Person(name, age, occupation));
            info = reader.readLine().split("\\s+");
        }

        people.stream().sorted(Person::compareTo).forEach(System.out::println);
    }
}

class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private String occupation;

    public Person(String name, Integer age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.age, person.age);
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);
    }
}