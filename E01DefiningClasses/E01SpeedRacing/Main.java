package E01DefiningClasses.E01SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(reader.readLine());

        HashMap<String, Car> cars = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] arguments = reader.readLine().split("\\s+");
            String model = arguments[0];
            double fuelAmount = Double.parseDouble(arguments[1]);
            double fuelCost = Double.parseDouble(arguments[2]);
            cars.putIfAbsent(model, new Car(model, fuelAmount, fuelCost));
        }

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");
            String carModel = arguments[1];
            double kmAmount = Double.parseDouble(arguments[2]);

            Car current = cars.get(carModel);
            try {
                current.drive(kmAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        cars
                .entrySet()
                .stream()
                .sorted((a,b) -> a.getKey().compareTo(b.getKey()))
                .forEach(a -> System.out.println(a.getValue()));
    }
}
