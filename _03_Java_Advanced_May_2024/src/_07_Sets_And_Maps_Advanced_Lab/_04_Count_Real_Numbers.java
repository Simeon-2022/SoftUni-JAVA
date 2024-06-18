package _07_Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class _04_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .toList();

        LinkedHashMap<Double,Integer> countOccurrences = new LinkedHashMap<>();

        for (Double number : numbers) {

            if (!countOccurrences.containsKey(number)) {
                countOccurrences.put(number, 1);

            } else {

                countOccurrences.put(number, countOccurrences.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> pairs : countOccurrences.entrySet()) {

            System.out.printf("%.1f -> %d%n", pairs.getKey(), pairs.getValue());
        }
    }
}
