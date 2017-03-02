package E02Encapsulation.Pizza;

public class Topping {
    private static final double BASE_CALORIES_PER_GRAM = 2.0;

    private double weight;
    private String type;
    private double caloriesByToppingType;

    public  Topping(String type,double weight){
        this.setType(type);
        this.setWeight(weight);

    }

    private double getWeight(){
        return this.weight;
    }

    private String getType(){
        return this.type;
    }

    private void setType(String type){
        if(type.equalsIgnoreCase("meat")){
            this.setCaloriesByToppingType(1.2);
        }
        else if(type.equalsIgnoreCase("veggies")){
            this.setCaloriesByToppingType(0.8);
        }
        else if(type.equalsIgnoreCase("cheese")){
            this.setCaloriesByToppingType(1.1);
        }
        else if(type.equalsIgnoreCase("sauce")){
            this.setCaloriesByToppingType(0.9);
        }
        else{
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setCaloriesByToppingType(double caloriesByToppingType){
        this.caloriesByToppingType = caloriesByToppingType;
    }

    private double getCaloriesByToppingType(){
        return this.caloriesByToppingType;
    }

    private void setWeight(double weight){
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        this.weight = weight;
    }

    public double getToppingCalories(){
        double result = (this.getWeight() * this.getCaloriesByToppingType()) * BASE_CALORIES_PER_GRAM;
        return result;
    }


}
