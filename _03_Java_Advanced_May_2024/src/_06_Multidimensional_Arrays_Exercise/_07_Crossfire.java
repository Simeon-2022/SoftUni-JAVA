package _06_Multidimensional_Arrays_Exercise;

import java.util.*;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");

        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);


        String[][] matrix = new String[row][col];
        fillMatrix(matrix);

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            int[] params = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            clearVertical(matrix, params[0], params[1], params[2]);
            clearHorizontal(matrix, params[0], params[1], params[2]);
            matrix = collateMatrix(matrix);

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    public static String[][] matrixInit(String[][] matrix) {

        String[][] newMatrix = new String[matrix.length][matrix[matrix.length - 1].length];

        for (int row = 0; row < newMatrix.length; row++) {
            Arrays.fill(newMatrix[row], "");
        }

        return newMatrix;
    }

    private static String[][] collateMatrix(String[][] matrix) {

        String[][] newMatrix = matrixInit(matrix);
        int idx = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] rowNumbers = new String[matrix[row].length];
            Arrays.fill(rowNumbers, "");

            int index = 0;
            for (int col = 0; col < matrix[row].length; col++) {

                if (!matrix[row][col].isEmpty()) {
                    rowNumbers[index++] = matrix[row][col];
                }
            }

            if (!rowNumbers[0].isEmpty()) {

                System.arraycopy(rowNumbers, 0, newMatrix[idx], 0, matrix[row].length);
                idx++;
            }
        }
       return newMatrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col < matrix[row].length; col++) {
                if (!matrix[row][col].isEmpty()) {
                    currentRow.add(Integer.parseInt(matrix[row][col]));
                }
            }
            if (!currentRow.isEmpty()) {
                System.out.print(Arrays.toString(currentRow.toArray()).replaceAll("[\\[\\],]",""));
                if (row + 1 < matrix[row].length) {
                    System.out.println();
                }
            }
        }
    }

    private static void clearHorizontal(String[][] matrix, int row, int col, int radius) {

        if (row < 0 || row > matrix.length - 1) {
            return;
        }

        int colStart = Math.max(0,col - radius);
        int colEnd = Math.min( col + radius, matrix[0].length - 1);

        for (int i = colStart; i <= colEnd; i++) {

            matrix[row][i] = "";
        }
    }

    private static void clearVertical(String[][] matrix, int row, int col, int radius) {

        if (col < 0 || col > matrix[0].length - 1) {
            return;
        }

        int rowStart = Math.max(0, row - radius);// -5 - 5 = -10 -> 0
        int rowEnd =  Math.min(row + radius, matrix.length - 1) ;  // -5 + 5 = 0

        for (int i = rowStart; i <= rowEnd; i++) {

            matrix[i][col] = "";
        }
    }

    private static void fillMatrix(String[][] matrix) {
        int counter = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(counter++);
            }
        }
    }
}
