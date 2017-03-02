package E02Encapsulation.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        Pizza pizza = null;
        Dough dough = null;
        while (!"END".equals(line = reader.readLine())){
            String[] pizzaArguments = line.split("\\s+");
            String pizzaName = pizzaArguments[1];
            int numberOfToppings = Integer.parseInt(pizzaArguments[2]);

            String[] doughArguments = reader.readLine().split("\\s+");
            String flourType = doughArguments[1];
            String bakingTechnique = doughArguments[2];
            double grams = Double.parseDouble(doughArguments[3]);

            try{
                pizza = new Pizza(pizzaName,numberOfToppings);
                dough = new Dough(flourType,bakingTechnique,grams);
                pizza.setDough(dough);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }

            for (int i = 0; i < numberOfToppings; i++) {
                String[] toppingArgs = reader.readLine().split("\\s+");
                String toppingType = toppingArgs[1];
                double toppingWeight = Double.parseDouble(toppingArgs[2]);

                Topping topping = null;
                try{
                    topping = new Topping(toppingType, toppingWeight);
                    pizza.addTopping(topping);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                    return;
                }
            }
        }
        System.out.println(pizza);
    }
}
