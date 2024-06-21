package _13_Defining_Classes_Lab;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private String printCarInfo() {
        return String.format("The car is: %s %s - %d HP.",getBrand(), getModel(), getHorsePower());
    }

    @Override
    public String toString() {
        return printCarInfo();
    }
}
