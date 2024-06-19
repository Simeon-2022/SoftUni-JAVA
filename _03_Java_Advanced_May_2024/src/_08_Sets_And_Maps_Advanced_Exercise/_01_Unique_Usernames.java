package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_Unique_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
