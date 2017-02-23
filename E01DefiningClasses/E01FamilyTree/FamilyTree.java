package E01DefiningClasses.E01FamilyTree;

import java.util.LinkedList;
import java.util.List;

public class FamilyTree {
    private List<Person> parents;
    private List<Person> children;
    private Person personOfInterest;

    public FamilyTree(){
        this.parents = new LinkedList<Person>();
        this.children = new LinkedList<Person>();
        this.personOfInterest = null;
    }

    public Person getPersonOfInterest() {
        return this.personOfInterest;
    }

    public void setPersonOfInterest(Person personOfInterest) {
        this.personOfInterest = personOfInterest;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void findParentByName(String birthDate, String name) {
        for (Person parent : this.getParents()) {
            if(parent.getBirthDate().equals(birthDate)){
                parent.setName(name);
            }
        }
    }

    public void findParentByBirthDate(String name, String birthDate) {
        for (Person parent : this.getParents()) {
            if(parent.getName().equals(name)){
                parent.setBirthDate(birthDate);
            }
        }
    }

    public void findChildByName(String name, String birthDate) {
        for (Person child : this.getChildren()) {
            if(child.getName().equals(name)){
                child.setBirthDate(birthDate);
            }
        }
    }

    public void findChildByBirthDate(String birthDate, String name) {
        for (Person child : this.getChildren()) {
            if(child.getBirthDate().equals(birthDate)){
                child.setBirthDate(name);
            }
        }
    }

    private String printPersons(List<Person> persons){
        StringBuilder sb = new StringBuilder();
        for (Person obj : persons) {
            sb.append(obj).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s%nParents:%n%sChildren:%n%s",
                this.personOfInterest,
                printPersons(this.getParents()),
                printPersons(this.getChildren()));
    }
}
