package _05_Encapsulation_Lab._03_validationData;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
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

    public void setFirstName(String name) {
        validateName(name, "First");
        this.firstName = name;
    }

    public void setLastName(String name) {
        validateName(name, "Last");
        this.lastName = name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double newValue) {
        if (newValue < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = newValue;
    }

    public void increaseSalary(double bonus) {

        if (getAge() < 30) {
            bonus *= 0.5;
        }
        setSalary(getSalary() * (1 + bonus / 100));
    }

    private void validateName(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
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
