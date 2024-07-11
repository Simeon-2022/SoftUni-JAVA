package _06_Encapsulation_Exercise.shoppingSpree;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName();
        setCost();
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    private void setName() {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setCost() {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.cost = cost;
    }

}
