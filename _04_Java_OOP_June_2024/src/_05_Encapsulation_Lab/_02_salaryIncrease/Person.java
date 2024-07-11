package _05_Encapsulation_Lab._02_salaryIncrease;

import java.text.DecimalFormat;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double newValue) {
        this.salary = newValue;
    }

    public void increaseSalary(double bonus) {

        if (getAge() < 30) {
            bonus *= 0.5;
        }
        setSalary(getSalary() * (1 + bonus / 100));
    }

    @Override

    public String toString() {

        DecimalFormat df = new DecimalFormat("#.0####");

        return String.format("%s %s is %d %s leva",
                getFirstName(),
                getLastName(),
                getAge(),
                df.format(getSalary()));
    }
}
