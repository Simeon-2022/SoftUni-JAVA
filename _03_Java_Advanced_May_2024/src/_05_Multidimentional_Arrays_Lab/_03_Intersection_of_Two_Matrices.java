package _05_Multidimentional_Arrays_Lab;

import java.util.Scanner;

public class _03_Intersection_of_Two_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowInit = scanner.nextInt();
        int colInit = scanner.nextInt();
        scanner.nextLine();

        String[][] matrx1 = new String[rowInit][colInit];
        String[][] matrx2 = new String[rowInit][colInit];

        fillMatrix(matrx1, scanner);
        fillMatrix(matrx2, scanner);

        for (int row = 0; row < matrx1.length; row++) {

            for (int col = 0; col < matrx1[row].length; col++) {

                if (!matrx1[row][col].equals(matrx2[row][col])) {
                    System.out.print('*' + " ");
                } else {
                    System.out.print(matrx1[row][col] + " ");

                }
            }
            System.out.println();
        }
    }
    public static void fillMatrix(String[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = scanner.nextLine().split(" ");
        }
    }
}
