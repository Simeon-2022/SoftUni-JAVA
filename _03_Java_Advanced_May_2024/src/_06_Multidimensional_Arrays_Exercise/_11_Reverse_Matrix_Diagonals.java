package _06_Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _11_Reverse_Matrix_Diagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[params[0]][params[1]];

        fillMatrix(matrix, scanner);

        for (int col = matrix[matrix.length - 1].length - 1; col >= 0; col--) {
            int row = matrix.length - 1;
            System.out.print(matrix[row][col] + " ");

            int currentRow = row - 1;
            int currentCol = col + 1;

            while (isInMatrix(matrix, currentRow, currentCol)) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow--;
                currentCol++;
            }
            System.out.println();
        }

        for (int row = matrix.length - 2; row >= 0; row--) {

            int currentRow = row;
            int currentCol = 0;

            while (isInMatrix(matrix, currentRow, currentCol)) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow--;
                currentCol++;
            }
            System.out.println();

        }
    }

    public static boolean isInMatrix(int[][] matrix, int currentRow, int currentCol) {

        return currentRow >= 0
                && currentRow < matrix.length
                && currentCol >= 0
                && currentCol < matrix[matrix.length - 1].length;
    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
