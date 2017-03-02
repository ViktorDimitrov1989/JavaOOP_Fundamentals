package E03Inheritance.manKind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String[] studentData = reader.readLine().split("\\s+");
            String studentFirstName = studentData[0];
            String studentLastName = studentData[1];
            int studentFacNumber = Integer.parseInt(studentData[2]);

            Student student = new Student(studentFirstName,
                    studentLastName,
                    studentFacNumber);


            String[] workerData = reader.readLine().split("\\s+");
            String workerFirstName = workerData[0];
            String workerLastName = workerData[1];
            double weekSalary = Double.parseDouble(workerData[2]);
            double hoursPerDay = Double.parseDouble(workerData[3]);

            Worker worker = new Worker(workerFirstName,
                    workerLastName,
                    weekSalary,
                    hoursPerDay);

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
