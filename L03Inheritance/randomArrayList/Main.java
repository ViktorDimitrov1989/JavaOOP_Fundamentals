package L03Inheritance.randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();
        ral.add(1);
        ral.add(4);
        ral.add(67);
        ral.add("gosho");

        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
    }
}
