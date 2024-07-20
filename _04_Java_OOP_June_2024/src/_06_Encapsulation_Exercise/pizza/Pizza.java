package _06_Encapsulation_Exercise.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);

    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        } else {
            this.name = name;
        }
    }

    private void setToppings(int numberOfToppings) {

        if (numberOfToppings >= 0 && numberOfToppings <= 10) {
            this.toppings = new ArrayList<>(numberOfToppings);

        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough) {

        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addToppings(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories() {

        double toppingCalories = toppings.stream().map(Topping::calculateCalories).mapToDouble(Double::doubleValue).sum();

        return dough.calculateCalories() + toppingCalories;
    }

}
