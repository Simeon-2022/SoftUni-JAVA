package _03_Working_with_Abstarction_Lab._04_Hotel_Reservation;

public enum DiscountType {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private final double value;

    DiscountType(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static DiscountType getType(String str) {

        return switch (str) {
            case "VIP" -> VIP;
            case "SecondVisit" -> SECOND_VISIT;
            case "None" -> NONE;
            default -> throw new IllegalStateException("Unexpected value: " + str);
        };

    }
}
