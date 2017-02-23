package E01DefiningClasses.E01CatLady;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String name, double decibels){
        super(name);
        this.decibels = decibels;
    }

    public double getDecibels() {
        return decibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.0f", super.getName(), this.getDecibels());
    }

}
