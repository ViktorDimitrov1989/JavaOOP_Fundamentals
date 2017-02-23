package E01DefiningClasses.E01Google;

public class Child {
    private String name;
    private String birthDate;

    public Child(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getBirthDate());
    }
}
