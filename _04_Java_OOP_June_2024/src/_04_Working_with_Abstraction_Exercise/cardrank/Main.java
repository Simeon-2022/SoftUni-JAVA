package _04_Working_with_Abstraction_Exercise.cardrank;

public class Main {

    public static void main(String[] args) {
        CardRank[] cardRank = CardRank.values();

        System.out.println("Card Ranks:");
        for (CardRank rank : cardRank) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
        }
    }

}
