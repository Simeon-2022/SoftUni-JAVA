package _14_Defining_Classes_Exercise._04_Raw_Data;

public class Cargo {

    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

 /*   @Override
    public String toString() {
        return String.format("%d %s", getWeight(), getType());
    }*/
}
