package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _07_Hands_Of_Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> scores = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> types = getCharacterIntegerLinkedHashMap();

        String input = scanner.nextLine();
        while (!"JOKER".equalsIgnoreCase(input)) {

            String name = input.substring(0, input.indexOf(":"));

            LinkedHashSet<String> cards = Arrays
                    .stream(input.substring(input.indexOf(":") + 1).trim().split(", "))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            if (!scores.containsKey(name)) {
                scores.putIfAbsent(name, new LinkedHashSet<>());
            }

            LinkedHashSet<String> playerCards = scores.get(name);
            playerCards.addAll(cards);
            scores.put(name, playerCards);
            input = scanner.nextLine();
        }

        scores.forEach((k, v) -> System.out.printf("%s: %d%n", k, extracted(v,types)));
    }

    private static int extracted(LinkedHashSet<String> cards , LinkedHashMap<String, Integer> types) {
        int score = 0;
        for (String card : cards) {

            if (Character.isDigit(card.charAt(1))) {

                score += types.get(card.substring(0, 2)) * types.get(String.valueOf(card.charAt(2)));

            } else {

                score += types.get(String.valueOf(card.charAt(0))) * types.get(String.valueOf(card.charAt(1)));
            }
        }
        return score;
    }

    private static LinkedHashMap<String, Integer> getCharacterIntegerLinkedHashMap() {
        LinkedHashMap<String, Integer> types = new LinkedHashMap<>();
        types.put("2", 2);
        types.put("3", 3);
        types.put("4", 4);
        types.put("5", 5);
        types.put("6", 6);
        types.put("7", 7);
        types.put("8", 8);
        types.put("9", 9);
        types.put("10", 10);
        types.put("J", 11);
        types.put("Q", 12);
        types.put("K", 13);
        types.put("A", 14);
        types.put("S", 4);
        types.put("H", 3);
        types.put("D", 2);
        types.put("C", 1);
        return types;
    }
}

