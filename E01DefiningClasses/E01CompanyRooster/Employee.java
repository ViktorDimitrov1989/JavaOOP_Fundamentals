package E01DefiningClasses.E01CompanyRooster;

public class Employee extends Person{
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;

    private double salary;
    private String position;
    private String department;
    private String email;

    public Employee(String name,
                    double salary,
                    String position,
                    String department,
                    String email,
                    int age){
        super(name,age);
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;

    }

    public Employee(String name,
                    double salary,
                    String position,
                    String department){
        super(name);
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = DEFAULT_EMAIL;
    }

    public Employee(String name,
                    double salary,
                    String position,
                    String department,
                    String email){
        super(name);
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public Employee(String name,
                    double salary,
                    String position,
                    String department,
                    int age){
        super(name, age);
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = DEFAULT_EMAIL;
    }

    public double getSalary(){
        return this.salary;
    }

    public String getDepartment(){
        return this.department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", super.getName(), this.getSalary(), this.email, this.getAge());
    }
}
