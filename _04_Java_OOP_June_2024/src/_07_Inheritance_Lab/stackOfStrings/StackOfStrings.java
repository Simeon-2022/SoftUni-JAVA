package _07_Inheritance_Lab.stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {

        String pop = this.data.get(data.size() - 1);
        this.data.remove(pop);
        return pop;
    }

    public String peek() {

        return this.data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }


}
