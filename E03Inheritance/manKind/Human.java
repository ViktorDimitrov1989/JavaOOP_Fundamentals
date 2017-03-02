package E03Inheritance.manKind;

public abstract class Human {
    protected String firstName;
    protected String lastName;

    public Human(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        if(!String.valueOf(firstName.charAt(0)).matches("[A-Z]")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(!String.valueOf(lastName.charAt(0)).matches("[A-Z]")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }

        this.lastName = lastName;
    }
}
