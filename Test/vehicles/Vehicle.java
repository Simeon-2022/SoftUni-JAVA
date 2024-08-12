package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    abstract void refuel(double litres);
    abstract void drive(double distance);
    abstract double distanceAvailable();

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(),getFuelQuantity());
    }
}
