package _07_Sets_And_Maps_Advanced_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class _08_Academy_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> students = new TreeMap<>();

        int iters = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < iters; i++) {

            String nameStudent = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).toList();
            students.put(nameStudent, grades);
        }

        students.forEach((key, value) -> {
            double average = value
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();

            System.out.printf("%s is graduated with %f%n", key, average);

        });
    }
}
