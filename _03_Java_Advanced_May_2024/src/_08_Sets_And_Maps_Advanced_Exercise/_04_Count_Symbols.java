package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class _04_Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> word = new TreeMap<>();

        char[] input = scanner.nextLine().toCharArray();

        for (char c : input) {

            if (!word.containsKey(c)) {
                word.put(c, 1);
            } else {
                word.put(c, word.get(c) + 1);
            }
        }

        word.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));

    }
}
