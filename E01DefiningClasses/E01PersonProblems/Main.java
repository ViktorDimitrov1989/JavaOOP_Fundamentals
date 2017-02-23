package E01DefiningClasses.E01PersonProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arguments = reader.readLine().split("\\s+");
            String name = arguments[0];
            int age = Integer.parseInt(arguments[1]);

            persons.add(new Person(name,age));
        }

        persons
                .stream()
                .filter(p -> p.getAge() > 30)
                .sorted((el1,el2) -> el1.getName().compareTo(el2.getName()))
                .forEach(el -> System.out.println(el.getName() + " - " + el.getAge()));
    }

}

