package _06_Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _06_String_Matrix_Rotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrx = new String[0][0];

        String input = scanner.nextLine();
        int index = 0;

        while (!"END".equals(input)) {

            matrx = matrixResize(matrx);
            matrx[index++] = input.split(" ");
            input = scanner.nextLine();
        }
        restructure(matrx);

    }

    public static String[][] matrixResize(String[][] mtrx) {
        String[][] newMtrx = new String[mtrx.length + 1][];

        if (mtrx.length > 0) {

            for (int row = 0; row < mtrx.length; row++) {
                newMtrx[row] = new String[mtrx[row].length];

                for (int col = 0; col < mtrx[row].length; col++) {

                    newMtrx[row][col] = mtrx[row][col];
                }
            }

        }
        return newMtrx;
    }


    public static void restructure(String[][] matrx) {

        int rowlen = Integer.MIN_VALUE;
        for (String[] strings : matrx) {
            if (rowlen < strings[0].length()) {
                rowlen = strings[0].length();
            }
        }

        for (int row = 0; row < matrx.length; row++) {
            if (matrx[row].length < rowlen) {

                String[] newRow = new String[rowlen];
                Arrays.fill(newRow, " ");

                for (int i = 0; i < matrx[row].length; i++) {
                    newRow[i] = matrx[row] [i].length();
                }
                matrx[row] = newRow;

            }
        }
    }
}
