package DefiningClasses.Pr03OpinionPoll;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(int age) {
        this("No name", age);
    }

    Person() {
        this("No name", 1);
    }
}

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int numOfLines = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfLines; i++) {
            String[] id = scanner.nextLine().split("\\s+");
            people.add(new Person(id[0], Integer.parseInt(id[1])));
        }

        ArrayList<Person> over30 = people.stream()
                .filter(person -> person.age > 30).collect(Collectors.toCollection(ArrayList::new));

        over30.sort((x1, x2) -> x1.name.compareTo(x2.name));

        for (Person person : over30) {
            System.out.println(person.name + " - " + person.age);
        }
    }
}
