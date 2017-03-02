package E03Inheritance.manKind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary < 11) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.calculateSalaryPerHour()))
                .append(System.lineSeparator());

        return sb.toString();
    }

    private Object calculateSalaryPerHour() {
        return this.getWeekSalary() / (this.getWorkHoursPerDay() * 7);
    }
}
