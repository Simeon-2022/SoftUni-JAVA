package _04_Stacks_And_Queues_Exercise;

import java.util.Scanner;

public class _06_Recursive_Fibonacci {
    private static long[] fiboSeq;

    public static void main(String[] args) {
        int n = Integer.parseInt(String.valueOf(new Scanner(System.in).nextLine()));

        fiboSeq = new long[n + 1];
        System.out.println(getFiboOf(n));

    }

    public static long getFiboOf(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (fiboSeq[n] != 0) {

            return fiboSeq[n];
        }

        long newFibo = getFiboOf(n - 1) + getFiboOf(n - 2);

        fiboSeq[n] = newFibo;

        return newFibo;
    }
}
