package E01CarSalesman;
public class Car {
    private static final String DEFAULT_COLOR_VALUE = "n/a";
    private static final Integer DEFAULT_WEIGHT_VALUE = -1;

    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model,
               Engine engine,
               int weight,
               String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model,
               Engine engine,
               int weight){
        this(model,engine,weight,DEFAULT_COLOR_VALUE);
    }

    public Car(String model,
               Engine engine,
               String color){
        this(model,engine,DEFAULT_WEIGHT_VALUE,color);
    }

    public Car(String model,
               Engine engine){
        this(model,engine,DEFAULT_WEIGHT_VALUE,DEFAULT_COLOR_VALUE);
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n  %s%n  Weight: %s%n  Color: %s",
                this.model,
                this.engine,
                this.weight.toString().replaceAll("-1", "n/a"),
                this.color);
    }
}
