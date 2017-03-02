package L03Inheritance.stackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();

        sos.push("Pesho");
        sos.push("Gosho");
        sos.push("Mimi");

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());

    }
}
