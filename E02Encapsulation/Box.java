package E02Encapsulation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private double getLength() {
        return this.length;
    }

    private double getWidth() {
        return this.width;
    }

    private double getHeight() {
        return this.height;
    }

    private void setLength(double length) {
        if(width < 1){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(width < 1){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(width < 1){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getVolume(){
        double result = this.getLength() * this.getWidth() * this.getHeight();
        return result;
    }

    public double getLateralSurfaceArea(){
        double result = 2 * (this.getLength() * this.getHeight()) + 2 * (this.getWidth() * this.getHeight());
        return result;
    }

    public double getSurfaceArea(){
        double result = 2 * (this.getLength() * this.getWidth())
                + 2 * (this.getLength() * this.getHeight())
                + 2 * (this.getWidth() * this.getHeight());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f%n",
                this.getSurfaceArea(),
                this.getLateralSurfaceArea(),
                this.getVolume());
    }
}
