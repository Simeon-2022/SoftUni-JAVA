package vehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    final static double SUMMER_CONSUMPTION_RATE = 1.6;
    final static double FUEL_RETENTION_RATE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION_RATE);
    }


    @Override
    void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + FUEL_RETENTION_RATE * litres);
    }

    @Override
    void drive(double distance) {
        DecimalFormat format = new DecimalFormat("#.##");

        if (distance <= distanceAvailable()) {
            setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            System.out.printf("Truck travelled %s km%n", format.format(distance));

        } else {
            throw new IllegalArgumentException("Truck needs refueling");
        }
    }

    @Override
    double distanceAvailable() {
        return getFuelQuantity() / getFuelConsumption();
    }
}
