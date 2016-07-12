package DefiningClasses.Pr01DefineAClassPerson;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;
}

public class DefineAClassPerson {
    public static void main(String[] args) {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

        Person pesho = new Person();
        pesho.name = "Pesho";
        pesho.age = 20;

        Person gosho = new Person();
        pesho.name = "Gosho";
        pesho.age = 18;

        Person stamat = new Person();
        pesho.name = "Stamat";
        pesho.age = 43;
    }
}
