package _06_Encapsulation_Exercise.classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        sideValidation(length, "Length");

        this.length = length;
    }

    private void setWidth(double width) {
        sideValidation(width, "Width");

        this.width = width;
    }

    private void setHeight(double height) {
        sideValidation(height, "Height");

        this.height = height;
    }


    private void sideValidation(double param, String paramName) {

        if (param <= 0) {
            throw new IllegalArgumentException(paramName + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * (length * height + length * width + height * width);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (length * height + height * width);
    }

    public double calculateVolume() {
        return length * height * width;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume – %.2f", calculateSurfaceArea(),calculateLateralSurfaceArea(), calculateVolume());
    }
}
