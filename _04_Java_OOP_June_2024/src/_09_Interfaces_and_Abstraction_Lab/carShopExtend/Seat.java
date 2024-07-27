package carShopExtend;

public class Seat extends CarImpl implements Sellable{

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);

        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("This is %s produced in %s and have %d tires".formatted(getModel(), getCountryProduced(), TYRES));

        //Leon sells for 11111,100000
        print.append( System.lineSeparator()).append("%s sells for %f".formatted(getModel(), getPrice()));

        return print.toString();
    }
}
