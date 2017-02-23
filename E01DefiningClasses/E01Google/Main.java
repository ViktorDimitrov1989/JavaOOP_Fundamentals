package E01DefiningClasses.E01Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new LinkedList<>();
        String line;
        while (!"End".equals(line = reader.readLine())){
            String[] arguments = line.split("\\s+");
            String name = arguments[0];
            if(!containsName(persons, name)){
                persons.add(new Person(name));
            }

            Person currentPerson = persons.get(getPerson(persons,name));
            String objectCommand = arguments[1];
            switch (objectCommand){
                case "company":
                    currentPerson.setCompany(createCompany(arguments));
                    break;
                case "pokemon":
                    currentPerson.setPokemon(createPokemon(arguments));
                    break;
                case "parents":
                    currentPerson.setParent(createParent(arguments));
                    break;
                case "children":
                    currentPerson.setChildren(createChild(arguments));
                    break;
                case "car":
                    currentPerson.setCar(createCar(arguments));
            }
        }

        String personOfInterest = reader.readLine();

        Person result = persons.get(getPerson(persons,personOfInterest));

        System.out.println(result);
    }

    private static Car createCar(String[] arguments) {
        String model = arguments[2];
        Integer speed = Integer.valueOf(arguments[3]);
        return new Car(model,speed);
    }

    private static Child createChild(String[] arguments) {
        String childName = arguments[2];
        String birthDay = arguments[3];
        return new Child(childName, birthDay);
    }

    private static Parent createParent(String[] arguments) {
        String name = arguments[2];
        String birthDay = arguments[3];
        return new Parent(name,birthDay);
    }


    private static Pokemon createPokemon(String[] arguments) {
        String pokemonName = arguments[2];
        String pokemonType = arguments[3];
        return new Pokemon(pokemonName, pokemonType);
    }

    private static Company createCompany(String[] arguments) {
        String companyName = arguments[2];
        String department = arguments[3];
        Double salary = Double.valueOf(arguments[4]);
        return new Company(companyName,department,salary);
    }

    public static int  getPerson(List<Person> personList, String name) {
        for (int i = 0; i < personList.size(); i++) {
            if(personList.get(i).getName().equals(name)){
                return i;
            }
        }
        return 0;
    }

    public static boolean containsName(final List<Person> list, final String name) {
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }
}
