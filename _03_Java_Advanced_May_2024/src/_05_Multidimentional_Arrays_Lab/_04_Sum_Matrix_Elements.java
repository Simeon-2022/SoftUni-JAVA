package _05_Multidimentional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_Sum_Matrix_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrxParams = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrx = new int[matrxParams[0]][matrxParams[1]];

        fillMatrix(matrx, scanner);

        System.out.printf("%d%n%d%n%d", matrxParams[0],matrxParams[1],getSum(matrx));

    }

    public static int getSum(int[][] matrx) {
        int sum = 0;

        for (int row = 0; row < matrx.length; row++) {
            for (int col = 0; col < matrx[row].length; col++) {
                sum += matrx[row][col];
            }
        }
        return sum;
    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
