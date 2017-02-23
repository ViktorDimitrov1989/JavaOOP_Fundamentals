package L02Encapsulation.L02FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public int getAge(){
        return this.age;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}
