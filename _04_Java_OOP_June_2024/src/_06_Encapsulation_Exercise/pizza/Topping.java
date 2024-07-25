package _06_Encapsulation_Exercise.pizza;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {

        if (toppingType.equalsIgnoreCase("meat") ||
                toppingType.equalsIgnoreCase("veggies") ||
                toppingType.equalsIgnoreCase("cheese") ||
                toppingType.equalsIgnoreCase("sauce")
        ) {
            this.toppingType = toppingType;
        } else {

            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    public void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {

            this.weight = weight;
        } else {

            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");

        }
    }

    public double calculateCalories() {

        double toppingsModifier = 0;

        switch (toppingType) {
            case "Meat":
                toppingsModifier = 1.2;
                break;

            case "Veggies":
                toppingsModifier = 0.8;
                break;
            case "Cheese":
                toppingsModifier = 1.1;
                break;
            case "Sauce":
                toppingsModifier = 0.9;
                break;

        }
        return (weight * 2) * toppingsModifier;
    }
}
