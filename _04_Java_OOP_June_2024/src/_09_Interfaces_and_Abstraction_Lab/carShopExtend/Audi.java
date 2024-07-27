package carShopExtend;

public class Audi extends CarImpl implements Rentable {
    Integer minRentDay;
    Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduced, Integer minRentDay, Double pricePerDay) {

        super(model, color, horsePower, countryProduced);

        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        //Minimum rental period of 3 days. Price per day 99,900000

        StringBuilder print = new StringBuilder("This is %s produced in %s and have %d tires".formatted(getModel(), getCountryProduced(), TYRES));
        print.append( System.lineSeparator()).append("Minimum rental period of %d days. Price per day %f".formatted(getMinRentDay(), getPricePerDay()));

        return print.toString();
    }
}
