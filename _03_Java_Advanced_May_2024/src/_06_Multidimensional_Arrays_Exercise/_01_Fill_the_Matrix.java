package _06_Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _01_Fill_the_Matrix {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[] init = scanner.nextLine().split(", ");
        int matrxParam = Integer.parseInt(init[0]);
        String type = init[1];

        int[][] matrx = new int[matrxParam][matrxParam];

        if (type.equals("A")) {
            pattern_A(matrx, matrxParam);

        } else {
            pattern_B(matrx, matrxParam);

        }

        for (int[] ints : matrx) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));
        }
    }

    public static void pattern_A(int[][] matrx, int matrxParam) {

        for (int col = 0, counter = 1; col < matrx.length; col++) {
            for (int row = 0; row < matrx[col].length; row++) {
                matrx[row][col] = counter++;
            }
        }
    }

    public static void pattern_B(int[][] matrx, int matrxParam) {

        for (int col = 0, counter = 1, switchCount = 0; col < matrx.length; col++, switchCount++) {

            if (switchCount % 2 == 0) {
                for (int row = 0; row < matrx[col].length; row++) {
                    matrx[row][col] = counter++;
                }
            } else {
                for (int row = matrx[col].length - 1; row >= 0; row--) {
                    matrx[row][col] = counter++;
                }
            }
        }
    }
}
