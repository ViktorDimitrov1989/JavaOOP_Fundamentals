package E01DefiningClasses.E01FamilyTree;

public class Person {
    private String name;
    private String birthDate;

    public Person(){
        this("","");
    }

    public Person(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                this.getName(),
                this.getBirthDate());
    }
}
