package _04_Working_with_Abstraction_Exercise.cardswithpower;

public enum CardSuitPower {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int powerIndex;

    CardSuitPower(int powerIndex) {
    this.powerIndex = powerIndex;
    }

    public int getPowerIndex() {
        return powerIndex;
    }


}
