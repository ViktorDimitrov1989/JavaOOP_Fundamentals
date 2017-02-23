package E01DefiningClasses.E01Raw_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arguments = reader.readLine().split("\\s+");
            String model = arguments[0];

            int engineSpeed = Integer.parseInt(arguments[1]);
            int enginePower = Integer.parseInt(arguments[2]);
            Engine engine = new Engine(engineSpeed,enginePower);

            int cargoWeight = Integer.parseInt(arguments[3]);
            String cargoType = arguments[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model,engine,cargo);
            for (int j = 5; j < arguments.length; j+=2) {
                double pressure = Double.parseDouble(arguments[j]);
                int age = Integer.parseInt(arguments[j + 1]);
                car.addTire(new Tire(pressure, age));
            }

            cars.putIfAbsent(model, car);
        }
        String command = reader.readLine();

        if(command.equals("fragile")){
            cars.values()
                    .stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getFlatTire().getPressure() < 1)
            .forEach(System.out::println);
            return;
        }
        cars.values()
                .stream()
                .filter(car -> car.getCargo().getType().equals("flamable"))
                .filter(car -> car.getEngine().getEnginePower() > 250)
                .forEach(System.out::println);

    }
}
