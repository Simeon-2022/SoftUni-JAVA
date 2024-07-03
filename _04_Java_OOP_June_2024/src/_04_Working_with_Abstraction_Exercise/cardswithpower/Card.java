package _04_Working_with_Abstraction_Exercise.cardswithpower;

public class Card {

    private static int power;


    Card(CardRankPower cardRankPower, CardSuitPower cardSuitPower) {
        this.power = cardRankPower.getPowerIndex() + cardSuitPower.getPowerIndex();
    }

    public int getPower() {
        return power;
    }
}
