package L03Inheritance.stackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings{
    private List<String> data;

    public StackOfStrings(){
        data = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    public void push(String element){
        this.data.add(element);
    }

    public String pop(){
        return this.data.remove(this.data.size() - 1);
    }

    public String peek(){
        return this.data.get(this.data.size() - 1);
    }

}
