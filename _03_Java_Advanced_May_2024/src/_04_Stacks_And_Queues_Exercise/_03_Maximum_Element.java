package _04_Stacks_And_Queues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class _03_Maximum_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> list = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (command[0] == 1) {
                list.push(command[1]);
            } else if (command[0] == 2) {
                list.pop();
            } else {
                System.out.println(list.stream().max(Integer::compare).orElse(0));
            }
        }
    }
}
