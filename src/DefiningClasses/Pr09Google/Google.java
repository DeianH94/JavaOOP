package DefiningClasses.Pr09Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Google {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> people = new HashMap<>();
        String input = reader.readLine();

        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String name = info[0];
            if (!people.containsKey(name)) {
                people.put(name, new Person(name));
            }

            if (info[1].equals("company")) {
                Company company = new Company(info[2], info[3], Double.parseDouble(info[4]));
                people.get(name).setCompany(company);
            } else if (info[1].equals("pokemon")) {
                Pokemon pokemon = new Pokemon(info[2], info[3]);
                people.get(name).addPokemon(pokemon);
            } else if (info[1].equals("parents")) {
                Parents parent = new Parents(info[2], info[3]);
                people.get(name).addParents(parent);
            } else if (info[1].equals("children")) {
                Children child = new Children(info[2], info[3]);
                people.get(name).addChildren(child);
            } else {
                Car car = new Car(info[2], Integer.parseInt(info[3]));
                people.get(name).setCar(car);
            }

            input = reader.readLine();
        }

        String name = reader.readLine();

        for (Map.Entry<String, Person> person : people.entrySet()) {
            String personName = person.getKey();
            if (personName.equals(name)) {
                Person currentPerson = person.getValue();
                System.out.println(currentPerson);
                break;
            }
        }
    }
}

class Person {
    private String name;
    private Company company;
    private Car car;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Parents> parents;
    private ArrayList<Children> children;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParents(Parents parent) {
        this.parents.add(parent);
    }

    public void addChildren(Children child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder personBuilder = new StringBuilder();
        personBuilder.append(this.name).append(System.lineSeparator());
        personBuilder.append("Company:\n");
        if (this.company != null) {
            personBuilder.append(this.company.toString());
        }

        personBuilder.append("Car:\n");
        if (this.car != null) {
            personBuilder.append(this.car.toString());
        }

        personBuilder.append("Pokemon:\n");
        for(Pokemon pokemon : this.pokemons){
            personBuilder.append(pokemon.toString());
        }
        personBuilder.append("Parents:\n");
        for(Parents parent : this.parents){
            personBuilder.append(parent.toString());
        }
        personBuilder.append("Children:\n");
        for(Children child : this.children){
            personBuilder.append(child.toString());
        }

        String personOutput = personBuilder.toString();
        return personOutput;
    }
}

class Company {
    private String companyName;
    private String department;
    private Double salary;

    public Company(String companyName, String department, Double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f\n", this.companyName, this.department, this.salary);
    }
}

class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.pokemonName, this.pokemonType);
    }
}

class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.parentName, this.parentBirthday);
    }
}

class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", this.childName, this.childBirthday);
    }
}

class Car {
    private String carModel;
    private Integer carSpeed;

    public Car(String carModel, Integer carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %d\n", this.carModel, this.carSpeed);
    }
}
