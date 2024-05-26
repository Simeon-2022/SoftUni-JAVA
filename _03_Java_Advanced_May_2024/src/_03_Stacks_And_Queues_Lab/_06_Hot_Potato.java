package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _06_Hot_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int round = scanner.nextInt();
        ArrayDeque<String> names = new ArrayDeque<>();
        Collections.addAll(names, arr);

        while (names.size() > 1) {

            for (int i = 0; i < round; i++) {
                names.offerLast(names.removeFirst());
            }
            System.out.println("Removed " + names.removeLast());
        }
        System.out.println("Last is " + names.peek());
    }
}
