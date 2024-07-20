package _06_Encapsulation_Exercise.pizza;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equalsIgnoreCase("white") || flourType.equalsIgnoreCase("wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equalsIgnoreCase("crispy") ||
                bakingTechnique.equalsIgnoreCase("chewy") ||
                bakingTechnique.equalsIgnoreCase("homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }


    public double calculateCalories() {

        double flourTypeModifier = 0;

        switch (flourType) {
            case "White":
                flourTypeModifier = 1.5;
                break;
            case "Wholegrain":
                flourTypeModifier = 1.0;
                break;
        }

        double bakingTechniqueModifier = 0;

        switch (bakingTechnique) {
            case "Crispy":
                bakingTechniqueModifier = 0.9;
                break;
            case "Chewy":
                bakingTechniqueModifier = 1.1;
                break;
            case "Homemade":
                bakingTechniqueModifier = 1.0;
                break;

        }

        return (weight * 2) * flourTypeModifier * bakingTechniqueModifier;
    }

}
