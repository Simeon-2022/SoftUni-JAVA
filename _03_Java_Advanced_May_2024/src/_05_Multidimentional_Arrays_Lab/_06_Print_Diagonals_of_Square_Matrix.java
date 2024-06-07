package _05_Multidimentional_Arrays_Lab;

import java.util.*;

public class _06_Print_Diagonals_of_Square_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrxParam = Integer.parseInt(scanner.nextLine());

        int[][] matrx = new int[matrxParam][];

        fillMatrix(matrx, scanner);

        int[] diag1 = new int[matrxParam];
        for (int col = 0; col < matrxParam; col++) {
            int row = col;
            diag1[col] = matrx[row][col];
        }

        int[] diag2 = new int[matrxParam];

        for (int row = matrxParam - 1, col = 0; row >= 0; row--, col++) {

            diag2[row] = matrx[row][col];
        }

        diag2 = reverseIntArray(diag2);

        System.out.println(Arrays.toString(diag1).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(diag2).replaceAll("[\\[\\],]", ""));

    }



    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
    }

    public static int[] reverseIntArray(int[] arrToReverse) {
        List<Integer> temp = new ArrayList<>(Arrays.stream(arrToReverse).boxed().toList());

        Collections.reverse(temp);
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
