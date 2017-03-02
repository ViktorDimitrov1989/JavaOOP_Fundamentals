package E02Encapsulation.Pizza;

public class Dough {
    private final static double BASE_CALORIES_PER_GRAM = 2.0;
    private static double FLOUR_CALORIES = 0;
    private static double BAKING_TECHNIQUE_CALORIES = 0;


    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private double getWeight() {
        return weight;
    }

    private void setWeight(double weight){
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique){
        if(bakingTechnique.equalsIgnoreCase("crispy")){
            FLOUR_CALORIES = 0.9;
        }
        else if(bakingTechnique.equalsIgnoreCase("chewy")){
            FLOUR_CALORIES = 1.1;
        }
        else if(bakingTechnique.equalsIgnoreCase("homemade")){
            FLOUR_CALORIES = 1.0;
        }
        else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType){
        if(flourType.equalsIgnoreCase("white")){
            BAKING_TECHNIQUE_CALORIES = 1.5;
        }
        else if(flourType.equalsIgnoreCase("wholegrain")){
            BAKING_TECHNIQUE_CALORIES = 1.0;
        }
        else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public double getDoughtCalories(){
        return (this.getWeight() * BASE_CALORIES_PER_GRAM) * FLOUR_CALORIES * BAKING_TECHNIQUE_CALORIES;
    }

}
