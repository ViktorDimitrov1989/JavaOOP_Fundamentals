package E01DefiningClasses.E01Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;
    private String name;

    public Person(String name){
        this.name = name;
        this.company = null;
        this.car = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }
    public Company getCompany(){
        return this.company;
    }

    public Car getCar(){
        return this.car;
    }

    public void setCar(Car car){
        this.car = car;
    }

    public List<Child> getChildren(){
        return this.children;
    }

    public void setChildren(Child child){
        this.getChildren().add(child);
    }

    public void setParent(Parent parent){
        this.getParents().add(parent);
    }


    public List<Parent> getParents(){
        return this.parents;
    }

    public List<Pokemon> getPokemons(){
        return this.pokemons;
    }

    public void setPokemon(Pokemon pokemon){
        this.getPokemons().add(pokemon);
    }

    public void setCompany(Company company){
        this.company = company;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s", this.getName(),
                this.getCompany() == null?"":this.getCompany() + "\n",
                this.getCar() == null?"":this.getCar() + "\n",
                printPokemons(this.getPokemons()),
                printParents(this.getParents()),
                printChildren(this.getChildren()));
    }

    private String printChildren(List<Child> children) {
        StringBuilder sb = new StringBuilder();
        for (Child child: children) {
            sb.append(child.getName() + " " + child.getBirthDate()).append("\n");
        }
        return sb.toString();
    }

    private String printParents(List<Parent> parents) {
        StringBuilder sb = new StringBuilder();
        for (Parent parent : parents) {
            sb.append(parent.getName() + " " + parent.getBirthDate()).append("\n");
        }
        return sb.toString();
    }

    private String printPokemons(List<Pokemon> pokemons){
        StringBuilder sb = new StringBuilder();
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon.getName() + " " + pokemon.getType()).append("\n");
        }
        return sb.toString();
    }
}
