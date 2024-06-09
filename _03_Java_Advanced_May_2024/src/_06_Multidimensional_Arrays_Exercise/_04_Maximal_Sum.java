package _06_Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrxParams = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrx = new int[matrxParams[0]][matrxParams[1]];

        fillMatrix(matrx, scanner);

        int sum = Integer.MIN_VALUE;
        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row <= matrx.length - 3; row++) {
            for (int col = 0; col <= matrx[row].length - 3; col++) {

                int currentSum = 0;

                for (int subRow = row; subRow < row + 3 ; subRow++) {

                    for (int subCol = col; subCol < col + 3 ; subCol++) {
                        currentSum += matrx[subRow][subCol];
                    }
                }

                if (currentSum > sum) {
                    sum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println("Sum = " + sum);

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrx[row][col] + " ");
            }
            System.out.println();
        }
    }


    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
    }
}