package E01DefiningClasses.E01PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<Trainer> trainers = new LinkedList<>();
        while (!"Tournament".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            String trainerName = arguments[0];
            String pokemonName = arguments[1];
            String pokemonElement = arguments[2];
            Integer pokemonHealth = Integer.valueOf(arguments[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!containsName(trainers, trainerName)) {
                Trainer pokemonTrainer = new Trainer(trainerName);
                trainers.add(pokemonTrainer);
            }
            Trainer pokemonTrainer = findTrainerByName(trainers, trainerName);
            assert pokemonTrainer != null;//TODO WTF
            pokemonTrainer.getPokemonList().add(pokemon);
        }

        while (!"End".equals(line = reader.readLine())) {
            switch (line) {
                case "Fire":
                    checkForPokemon(trainers, "Fire");
                    break;
                case "Water":
                    checkForPokemon(trainers, "Water");
                    break;
                case "Electricity":
                    checkForPokemon(trainers, "Electricity");
                    break;
            }
        }

        trainers
                .stream()
                .sorted((a, b) -> Integer.compare(b.getBadges(), a.getBadges()))
                .forEach(trainer -> System.out.println(trainer.getName() + " " + trainer.getBadges() + " " + trainer.getPokemonList().size()));

    }

    private static void checkForPokemon(List<Trainer> trainers, String element) {
        for (Trainer trainer : trainers) {
            if (trainer.getPokemonList().stream().anyMatch(o -> o.getElement().equals(element))) {
                trainer.updateBadges();
            } else {
                for (Pokemon pokemon : trainer.getPokemonList()) {
                    pokemon.takeHealth(10);
                    if (pokemon.getHealth() <= 0) {
                        trainer.getPokemonList().remove(pokemon);
                    }
                }
            }
        }
    }

    public static Trainer findTrainerByName(List<Trainer> trainers, String name) {
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(name)) {
                return trainer;
            }
        }
        return null;
    }

    public static boolean containsName(final List<Trainer> list, final String name) {
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }
}
