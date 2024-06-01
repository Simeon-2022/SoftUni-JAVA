package _04_Stacks_And_Queues_Exercise;

import java.lang.reflect.Array;
import java.util.*;

public class _02_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> sortedNumbers = new ArrayDeque<>();

        for (int i = 0; i < command[0]; i++) {

            sortedNumbers.push(numbers[i]);
        }

        for (int i = 0; i < command[1]; i++) {

            sortedNumbers.pop();
        }

        Integer[] numbersUnsorted = sortedNumbers.toArray(new Integer[0]);

        Arrays.sort(numbersUnsorted);

        List<Integer> sortedList = Arrays.asList(numbersUnsorted);
        sortedNumbers.clear();

        sortedNumbers.addAll(sortedList);

        if (sortedNumbers.isEmpty()) {
            System.out.println(0);
        }else if (sortedNumbers.contains(command[2])) {
            System.out.println("true");
        } else {
            System.out.println(sortedNumbers.pop());
        }
    }
}
