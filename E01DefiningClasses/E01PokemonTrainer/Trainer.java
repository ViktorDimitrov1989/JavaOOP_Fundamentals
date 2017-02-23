package E01DefiningClasses.E01PokemonTrainer;

import java.util.LinkedList;
import java.util.List;

public class Trainer {
    private static final int BADGES_DEFAULT_VALUE = 0;

    String name;
    private List<Pokemon> pokemonList;
    private int badges;

    public Trainer(String name){
        this.name = name;
        this.pokemonList = new LinkedList<>();
        this.badges = BADGES_DEFAULT_VALUE;
    }
    public int getBadges(){
        return this.badges;
    }

    public int updateBadges(){
        return this.badges += 1;
    }

    public String getName(){
        return this.name;
    }

    public List<Pokemon> getPokemonList(){
        return this.pokemonList;
    }

}
