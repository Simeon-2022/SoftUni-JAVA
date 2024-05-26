package _03_Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class _07_Math_Potato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int round = scanner.nextInt();
         PriorityQueue<String> names = new PriorityQueue<>();
        Collections.addAll(names, arr);

        int rounds = 0;
        while (names.size() > 1) {
            rounds++;
       /*     for (int i = 1; i <= round; i++) {

                names.offer(names.poll());
            }*/
            if (isPrime(rounds)) {
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }
        }
        System.out.println("Last is " + names.peek());
    }

    public static boolean isPrime(int number) {
        boolean isNumberPrime = true;

        int counter = 0;

        if (number == 1) {
            return false;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (++counter > 2) {
                    isNumberPrime = false;
                    break;
                }
            }
        }
        return isNumberPrime;
    }
}

