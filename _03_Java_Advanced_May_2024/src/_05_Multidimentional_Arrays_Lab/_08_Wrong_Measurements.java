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
        int[][] matrxFixed = new int[matrxParam][];

        int numberToFix = matrx[numberParams[0]][numberParams[1]];

        for (int row = 0; row < matrx.length; row++) {
            for (int col = 0; col < matrx[row].length; col++) {

                if (matrx[row][col] == numberToFix) {


                }
            }
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

    public static int down (int[][] matrx, int row, int col, int matrxDimention, int numberToFix) {
        if (row < matrxDimention) {
            row++;
            if (matrx[row][col] != numberToFix) {
                return matrx[row][col];
            }
        }
        return 0;
    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
    }
}
