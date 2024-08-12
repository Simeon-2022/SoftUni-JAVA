package _17_Exceptions_and_Error_Handling_Lab;

import java.io.IOException;
import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n;

        try {
            n = Integer.parseInt(input);

            if (n < 0) {
                throw new ArithmeticException();
            }

            System.out.println("%.2f".formatted(Math.sqrt(n)));

        } catch (Exception ignored) {

            System.out.println("Invalid");

        } finally {
            System.out.println("Goodbye");
        }

    }
}
