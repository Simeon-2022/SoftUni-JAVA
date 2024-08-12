package vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle{


    final static double SUMMER_CONSUMPTION_RATE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {

        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION_RATE);
    }


    @Override
    void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + litres);
    }

    @Override
    void drive(double distance) {

        DecimalFormat format = new DecimalFormat("#.##");

        if (distance <= distanceAvailable()) {
            setFuelQuantity(getFuelQuantity() - (distance * getFuelConsumption()));
            System.out.printf("Car travelled %s km%n", format.format(distance));

        } else {
            throw new IllegalArgumentException("Car needs refueling");
        }
    }

    @Override
    double distanceAvailable() {
        return getFuelQuantity() / getFuelConsumption();
    }
}
