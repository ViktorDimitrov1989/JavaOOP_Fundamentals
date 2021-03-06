package E01DefiningClasses.E01PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name,
                   String element,
                   int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    public String getElement(){
        return this.element;
    }

    public void takeHealth(int amount){
        this.health -= amount;
    }


}
