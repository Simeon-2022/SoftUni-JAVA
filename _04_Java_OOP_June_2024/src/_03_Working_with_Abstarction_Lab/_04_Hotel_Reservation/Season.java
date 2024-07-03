package _03_Working_with_Abstarction_Lab._04_Hotel_Reservation;

public enum Season {
    SPRING(2),
    SUMMER(4),
    AUTUMN(1),
    WINTER(3);

    public int getMultiplier() {
        return multiplier;
    }

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

}
