package _08_Sets_And_Maps_Advanced_Exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _02_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> setA = new LinkedHashSet<>();
        LinkedHashSet<Integer> setB = new LinkedHashSet<>();

        for (int i = 0; i < dimentions[0]; i++) {
            setA.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < dimentions[1]; i++) {
            setB.add(Integer.parseInt(scanner.nextLine()));
        }

            setA.retainAll(setB);
            setA.forEach(i -> System.out.print(i + " "));

/*
        for (int i : setA) {

            if (setB.contains(i)) {
                System.out.print(i + " ");
            }
        }*/


    }
}
