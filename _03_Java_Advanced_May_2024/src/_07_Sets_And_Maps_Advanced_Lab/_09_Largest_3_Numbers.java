package _07_Sets_And_Maps_Advanced_Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _09_Largest_3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();

        System.out.println(Arrays.toString(num.toArray()).replaceAll("[\\[\\],]", ""));
    }

}
