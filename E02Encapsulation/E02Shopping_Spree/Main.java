package E02Encapsulation.E02Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

            String[] peoples = reader.readLine().split(";");
            for (String people : peoples) {
                String[] tokens = people.split("=");
                String name = tokens[0];
                double money = Double.parseDouble(tokens[1]);

                try{
                    Person person = new Person(name, money);
                    persons.putIfAbsent(person.getName(), person);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                    return;
                }

            }


            String[] productsInput = reader.readLine().split(";");
            for (String product : productsInput) {
                String[] tokens = product.split("=");
                String name = tokens[0];
                double cost = Double.parseDouble(tokens[1]);
                try{
                    Product currentProduct = new Product(name, cost);
                    products.putIfAbsent(currentProduct.getName(), currentProduct);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                    return;
                }
            }

            String line = "";

            while (!"END".equals(line = reader.readLine())){
                String[] commands = line.split("\\s+");
                try{
                    persons.get(commands[0]).purchaseProduct(products.get(commands[1]));
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            }

        if(persons.size() != 0 && products.size() != 0){
            persons.entrySet().forEach(p -> {
                List<String> productsName = new ArrayList<>();
                if(p.getValue().getProducts().iterator().hasNext()){
                    p.getValue().getProducts().forEach(pr -> productsName.add(pr.getName()));
                }else{
                    productsName.add("Nothing bought");
                }
                System.out.println(p.getKey() + " - " + String.join(", ", productsName));
            });
        }
    }

}
