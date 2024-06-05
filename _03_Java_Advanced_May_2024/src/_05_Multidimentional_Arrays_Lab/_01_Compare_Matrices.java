package _05_Multidimentional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrxParams = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrx1 = new int[matrxParams[0]][matrxParams[1]];

        fillMatrix(matrx1,scanner);

        matrxParams = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrx2 = new int[matrxParams[0]][matrxParams[1]];

        fillMatrix(matrx2,scanner);

        if (matrxCompare(matrx1, matrx2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");

        }
    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    public static boolean matrxCompare(int[][] matrx1,int[][] matrx2 ) {

        if (matrx1.length != matrx2.length) {
            return false;

        } else {
            for (int row = 0; row < matrx1.length; row++) {

                if (matrx1[row].length != matrx2[row].length) {
                    return false;

                } else {
                    for (int col = 0; col < matrx1[row].length; col++) {

                        if (matrx1[row][col] != matrx1[row][col]) {
                        return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
