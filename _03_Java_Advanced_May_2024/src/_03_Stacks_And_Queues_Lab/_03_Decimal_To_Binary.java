package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_Decimal_To_Binary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binary = new ArrayDeque<>();

        if (number == 0) {
            binary.offerFirst(number);

        }

        while (number != 0) {

            binary.offerFirst(number % 2);
            number /= 2;
        }

        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
    }

    public static void printStack(ArrayDeque<Integer> ints) {

        while (!ints.isEmpty()) {
            System.out.print(ints.pop());
        }

    }
}
