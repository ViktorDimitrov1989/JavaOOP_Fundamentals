package L02Encapsulation;

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

    private int getAge(){
        return this.age;
    }

    private double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private String getFirstName() {
        return this.firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private void setFirstName(String firstName) {
        if(firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setAge(int age) {
        if(age < 1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s get %s leva", this.getFirstName(), this.getLastName(), this.getSalary());
    }

    public void increaseSallary(double bonus) {
        if(this.getAge() < 30){
            this.setSalary(this.getSalary() + this.getSalary() * bonus / 200);
        }
        else{
            this.setSalary(this.getSalary() + this.getSalary() * bonus / 100);
        }
    }
}
