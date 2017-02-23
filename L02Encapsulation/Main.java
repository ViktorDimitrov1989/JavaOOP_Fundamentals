package L02Encapsulation;

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
            String firstName = arguments[0];
            String lastName = arguments[1];
            int age = Integer.parseInt(arguments[2]);
            double salary = Double.parseDouble(arguments[3]);
            try{
                Person person = new Person(firstName,lastName,age,salary);
                persons.add(person);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        if(!persons.isEmpty()){
            System.out.println("--------------------");
            double bonus = Double.parseDouble(reader.readLine());
            for (Person person : persons) {
                person.increaseSallary(bonus);
                System.out.println(person.toString());
            }
        }

    }
}
