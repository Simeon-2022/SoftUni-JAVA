package _06_Multidimensional_Arrays_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");

        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);


        String[][] matrix = new String[row][col];
        fillmatrix(matrix);

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            int[] params = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            clearVertical(matrix, params[0], params[1], params[2]);
            clearHorizontal(matrix, params[0], params[1], params[2]);

            collateMatrix(matrix);
            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }


    private static void collateMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            String[] rowNumbers = new String[matrix[row].length];
            Arrays.fill(rowNumbers, " ");

            int index = 0;
            for (int col = 0; col < matrix[row].length; col++) {

                if (!matrix[row][col].equals(" ")) {
                    rowNumbers[index++] = matrix[row][col];

                }
            }
            System.arraycopy(rowNumbers, 0, matrix[row], 0, matrix[row].length);
        }
    }

    private static void clearHorizontal(String[][] matrix, int row, int col, int radius) {

        if (row < 0 || row > matrix.length - 1) {
            return;
        }

        int colStart = col - radius;
        int colEnd = col + radius;

        if (colStart < 0) {
            colStart = 0;
        }

        if (colEnd > matrix[0].length - 1) {
            colEnd = matrix[0].length - 1;
        }

        for (int i = colStart; i <= colEnd; i++) {

            matrix[row][i] = " ";
        }
    }

    private static void clearVertical(String[][] matrix, int row, int col, int radius) {

        if (col < 0 || col > matrix[0].length - 1) {
            return;
        }

        int rowStart = row - radius;// -5 - 5 = -10 -> 0
        int rowEnd = row + radius;  // -5 + 5 = 0

        if (rowStart < 0) {
            rowStart = 0;
        }

        if (rowEnd > matrix.length - 1) {
            rowEnd = matrix.length - 1;
        }

        for (int i = rowStart; i <= rowEnd; i++) {

            matrix[i][col] = " ";
        }
    }

    private static void printMatrix(String[][] matrix) {
        List<Integer> currentRow = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!matrix[row][col].equals(" ")) {
                    currentRow.add(Integer.parseInt(matrix[row][col]));
                    //        System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.print(Arrays.toString(currentRow.toArray()).replaceAll("[\\[\\],]",""));
            currentRow.clear();
            if (row + 1 < matrix[row].length) {
                System.out.println();
            }
        }
    }

    private static void fillmatrix(String[][] matrix) {
        int counter = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(counter++);
            }
        }
    }
}
