package DefiningClasses.Pr11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CatLady {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Cat> cats = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] params = input.split("\\s+");
            String breed = params[0];
            String name = params[1];
            input = reader.readLine();
            Cat cat = null;

            switch (breed) {
                case "Siamese" :
                    Integer earSize = Integer.parseInt(params[2]);
                    cat = new Siamese(name, earSize);
                    break;
                case "Cymric":
                    Double furLength = Double.parseDouble(params[2]);
                    cat = new Cymric(name, furLength);
                    break;
                case "StreetExtraordinaire":
                    Integer decibelsOfMeows = Integer.parseInt(params[2]);
                    cat = new StreetExtraordinaire(name, decibelsOfMeows);
            }

            cats.put(name, cat);
        }
        
        String searched = reader.readLine();
        System.out.println(cats.get(searched));
    }
}

abstract class Cat {
    protected String name;

    public Cat(String name) {
        this.name = name;
    }
}

class Siamese extends Cat {
    private Integer earSize;

    public Siamese(String name, Integer earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %d", this.name, this.earSize);
    }
}

class Cymric extends Cat {
    private Double furLength;

    public Cymric(String name, Double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", this.name, this.furLength);
    }
}

class StreetExtraordinaire extends Cat {
    private Integer decibelsOfMeows;

    public StreetExtraordinaire(String name, Integer decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %d", this.name, this.decibelsOfMeows);
    }
}