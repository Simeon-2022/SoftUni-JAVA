package _17_Exceptions_and_Error_Handling_Lab;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class NumberinRange {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int begin = range[0];
        int end = range[1];
        System.out.printf("Range: [%d...%d]%n", begin, end);

        boolean isInRange = false;
        int n = begin - 1;
        while (!isInRange) {

            isInRange = true;
            String input = scanner.nextLine();

            try {
                n = Integer.parseInt(input);

                if (n <= begin || n >= end) {
                    throw new IOException();
                }

            } catch (Exception ignored) {
                System.out.println("Invalid number: " + input);
                isInRange = false;
            }

        }

        System.out.println("Valid number: " + n);
    }
}
