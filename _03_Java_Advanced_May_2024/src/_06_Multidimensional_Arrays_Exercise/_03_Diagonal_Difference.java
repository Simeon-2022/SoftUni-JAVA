package _06_Multidimensional_Arrays_Exercise;

import java.util.*;

public class _03_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrxParam = Integer.parseInt(scanner.nextLine());

        int[][] matrx = new int[matrxParam][];

        fillMatrix(matrx, scanner);

        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < matrxParam; i++) {

            diag1 += matrx[i][i];
            diag2 += matrx[i][matrxParam - 1 - i];
        }

        System.out.println(Math.abs(diag1 - diag2));

    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
    }
}
