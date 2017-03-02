package E03Inheritance.manKind;

public class Student extends Human {
    private int facNumber;

    public Student(String firstName, String lastName, int facNumber) {
        super(firstName, lastName);
        this.setFacNumber(facNumber);
    }

    private int getFacNumber() {
        return this.facNumber;
    }

    private void setFacNumber(int facNumber) {
        if (("" + facNumber).length() < 5 ||
                ("" + facNumber).length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facNumber = facNumber;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Faculty number: ").append(this.getFacNumber())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
