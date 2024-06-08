package _05_Multidimentional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08_Wrong_Measurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrxParam = Integer.parseInt(scanner.nextLine());

        int[][] matrx = new int[matrxParam][];

        fillMatrix(matrx, scanner);

        int[] numberParams = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrxFixed = new int[matrxParam][matrx[0].length];

        int numberToFix = matrx[numberParams[0]][numberParams[1]];

        for (int row = 0; row < matrx.length; row++) {
            for (int col = 0; col < matrx[row].length; col++) {

                if (matrx[row][col] == numberToFix) {

                    matrxFixed[row][col] = getSum(matrx, row, col, matrxParam, matrx[row].length, numberToFix);

                } else {
                    matrxFixed[row][col] = matrx[row][col];
                }
            }
        }

        for (int[] ints : matrxFixed) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));
        }

    }

    public static int up(int[][] matrx, int row, int col, int numberToFix) {
        if (row > 0) {
            row--;
            if (matrx[row][col] != numberToFix) {
                return matrx[row][col];
            }
        }
        return 0;
    }

    public static int down(int[][] matrx, int row, int col, int matrxDimention, int numberToFix) {
        if (row < matrxDimention - 1) {
            row++;
            if (matrx[row][col] != numberToFix) {
                return matrx[row][col];
            }
        }
        return 0;
    }

    public static int left(int[][] matrx, int row, int col, int numberToFix) {
        if (col > 0) {
            col--;
            if (matrx[row][col] != numberToFix) {
                return matrx[row][col];
            }
        }
        return 0;
    }

    public static int right(int[][] matrx, int row, int col, int matrxDimention, int numberToFix) {
        if (col < matrxDimention - 1) {
            col++;
            if (matrx[row][col] != numberToFix) {
                return matrx[row][col];
            }
        }
        return 0;
    }

    public static int getSum(int[][] matrx, int row, int col, int matrxDimention, int rowLength,  int numberToFix) {
        return up(matrx, row, col, numberToFix) +
                down(matrx, row, col, matrxDimention, numberToFix) +
                left(matrx, row, col, numberToFix) +
                right(matrx, row, col, rowLength, numberToFix);
    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
    }

}
