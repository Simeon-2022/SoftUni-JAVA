package restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {
    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        setCalories(calories);
    }

    private double calories;




    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
