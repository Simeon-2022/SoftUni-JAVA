package _05_Multidimentional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_Positions_Of {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowInit = scanner.nextInt();
        int colInit = scanner.nextInt();
        scanner.nextLine();
        int[][] matrx = new int[rowInit][colInit];

        fillMatrix(matrx, scanner);

        int number = scanner.nextInt();

        boolean isFound = false;

        for (int row = 0; row < matrx.length; row++) {

            for (int col = 0; col < matrx[row].length; col++) {

                if (number == matrx[row][col]) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    public static void fillMatrix(int[][] matrx, Scanner scanner) {

        for (int i = 0; i < matrx.length; i++) {
            matrx[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
