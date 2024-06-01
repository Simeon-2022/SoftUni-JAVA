package _04_Stacks_And_Queues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _04_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> sortedNumbers = new ArrayDeque<>();

        for (int i = 0; i < command[0]; i++) {

            sortedNumbers.push(numbers[i]);
        }

        for (int i = 0; i < command[1]; i++) {

            sortedNumbers.pollLast();
        }

        if (sortedNumbers.isEmpty()) {
            System.out.println(0);
        }else if (sortedNumbers.contains(command[2])) {
            System.out.println("true");
        } else {
            System.out.println(sortedNumbers.stream().min(Integer::compareTo).orElse(0));
        }
    }
}
