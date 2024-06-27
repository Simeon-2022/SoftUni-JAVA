package _14_Defining_Classes_Exercise._04_Raw_Data;

public class Engine {
    private int speed;

    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

  /*  @Override
    public String toString() {
        return String.format("%d %d", getSpeed(), getPower());
    }*/
}
