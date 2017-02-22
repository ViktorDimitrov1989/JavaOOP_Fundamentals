package E01CompanyRooster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        HashMap<String,List<Employee>> employees = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] arguments = reader.readLine().split("\\s+");

            if(arguments.length == 6){
                String name = arguments[0];
                double salary = Double.parseDouble(arguments[1]);
                String position = arguments[2];
                String department = arguments[3];
                String email = arguments[4];
                int age = Integer.parseInt(arguments[5]);

                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(new Employee(name,
                        salary,
                        position,
                        department,
                        email,
                        age));
            }
            else if(arguments.length == 5){
                String name = arguments[0];
                double salary = Double.parseDouble(arguments[1]);
                String position = arguments[2];
                String department = arguments[3];
                String email = arguments[4];

                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(new Employee(name,
                        salary,
                        position,
                        department,
                        email));
            }
            else{
                String name = arguments[0];
                double salary = Double.parseDouble(arguments[1]);
                String position = arguments[2];
                String department = arguments[3];

                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(new Employee(name,
                        salary,
                        position,
                        department));
            }
        }

        HashMap<String, List<Employee>> sortedDeparments = employees.entrySet()
                .stream()
                .sorted((e1,e2) -> {
                    Double e1Average = calcAverageSalary(e1.getValue());
                    Double e2Average = calcAverageSalary(e2.getValue());

                    int result = Double.compare(e2Average, e1Average);
                    return result;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));

        Map.Entry<String, List<Employee>> res = sortedDeparments
                .entrySet()
                .stream()
                .findFirst()
                .get();

        System.out.println("Highest Average Salary: " + res.getKey());
        res.getValue()
                .stream()
                .sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(System.out::println);
    }

    private static Double calcAverageSalary(List<Employee> value) {
        Double sum = 0d;
        for (Employee employee : value) {
            sum += employee.getSalary();
        }
        return sum/value.size();
    }
}
