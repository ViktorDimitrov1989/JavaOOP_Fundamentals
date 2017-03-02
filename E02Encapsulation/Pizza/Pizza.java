package E02Encapsulation.Pizza;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private String name;
    private List<Topping> toppingList;
    private Dough dough;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        toppingList = new LinkedList<>();
        this.setNumberOfToppings(numberOfToppings);
    }

    public double getTotalCalories(){
        double result = 0.0;
        for (Topping topping : toppingList) {
            result += topping.getToppingCalories();
        }
        result += this.getDough().getDoughtCalories();
        return result;
    }

    public int getToppingSize(){
        return this.getToppingList().size();
    }

    public void addTopping(Topping topping){
        this.toppingList.add(topping);
    }

    public String getName(){
        return this.name;
    }

    private void setNumberOfToppings(int numberOfToppings){
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private Dough getDough(){
        return this.dough;
    }

    private List<Topping> getToppingList(){
        return Collections.unmodifiableList(this.toppingList);
    }

    private void setName(String name){
        if(name.length() == 0 || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getTotalCalories());
    }
}
