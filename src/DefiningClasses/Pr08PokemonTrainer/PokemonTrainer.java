package DefiningClasses.Pr08PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] info = input.split("\\s+");
            String trainerName = info[0];
            String pokemonName = info[1];
            String element = info[2];
            Integer health = Integer.parseInt(info[3]);

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }

            trainers.get(trainerName).addPokemons(new Pokemon(pokemonName, element, health));
            input = reader.readLine();
        }

        input = reader.readLine();

        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                Trainer currentTrainer = trainer.getValue();
                currentTrainer.checkPokemons(input);
            }

            input = reader.readLine();
        }

        trainers.values().stream().sorted((p1, p2) ->
                p2.getNumberOfBadges().compareTo(p1.getNumberOfBadges()))
                .forEach(System.out::println);
    }
}

class Trainer {
    private String name;
    private Integer numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Integer getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void addPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void checkPokemons (String element) {
        boolean hasNecessaryPokemon = false;
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                this.numberOfBadges += 1;
                hasNecessaryPokemon = true;
                break;
            }
        }

        if (!hasNecessaryPokemon) {
            for (Pokemon pokemon : this.pokemons) {
                pokemon.setHealth(pokemon.getHealth() - 10);
            }

            pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}

class Pokemon {
    private String name;
    private String element;
    private Integer health;

    public Pokemon(String name, String element, Integer health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}