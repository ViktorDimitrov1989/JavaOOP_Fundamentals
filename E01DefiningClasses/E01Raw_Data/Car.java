package E01DefiningClasses.E01Raw_Data;

import java.util.LinkedList;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private LinkedList<Tire> tires;

    public Car(String model,
               Engine engine,
               Cargo cargo){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new LinkedList<>();
    }

    public Engine getEngine(){
        return this.engine;
    }

    public String getModel(){
        return this.model;
    }

    public void addTire(Tire tire){
        this.tires.add(tire);
    }

    public Cargo getCargo(){
        return this.cargo;
    }

    public Tire getFlatTire(){
        Tire flatTire =  this.tires
                .stream()
                .sorted((a,b) -> Double.compare(a.getPressure(), b.getPressure()))
                .findFirst()
                .get();
        return flatTire;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
