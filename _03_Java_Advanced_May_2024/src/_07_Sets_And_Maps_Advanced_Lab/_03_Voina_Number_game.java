package _07_Sets_And_Maps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Voina_Number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> player1Deck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> player2Deck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 1;
        while (rounds <= 50 && !player1Deck.isEmpty() && !player2Deck.isEmpty()) {

            int firstPlayerCard = getFirstCard(player1Deck);
            int secondPlayerCard = getFirstCard(player2Deck);

            if (firstPlayerCard > secondPlayerCard) {

                player1Deck.remove(firstPlayerCard);
                player2Deck.remove(secondPlayerCard);

                player1Deck.add(firstPlayerCard);
                player1Deck.add(secondPlayerCard);

            } else if (firstPlayerCard < secondPlayerCard) {

                player1Deck.remove(firstPlayerCard);
                player2Deck.remove(secondPlayerCard);

                player2Deck.add(firstPlayerCard);
                player2Deck.add(secondPlayerCard);

            } else {
                player1Deck.remove(firstPlayerCard);
                player2Deck.remove(secondPlayerCard);

                player1Deck.add(firstPlayerCard);
                player2Deck.add(secondPlayerCard);

            }


            rounds++;
        }

        if (player1Deck.size() > player2Deck.size()) {
            System.out.println("First player win!");
        } else if (player1Deck.size() < player2Deck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    public static int getFirstCard(LinkedHashSet<Integer> cards) {
        int card = Integer.MIN_VALUE;

        for (int firstNum : cards) {
            card = firstNum;
            break;
        }
        return card;

    }
}
