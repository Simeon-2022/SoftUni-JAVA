package _05_Multidimentional_Arrays_Lab;

import java.util.Scanner;

public class _07_Find_The_Real_Queen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrx = new char[8][];

        fillMatrix(matrx, scanner);


        for (int row = 0; row < matrx.length; row++) {
            for (int col = 0; col < matrx[row].length; col++) {

                if (matrx[row][col] == 'q') {
                    if (!isDiagonalFound(matrx, row, col) && !isCrossingFound(matrx, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    public static boolean isDiagonalFound(char[][] matrx, int startRow, int startCol) {

        for (int row = startRow + 1, col = startCol + 1; row < matrx.length && col < matrx.length; row++, col++) {

                if (matrx[row][col]  == 'q') {
                    return true;
            }
        }

        for (int row = startRow - 1, col = startCol - 1; row >= 0 && col >= 0; row--, col--) {

                if (matrx[row][col]  == 'q') {
                    return true;
                }
        }

        for (int row = startRow - 1, col = startCol + 1; row >= 0 && col < matrx.length; row--, col++) {

            if (matrx[row][col]  == 'q') {
                return true;
            }
        }

        for (int row = startRow + 1, col = startCol - 1; row < matrx.length && col >= 0; row++, col--) {

            if (matrx[row][col]  == 'q') {
                return true;
            }
        }

        return false;
    }

    public static boolean isCrossingFound(char[][] matrx, int startRow, int startCol) {

        for (int col = 0; col < matrx.length; col++) {

                if (matrx[startRow][col]  == 'q' && col != startCol) {
                    return true;
            }
        }

        for (int row = 0; row < matrx.length; row++) {

                if (matrx[row][startCol]  == 'q' && row != startRow) {
                    return true;
                }
        }
        return false;
    }

    public static void fillMatrix(char[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = scanner.nextLine().replace(" ","").toCharArray();
        }
    }


}
