package Methods.Pr02OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OldestFamilyMember {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {
        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addMember", Person.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Family family = new Family();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            family.addMember(new Person(data[0], Integer.parseInt(data[1])));
        }

        System.out.println(family.getOldestMember().toString());
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ' ' + age;
    }
}

class Family {
    private ArrayList<Person> people;

    public Family() {
        this.people = new ArrayList<>();
    }

    public void addMember (Person member) {
        people.add(member);
    }

    public Person getOldestMember () {
        List<Person> buffer = people
                .stream()
                .sorted((p1, p2) -> p2.getAge()
                        .compareTo(p1.getAge()))
                .collect(Collectors.toList());
        return buffer.get(0);
    }
}