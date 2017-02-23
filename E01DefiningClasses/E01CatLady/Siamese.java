package E01DefiningClasses.E01CatLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", super.getName(), this.getEarSize());
    }
}
