package Methods.Pr01MethodSaysHello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodSaysHello {
    public static void main(String[] args) throws IOException {
        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Person.class.getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String name = buffer.readLine();
        Person person = new Person(name);
        System.out.println(person.sayHello());
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String sayHello() {
        return this.name + " says \"Hello\"!";
    }
}
