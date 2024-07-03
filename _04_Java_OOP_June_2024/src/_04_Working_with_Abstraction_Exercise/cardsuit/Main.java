package _04_Working_with_Abstraction_Exercise.cardsuit;

public class Main {
    public static void main(String[] args) {

        CardSuit[] cardSuitsArr = CardSuit.values();

        System.out.println("Card Suits:");
        for (CardSuit cardSuit : cardSuitsArr) {
            System.out.println((String.format("Ordinal value: %d; Name value: %s", cardSuit.ordinal(), cardSuit.name())));
        }
    }
}
