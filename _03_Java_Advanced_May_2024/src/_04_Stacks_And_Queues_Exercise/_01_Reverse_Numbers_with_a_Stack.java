package _04_Stacks_And_Queues_Exercise;

import java.util.*;

public class _01_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int number : input) {
            numbers.push(number);
        }

        numbers.forEach(n-> System.out.print(n + " "));
    }
}
