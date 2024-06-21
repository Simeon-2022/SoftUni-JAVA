package _13_Defining_Classes_Lab;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car() { }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

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
