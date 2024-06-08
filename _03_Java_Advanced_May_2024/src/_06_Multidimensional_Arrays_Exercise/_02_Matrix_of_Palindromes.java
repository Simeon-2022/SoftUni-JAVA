package _06_Multidimensional_Arrays_Exercise;

import java.util.Scanner;
public class _02_Matrix_of_Palindromes {
    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowInit = scanner.nextInt();
        int colInit = scanner.nextInt();

        String[][] matrx = new String[rowInit][colInit];

        for (int row = 0; row < matrx.length; row++) {
            for (int col = 0; col < matrx[row].length; col++) {

                matrx[row][col] = "" + alphabet[row] + alphabet[row + col] + alphabet[row];
            }
        }

        for (String[] strings : matrx) {
            System.out.println(String.join(" ", strings));
        }

    }
}
