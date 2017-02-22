package E01CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int engineCount = Integer.parseInt(reader.readLine());


        HashMap<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < engineCount; i++) {
            String[] arguments = reader.readLine().split("\\s+");
            String model = arguments[0];
            Integer power = Integer.parseInt(arguments[1]);
            Integer displacement = null;
            String efficiency = null;
            Engine engine = null;
            if(arguments.length == 4){
                displacement = Integer.parseInt(arguments[2]);
                efficiency = arguments[3];
                engine = new Engine(model,power,displacement,efficiency);
            }
            else if(arguments.length == 3){
                try{
                    displacement = Integer.parseInt(arguments[2]);
                    engine = new Engine(model,power,displacement);
                }catch (Exception e){
                    efficiency = arguments[2];
                    engine = new Engine(model,power,efficiency);
                }
            }
            else{
                engine = new Engine(model,power);
            }
            engines.put(model,engine);
        }


        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        int carsCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < carsCount; i++) {
            String[] arguments = reader.readLine().split("\\s+");

            String model = arguments[0];
            Engine engine = engines.get(arguments[1]);

            Integer weight = null;
            String color = null;
            Car car = null;
            if(arguments.length == 4){
                weight = Integer.parseInt(arguments[2]);
                color = arguments[3];
                car = new Car(model,engine,weight,color);
            }
            else if(arguments.length == 3){
                try{
                    weight = Integer.parseInt(arguments[2]);
                    car = new Car(model,engine,weight);
                }catch (Exception e){
                    color = arguments[2];
                    car = new Car(model,engine,color);
                }
            }
            else{
                car = new Car(model,engine);
            }
            cars.put(model, car);
        }

        for (Map.Entry<String, Car> car : cars.entrySet()) {
            System.out.println(car.getValue());
        }
        String debug = "";
    }
}
