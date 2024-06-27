package _14_Defining_Classes_Exercise._04_Raw_Data;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre1;
    private Tyre tyre2;
    private Tyre tyre3;
    private Tyre tyre4;

    public Car(String model, Engine engine, Cargo cargo, Tyre tyre1, Tyre tyre2, Tyre tyre3, Tyre tyre4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyre1 = tyre1;
        this.tyre2 = tyre2;
        this.tyre3 = tyre3;
        this.tyre4 = tyre4;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyre getTyre1() {
        return tyre1;
    }

    public Tyre getTyre2() {
        return tyre2;
    }

    public Tyre getTyre3() {
        return tyre3;
    }

    public Tyre getTyre4() {
        return tyre4;
    }

    @Override
    public String toString() {
        return String.format("%s", getModel());
    }

    ;

}
