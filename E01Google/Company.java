package E01Google;

public class Company {
    private String name;
    private String department;
    private double sallary;

    public Company(String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.sallary = salary;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.sallary;
    }

    @Override
    public String toString() {
        return String.format("Company:%n%s %s %.2f%n", this.getName(), this.getDepartment(), this.getSalary());
    }
}
