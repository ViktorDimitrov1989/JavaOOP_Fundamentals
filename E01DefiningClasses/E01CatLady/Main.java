package E01DefiningClasses.E01CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Cat> cats = new LinkedList<>();
        String line;
        while (!"End".equals(line = reader.readLine())){
            String[] arguments = line.split("\\s+");
            String type = arguments[0];
            String name = arguments[1];
            Double argument = Double.valueOf(arguments[2]);

            switch (type){
                case "Siamese":
                    cats.add(new Siamese(name,argument));
                    break;
                case "Cymric":
                    cats.add(new Cymric(name,argument));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(name,argument));
                    break;
            }
        }
        String neededCat = reader.readLine();
        Cat resultCat = findCatByName(neededCat,cats);
        System.out.println(resultCat);
    }

    private static Cat findCatByName(String neededCat, List<Cat> cats) {
        for (Cat cat : cats) {
            if(cat.getName().equals(neededCat)){
                return cat;
            }
        }
        return null;
    }
}
