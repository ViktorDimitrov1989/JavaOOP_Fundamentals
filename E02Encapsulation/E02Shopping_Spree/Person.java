package E02Encapsulation.E02Shopping_Spree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, Double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }
    public String getName(){
        return this.name;
    }

    private double getMoney(){
        return this.money;
    }

    public Iterable<Product> getProducts(){
        return this.products;
    }

    private void setName(String name){
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money){
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void purchaseProduct(Product product){
        if(this.money - product.getCost() < 0){
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }

        this.money -= product.getCost();
        this.products.add(product);
        this.printSuccessBought(product);
    }

    private void printSuccessBought(Product product){
        System.out.println(this.name + " bought " + product.getName());
    }
}
