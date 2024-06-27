package _14_Defining_Classes_Exercise._04_Raw_Data;

public class Tyre {
    private double pressure;
    private int age;


    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }


    public Tyre(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

 /*   @Override
    public String toString() {
        return String.format("%s %d",getPressure(), getAge());
    }*/
}
