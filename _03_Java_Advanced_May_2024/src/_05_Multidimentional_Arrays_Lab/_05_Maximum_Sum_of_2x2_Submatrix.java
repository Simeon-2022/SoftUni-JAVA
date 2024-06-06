package _05_Multidimentional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrxParams = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrx = new int[matrxParams[0]][matrxParams[1]];

        fillMatrix(matrx, scanner);

        int sum = Integer.MIN_VALUE;
        int[] subMatrx = new int[4];

        for (int row = 0; row < matrx.length - 1; row++) {
            for (int col = 0; col < matrx[row].length - 1; col++) {

                int currentSum = matrx[row][col] + matrx[row][col + 1] + matrx[row + 1][col] + matrx[row + 1][col + 1];

                if (currentSum > sum) {
                    sum = currentSum;
                    subMatrx[0] = matrx[row][col];
                    subMatrx[1] = matrx[row][col + 1];
                    subMatrx[2] = matrx[row + 1][col];
                    subMatrx[3] = matrx[row + 1][col + 1];
                }
            }
        }

        System.out.println(subMatrx[0] + " " + subMatrx[1]);
        System.out.println(subMatrx[2] + " " + subMatrx[3]);
        System.out.println(sum);
    }


    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        }
    }
}
