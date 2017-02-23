package E01DefiningClasses.E01CarSalesman;

public class Engine {
    private static final String DEFAULT_EFFICIENCY_VALUE = "n/a";
    private static final Integer DEFAULT_DISPLACEMENT_VALUE = -1;

    private String model;
    private int power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model,
                  int power,
                  int displacement,
                  String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model,
                  int power,
                  int displacement){
        this(model,power,displacement,DEFAULT_EFFICIENCY_VALUE);
    }

    public Engine(String model,
                  int power,
                  String efficiency){
        this(model,power,DEFAULT_DISPLACEMENT_VALUE,efficiency);
    }

    public Engine(String model,
                  int power){
        this(model,power,DEFAULT_DISPLACEMENT_VALUE,DEFAULT_EFFICIENCY_VALUE);
    }

    public String getModel(){
        return this.model;
    }

    public int getPower() {
        return power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s",
                this.model,
                this.power,
                this.displacement.toString().replaceAll("-1", "n/a"),
                this.efficiency);
    }
}
