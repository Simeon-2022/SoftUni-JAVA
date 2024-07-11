package _06_Encapsulation_Exercise.animalFarm;

public class Chicken {

    private String name;
    private int age;


    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }


    private void setName(String name) {
        if (name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 1 || age > 14) {
            throw new IllegalArgumentException("Age should be between 0 and 15");
        }

        this.age = age;
    }

    private double calculateProductPerDay() {
        double eggsPerDay = 0.75;

        if (this.age >= 0 && this.age <= 5) {
            eggsPerDay = 2;
        } else if (this.age <= 11) {
            eggsPerDay = 1;
        }
        return eggsPerDay;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }
    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay() );
    }

}
