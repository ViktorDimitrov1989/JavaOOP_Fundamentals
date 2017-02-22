package E01Google;

import E01CarSalesman.*;

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
        this.parents = null;
        this.children = null;
        this.pokemons = null;
    }
    public void setCar(Car car){
        this.car = car;
    }

    private List<Child> getChildren(){
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




}
